package bakery.repositories;

import bakery.repositories.interfaces.TableRepository;

import java.util.Collection;

public class TableRepositoryImpl implements TableRepository {
    @Override
    public Object getByNumber (int number) {
        return ta;
    }

    @Override
    public Collection getAll () {
        return null;
    }

    @Override
    public void add (Object o) {

    }
}
