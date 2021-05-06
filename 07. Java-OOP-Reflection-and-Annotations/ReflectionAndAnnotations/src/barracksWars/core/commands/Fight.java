package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import jdk.jshell.spi.ExecutionControl;


public class Fight implements Executable {
    public Fight () {
    }


    @Override
    public String execute ()throws ExecutionControl.NotImplementedException {
        return "fight";
    }
}
