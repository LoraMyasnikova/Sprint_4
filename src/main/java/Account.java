public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name == null) {
            return false;
        }

        return checkNameHasValidLength() && !checkNameHasBlankInBeginningOrInEnd() && checkNameContainsOneBlank();
    }

    private boolean checkNameHasValidLength() {
        return name.length() >= 3 && name.length() <= 19;
    }

    private boolean checkNameHasBlankInBeginningOrInEnd() {
        char nameFirstSymbol = name.charAt(0);
        boolean nameFirstSymbolIsBlank = String.valueOf(nameFirstSymbol).isBlank();

        char nameLastSymbol = name.charAt(name.length() - 1);
        boolean nameLastSymbolIsBlank = String.valueOf(nameLastSymbol).isBlank();

        return nameFirstSymbolIsBlank || nameLastSymbolIsBlank;
    }

    private boolean checkNameContainsOneBlank() {
        String nameTrimmed = name.trim();
        int countBlanks = 0;

        for (int i = 0; i < nameTrimmed.length(); i++) {
            if (String.valueOf(nameTrimmed.charAt(i)).isBlank()) {
                countBlanks++;
            }
        }

        return countBlanks == 1;
    }
}