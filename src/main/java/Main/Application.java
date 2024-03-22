package Main;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        Request forecastData = new Request();
        forecastData.getData();
    }
}
