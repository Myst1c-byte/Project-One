public record DilutionInputs(
        double iConcentration,
        double iVolume,
        double fVolume
) {
    public DilutionInputs {
        requirePositiveFinite(iConcentration, "Initial concentration");
        requirePositiveFinite(iVolume, "Initial volume");
        requirePositiveFinite(fVolume, "Final volume");

        if (fVolume < iVolume) {
            throw new IllegalArgumentException(
                    "Final volume cannot be smaller than initial volume."
            );
        }
    }

    private static void requirePositiveFinite(double value, String name) {
        if (!Double.isFinite(value) || value <= 0) {
            throw new IllegalArgumentException(
                    name + " must be a finite number greater than zero."
            );
        }
    }

    public static DilutionInputs fromStrings(
            String concentrationInput,
            String initialVolumeInput,
            String finalVolumeInput
    ) {
        return new DilutionInputs(
                parseNumber(concentrationInput, "Initial concentration"),
                parseNumber(initialVolumeInput, "Initial volume"),
                parseNumber(finalVolumeInput, "Final volume")
        );
    }

    private static double parseNumber(String input, String name) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(name + " is required.");
        }

        try {
            return Double.parseDouble(input.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    name + " must be a valid number."
            );
        }
    }
}