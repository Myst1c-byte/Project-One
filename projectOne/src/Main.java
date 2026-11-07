import java.util.Optional;
import java.util.Locale;

import static java.lang.IO.readln;

void main(String[] args) {
    System.out.println("Type of Dilution?");
    System.out.println("a. Simple");
    System.out.println("b. Serial");
    System.out.println("c. N/A");

    String modeSelection = readln("Input: ");

    Optional<UserInputs.ModeSelection> modePicked =
            UserInputs.modeSelector(modeSelection);

    if (modePicked.isEmpty()) {
        System.out.println("Invalid");
        return;
    }

    UserInputs.ModeSelection mode = modePicked.get();

    var simpleDilution = new siDilution();
    var serialDilution = new seDilution();

    switch (mode) {
        case SIMPLE_DILUTION -> {
            System.out.println("Simple dilution selected.");

            String stockConcentration = readln("Stock Concentration (M): ");
            String finalVolume = readln("Final Volume (mL): ");

            String numberOfDilutionsInput = readln("Number of dilutions: ");
            int numberOfDilutions = Integer.parseInt(numberOfDilutionsInput);

            simpleDilutionInputs inputs;
            try {
                inputs = simpleDilutionInputs.fromStrings(
                        stockConcentration,
                        finalVolume
                );
            } catch (IllegalArgumentException exception) {
                IO.println("Invalid input: " + exception.getMessage());
                return;
            }

            simpleDilution.setIConcentration(inputs.iConcentration());
            simpleDilution.setFVolume(inputs.fVolume());

            simpleDilution.calculation(numberOfDilutions);
        }

        case SERIAL_DILUTION -> {
            System.out.println("Serial dilution selected.");

            String stockPartsInput = readln("Stock parts: ");
            String totalPartsInput = readln("Total parts: ");

            serialDilutionInputs inputs;
            try {
                inputs = serialDilutionInputs.fromStrings(
                        stockPartsInput,
                        totalPartsInput
                );
            } catch (IllegalArgumentException exception) {
                IO.println("Invalid input: " + exception.getMessage());
                return;
            }

            int stockParts = inputs.stockPart();
            int totalParts = inputs.finalPart();

            double ratio = serialDilution.ratioCalculation(
                    stockParts,
                    totalParts
            );

            String confirmation = readln(
                    "Confirm that (" + stockParts + ":" + totalParts
                            + ") is correct (y/n): "
            );

            String confirmed = confirmation.toUpperCase(Locale.ROOT);

            if (confirmed.equals("Y")) {
                String stockConcentrationInput =
                        readln("Stock Concentration (M): ");
                String dilutionStepsInput =
                        readln("Number of dilution steps: ");
                String totalVolumeInput =
                        readln("Total volume after mixing (mL): ");

                double stockConcentration =
                        Double.parseDouble(stockConcentrationInput);
                int numberOfDilutionSteps =
                        Integer.parseInt(dilutionStepsInput);
                double totalVolume =
                        Double.parseDouble(totalVolumeInput);

                serialDilution.setIConcentration(stockConcentration);
                serialDilution.setTVolume(totalVolume);

                serialDilution.calculate(numberOfDilutionSteps);

                double[] targetConcentrations =
                        serialDilution.getFConcentration();

                System.out.println("Concentrations:");

                for (int i = 0; i < numberOfDilutionSteps + 1; i++) {
                    System.out.print("Conc " + (i + 1) + ": ");
                    System.out.printf("%.5fM", targetConcentrations[i]);
                    System.out.print(" | ");
                }

                System.out.println();
                System.out.println(
                        serialDilution.getDiluentVolume()
                                + " mL of diluent to transfer"
                );
                System.out.println(
                        serialDilution.getTransferSolution()
                                + " mL of solution to transfer"
                );
                System.out.println();
                System.out.println(
                        serialDilution.getTotalVolumeReq()
                                + " mL of diluent needed in total"
                );
            }
        }

        case OPTION_C -> System.out.println("Option C selected.");
    }
}