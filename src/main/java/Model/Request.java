package Model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.*;

public class Request {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("http://api.weatherapi.com/v1/marine.json?key=497fddaca7ef43389d3181614241103&q=Sagres"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // calls response body (all data in list)
        JSONObject object = new JSONObject(response.body());

        // calls forecastday from the response body (second object list)
        JSONArray forecastday = object.getJSONObject("forecast").getJSONArray("forecastday");

        // calls hour from forecast list (third object in list)
        JSONArray hour = forecastday.getJSONObject(0).getJSONArray("hour");

        // Prints swell height in feet!
        float swell_ht_ft = hour.getJSONObject(0).getFloat("swell_ht_ft");
        System.out.println(swell_ht_ft);

        float swell_ht_test = hour.getJSONObject(1).getFloat("swell_ht_ft");
        System.out.println(swell_ht_test);
        // the index 0, 1 are the times. 00:00, 01:00, need to fix that it calls all the times.

/*
        System.out.println(response.body());
        System.out.println(response.headers().map());

*/

    }
}

/*
Common pattern using HTTP client libraries:
1. Create an instance of the HTTP client.
2. Create a request object for sending the HTTP request.
3. Make a HTTP call to send a request either synchronous or asynchronous.
4. Process the HTTP response received in the previous step.
 */

