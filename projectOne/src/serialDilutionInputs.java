public record serialDilutionInputs(int stockPart, int finalPart) {

    private static int parseInteger(String input, String name) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(name + " is required.");
        }

        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    name + " must be a valid whole number."
            );
        }
    }

    public static serialDilutionInputs fromStrings(
            String stockPart,
            String finalPart
    ) {
        int stock = parseInteger(stockPart, "Stock Part");
        int total = parseInteger(finalPart, "Total Part");

        if (stock > total) {
            throw new IllegalArgumentException(
                    "Stock part cannot be higher than final parts"
            );
        }

        return new serialDilutionInputs(stock, total);
    }
}