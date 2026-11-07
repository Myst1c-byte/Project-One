import static java.lang.IO.println;
import static java.lang.IO.readln;

public class siDilution {
    //"i" = initial, "f" = final
    private double iConcentration;
    private double fVolume;

    //getters and setters:

    public void setIConcentration(double iConcentration) {
        this.iConcentration = iConcentration;
    }

    public void setFVolume(double fVolume) {
        this.fVolume = fVolume;
    }

        //method for calculation
        void calculation(int numberOfDilutions) {
            double[] fConcentration = new double[numberOfDilutions];

            for (int i = 0; i < numberOfDilutions; i++) {
                fConcentration[i] = Double.parseDouble(
                        readln("Target Concentration " + (i + 1) + ": ")
                    );
            }

            for (double concentration : fConcentration) {
                double iVolume = (concentration * fVolume) / iConcentration;
                double solventVolume = fVolume - iVolume;

                if (iVolume < 0 || solventVolume < 0) {
                    println("Something went wrong with inputs.");
                } else {
                    System.out.printf("%.3f ml of substrate | %.3f ml of solvent%n",
                            iVolume, solventVolume);
                }
            }
        }
}

