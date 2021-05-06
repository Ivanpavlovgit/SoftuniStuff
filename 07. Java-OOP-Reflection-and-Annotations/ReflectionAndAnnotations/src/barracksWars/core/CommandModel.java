package barracksWars.core;

import barracksWars.interfaces.CommandInterpreter;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandModel implements CommandInterpreter {
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandModel (Repository repository,UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand (String[] data,String commandName) {
        Executable executable;
        commandName = Character.toUpperCase (commandName.charAt (0)) + commandName.substring (1);
        try {
            Class<? extends Executable> clazz =
                    (Class<? extends Executable>) Class.forName ("barracksWars.core.commands." + commandName);
            Constructor<? extends Executable> ctor =
                    clazz.getDeclaredConstructor ();
            executable = ctor.newInstance ();

            injectFields (executable,data);


        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            throw new IllegalStateException (e);
        }


        return executable;
    }
//TODO FINISH THIS
    private void injectFields (Executable executable,String[] data) throws IllegalAccessException {
        Field[] declaredFields = executable.getClass ().getDeclaredFields ();
        for (Field thiField : declaredFields) {
            thiField.setAccessible (true);
            if (thiField.getType () == String[].class) {
                thiField.set (thiField,data);
            }
        }
    }
}
