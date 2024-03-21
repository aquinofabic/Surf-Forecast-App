package Main;

public class Data {
    private double swellHeightFt;

    private double windSpeedKph;
    private String windDirection;

    public Data() {
        this.swellHeightFt = 0;
/*        this.windSpeedKph = 0;
        this.windDirection = "";*/
    }

    // Getter
    public double getSwellHeightFt() {
        return this.swellHeightFt;
    }
    // Setter

    public void setSwellHeightFt(float swellHeightFt) {
        this.swellHeightFt = swellHeightFt;
    }
}

