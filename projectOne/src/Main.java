import java.util.Optional;
import java.util.Arrays;

import static java.lang.IO.readln;

void main(String[] args) {
    System.out.println("Type of Dilution?");
    System.out.println("a. Simple");
    System.out.println("b. N/A");
    System.out.println("c. N/A");

    String modeSelection = readln("Input: ");

    Optional<UserInputs.ModeSelection> modePicked = UserInputs.modeSelector(modeSelection);

    if (modePicked.isEmpty()) {
        System.out.println("Invalid");
        return;
    }

    UserInputs.ModeSelection mode = modePicked.get();

    var simpleDilution = new siDilution();

    switch (mode) {
        case SIMPLE_DILUTION -> {
            System.out.println("Simple dilution selected.");

            String questionOne = readln("Stock Concentration (M): ");
            String questionTwo = readln("Initial Volume (mL): ");
            String questionThree = readln("Final Volume (mL): ");

            String numberOfDilution = readln("Number of dilutions: ");
            int numberOfDilutions = Integer.parseInt(numberOfDilution);

            DilutionInputs inputs;


            try {
                inputs = DilutionInputs.fromStrings(
                        questionOne,
                        questionTwo,
                        questionThree
                );
            } catch (IllegalArgumentException exception) {
                IO.println("Invalid input: " + exception.getMessage());
                return;
            }

            simpleDilution.setIConcentration(inputs.iConcentration());
            simpleDilution.setIVolume(inputs.iVolume());
            simpleDilution.setFVolume(inputs.fVolume());

            simpleDilution.calculation(numberOfDilutions);

            IO.println(
                    "Final Concentration: "
                            + Arrays.toString(simpleDilution.getFConcentration())
                            + " M"
            );
        }
            case OPTION_B -> System.out.println("Option B selected.");
            case OPTION_C -> System.out.println("Option C selected.");

    }
}