package ShoppingSpree;

public class NameValidator {
    private NameValidator () {
    }

    public static boolean isValidName (String name) {
        return name != null && !name.trim ().isEmpty ();
    }
}
