package Main;

import java.io.IOException;

public class BeachEntity {
    private float swellHeight;
    private float windSpeed;
    private String windDirection;

    public BeachEntity() {
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public void setSwellHeight(float swellHeight) {
        this.swellHeight = swellHeight;
    }

    public float getSwellHeight() {
        return this.swellHeight;
    }
}

