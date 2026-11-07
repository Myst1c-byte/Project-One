public class seDilution {
    private double ratio;

    //getter and setters
    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
    public double getRatio() {
        return ratio;
    }

    //ratio calculation
    public double ratioCalculation(double stkParts, double fnlParts){
        setRatio(stkParts/fnlParts);
        return getRatio();
    }

    private double iConcentration;
    private double tVolume;
    private double[] fConcentration;

    private double diluentVolume;
    private double transferSolution;
    private double totalVolumeReq;

    //getters and setters
    public double getIConcentration() {
        return iConcentration;
    }
    public void setIConcentration(double iConcentration) {
        this.iConcentration = iConcentration;
    }
    public double getTVolume() {
        return tVolume;
    }
    public void setTVolume(double tVolume) {
        this.tVolume = tVolume;
    }
    public double[] getFConcentration() {
        return fConcentration;
    }
    public double[] setFConcentration(double[] fConcentration) {
        this.fConcentration = fConcentration;
        return fConcentration;
    }

    public double getDiluentVolume() {
        return diluentVolume;
    }
    public void setDiluentVolume(double diluentVolume) {
        this.diluentVolume = diluentVolume;
    }
    public double getTransferSolution() {
        return transferSolution;
    }
    public void setTransferSolution(double transferSolution) {
        this.transferSolution = transferSolution;
    }
    public double getTotalVolumeReq() {
        return totalVolumeReq;
    }
    public void setTotalVolumeReq(double totalVolumeReq) {
        this.totalVolumeReq = totalVolumeReq;
    }

    //calculation method
    public void calculate(int numberOfDilutionSteps) {
        double[] finalConcentration =
                new double[numberOfDilutionSteps + 1];

        setFConcentration(finalConcentration);

        for (int i = 0; i < numberOfDilutionSteps + 1; i++) {
            finalConcentration[i] =
                    getIConcentration() * Math.pow(getRatio(), i);
        }

        setTransferSolution(getTVolume() * getRatio());
        setDiluentVolume(getTVolume() - getTransferSolution());
        setTotalVolumeReq(numberOfDilutionSteps * getDiluentVolume());
    }
}
