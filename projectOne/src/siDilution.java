public class siDilution {
    //"i" = initial, "f" = final
    private double iConcentration;
    private double iVolume;
    private double fConcentration;
    private double fVolume;

    //getters and setters:
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

    //method for calculation
    void calculation() {
        fConcentration = getIConcentration() * getIVolume()/getFVolume();
    }

    public double getFConcentration() {
        return fConcentration;
    }


}

