import java.util.Locale;
import java.util.Optional;

public class UserInputs {

    public enum ModeSelection {
        SIMPLE_DILUTION('a'),
        OPTION_B('b'),
        OPTION_C('c');

        private final char inputOption;

        ModeSelection(char inputOption) {
            this.inputOption = inputOption;
        }

        public static Optional<ModeSelection> fromInput(String input) {
            if (input == null) {
                return Optional.empty();
            }

            String cleaned = input.trim().toLowerCase(Locale.ROOT);

            if (cleaned.length() != 1) {
                return Optional.empty();
            }

            char choice = cleaned.charAt(0);

            for (ModeSelection mode : values()) {
                if (mode.inputOption == choice) {
                    return Optional.of(mode);
                }
            }
            return Optional.empty();
        }
    }

    public static Optional<ModeSelection> modeSelector(String input) {
        return ModeSelection.fromInput(input);
    }


    




}