package ormFramework.core;

import bg.codexio.customOrmDemo.entity.Employee;
import ormFramework.annotation.Column;
import ormFramework.annotation.Entity;
import ormFramework.annotation.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class EntityManagerImpl implements EntityManager {

    private final Connection connection;

    public EntityManagerImpl (Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T> T findById (int id,Class<T> type) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        String tableName = type.getAnnotation (Entity.class).tableName ();
        String idColumnName = Arrays.stream (type.getDeclaredFields ())
                .filter (f -> f.isAnnotationPresent (Id.class))
                .findFirst ()
                .orElseThrow ()
                .getName ();

        PreparedStatement stmt
                = this.connection.prepareStatement ("SELECT * FROM " + tableName + " WHERE " + idColumnName + " = ?");

        stmt.setInt (1,id);

        T entity = (T) type.getConstructors ()[0].newInstance ();


        ResultSet rs = stmt.executeQuery ();
        if (!rs.next ()) {
            return null;
        }

        for (Field field : type.getDeclaredFields ()) {
            if (field.isAnnotationPresent (Column.class)) {
                Column columnInfo = field.getAnnotation (Column.class);
                String setterName = "set" + ((field.getName ().charAt (0) + "").toUpperCase ()) + field.getName ().substring (1);
                if (field.getType ().equals (String.class)) {
                    String s = rs.getString (columnInfo.name ());
                    type.getMethod (setterName,String.class).invoke (entity,s);
                } else {
                    int s = rs.getInt (columnInfo.name ());
                    type.getMethod (setterName,field.getType ()).invoke (entity,s);
                }
            } else if (field.isAnnotationPresent (Id.class)) {
                String setterName = "set" + ((field.getName ().charAt (0) + "").toUpperCase ()) + field.getName ().substring (1);
                type.getMethod (setterName,int.class).invoke (entity,id);
            }
        }


        return entity;
    }

    @Override
    public <T> boolean persists (T entity) throws IllegalAccessException {
        Field idField = getIdFieldFromEntity (entity);
        idField.setAccessible (true);
        int id = (int) idField.get (entity);

        if (id == 0) {
            return doInsert (entity);
        } else {
            //doUpdate(id,entity);
        }

        System.out.println ();

        return false;
    }

    private <T> boolean doInsert (T entity) {
        String tableName  = getTableNameByEntity (entity);
        String fieldNames = getFieldNamesBy (entity.getClass ());
        String fieldValues =getFieldValuesAsString(entity);
                System.out.println ();
        String query = String.format ("INSERT INTO %s (%s) VALUES (%S) ",tableName,fieldNames);
        return true;
    }

    private <T> String getFieldValuesAsString (T entity) {
        Arrays.stream(entity
                .getClass ()
                .getDeclaredFields ())
                .filter (field -> field.isAnnotationPresent (Column.class))
                .map (field -> {
                    return getValueToString(field,entity);
                })


        return null;
    }

    private String getFieldNamesBy (Class<?> aClass) {
        return Arrays.stream (aClass.getDeclaredFields ())
                .filter (field -> field.isAnnotationPresent (Column.class))
                .map (field -> {
                    return field.getAnnotation (Column.class).name ();
                }).collect (Collectors.joining (" ,"));
    }

    private <T> String getTableNameByEntity (T entity) {
        return entity
                .getClass ()
                .getAnnotation (Entity.class)
                .tableName ();
    }

    private <T> Field getIdFieldFromEntity (T entity) {

        return Arrays.stream (entity
                .getClass ()
                .getDeclaredFields ())
                .filter (field -> field.isAnnotationPresent (Id.class))
                .findFirst ()
                .orElseThrow (() -> new UnsupportedOperationException ("Entity doesn't have ID !"));
    }
}
