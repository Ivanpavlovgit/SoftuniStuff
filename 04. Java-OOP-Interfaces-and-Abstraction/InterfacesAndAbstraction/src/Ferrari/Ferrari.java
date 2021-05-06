package Ferrari;

public class Ferrari implements Car {
    private String driverName;
    private static final String MODEL="488-Spider";

    protected Ferrari (String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes () {
        return "Brakes!";
    }

    @Override
    public String gas () {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString () {
        return String.format ("%s/%s/%s/%s",MODEL,brakes (),gas (),driverName);
    }
}
