package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;


public class Retire implements Executable {
    private String[] data;
    private Repository repository;

    public Retire () {

    }

    public Retire (String[] data,Repository repository) {
        this.data = data;
        this.repository = repository;

    }

    @Override
    public String execute () throws ExecutionControl.NotImplementedException {
        String unitType = data[1];
        repository.removeUnit (unitType);

        return unitType + " retired!";
    }
}
