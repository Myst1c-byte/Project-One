public class siDilution {
    //"i" = initial, "f" = final
    private double iConcentration;
    private double iVolume;
    private double fConcentration;
    private double fVolume;

    public double getIConcentration() {
        return iConcentration;
    }
    public void setIConcentration(double iConcentration) {
        this.iConcentration = iConcentration;
    }

    public double getIVolume() {
        return iVolume;
    }
    public void setIVolume(double iVolume) {
        this.iVolume = iVolume;
    }

    public double getFVolume(){
        return fVolume;
    }
    public void setFVolume(double fVolume) {
        this.fVolume = fVolume;
    }

    //method for verification of input
    public boolean isValidIConcentration(double value) {
        return value > 0;
    }

    public boolean isValidIVolume(double value) {
        return value > 0;
    }

    public boolean isValidFVolume(double value) {
        return value > 0;
    }
    //method for calculation
    void calculation() {
        fConcentration = getIConcentration() * getIVolume()/getFVolume();
    }

    public double getFConcentration() {
        return fConcentration;
    }


}

