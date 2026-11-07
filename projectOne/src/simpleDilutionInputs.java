import static java.lang.IO.readln;

public record simpleDilutionInputs(
         double iConcentration,
         double fVolume

) {
    //verifies the inputted values are positive
    private static void requirePositiveFinite(double value, String name) {
        if (!Double.isFinite(value) || value <= 0) {
            throw new IllegalArgumentException(
                    name + " must be a finite number greater than zero."
            );
        }
    }
    public simpleDilutionInputs {
        requirePositiveFinite(iConcentration, "Initial concentration");
        requirePositiveFinite(fVolume, "Final volume");
    }

    //ensures input entered is valid.
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
    public static simpleDilutionInputs fromStrings(
            String concentrationInput,
            String finalVolumeInput) {
        return new simpleDilutionInputs(
                parseNumber(concentrationInput, "Initial concentration"),
                parseNumber(finalVolumeInput, "Final volume")
        );
    }
}

