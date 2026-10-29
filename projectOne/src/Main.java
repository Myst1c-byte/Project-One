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

    switch (mode) {
        case SIMPLE_DILUTION -> System.out.println("Simple dilution selected.");
        case OPTION_B -> System.out.println("Option B selected.");
        case OPTION_C -> System.out.println("Option C selected.");
    }
}