import java.util.Optional;

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

            String questionOne = readln("Initial Concentration (M): ");
            double iConcentration = Double.parseDouble(questionOne);

            if (!simpleDilution.isValidIConcentration(iConcentration)) {
                IO.println("Invalid Initial Concentration");
                return;
            }

            simpleDilution.setIConcentration(iConcentration);

            String questionTwo = readln("Initial Volume (mL): ");
            double iVolume = Double.parseDouble(questionTwo);

            if (!simpleDilution.isValidIVolume(iVolume)) {
                IO.println("Invalid Initial Volume");
                return;
            }

            simpleDilution.setIVolume(iVolume);

            String questionThree = readln("Final Volume (mL): ");
            double fVolume = Double.parseDouble(questionThree);

            if (!simpleDilution.isValidFVolume(iVolume)) {
                IO.println("Invalid Final Volume");
                return;
            }

            simpleDilution.setFVolume(fVolume);


            simpleDilution.calculation();

            double finalConcentration = simpleDilution.getFConcentration();
            IO.println("Final Concentration: " + finalConcentration);
        }


        case OPTION_B -> System.out.println("Option B selected.");
        case OPTION_C -> System.out.println("Option C selected.");
    }
}