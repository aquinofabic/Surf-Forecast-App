package Main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.*;

public class Request {
    public void getData() throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("http://api.weatherapi.com/v1/marine.json?key=497fddaca7ef43389d3181614241103&q=Sagres"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // calls response body (all data in a list containing more lists and arrays)
        JSONObject object = new JSONObject(response.body());


        // Note in JSON format, objects are surrounded by {}, arrays are [].
        // For example, "forecast":{...,but "forecastday": [{
        JSONArray hour = object
                .getJSONObject("forecast")
                .getJSONArray("forecastday")
                .getJSONObject(0)
                .getJSONArray("hour");


        BeachEntity beach = new BeachEntity();

        // Prints following data at each hour of the day.
        int i = 0;
        for (hour.getJSONObject(i); i < hour.length(); i++) {
            float swellHtFt = hour.getJSONObject(i).getFloat("swell_ht_ft");
            float windSpeedKph = hour.getJSONObject(i).getFloat("wind_kph");
            String windDirection = hour.getJSONObject(i).getString("wind_dir");

            beach.setSwellHeight(swellHtFt);
            beach.setWindSpeed(windSpeedKph);
            beach.setWindDirection(windDirection);

            System.out.println(i + ":00");
            System.out.println(swellHtFt + "ft");
            System.out.println(windSpeedKph + "Kph");
            System.out.println(windDirection);
            System.out.println();

        }
    }
}

/*
Common pattern using HTTP client libraries:
1. Create an instance of the HTTP client.
2. Create a request object for sending the HTTP request.
3. Make a HTTP call to send a request either synchronous or asynchronous.
4. Process the HTTP response received in the previous step.
 */

