package Task21Facade;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FacadeAPI {
    public String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException {
        // Step 1: Make the HTTP GET request
        StringBuilder content = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        } finally {
            con.disconnect();
        }

        // Step 2: Parse the JSON and extract the attribute value
        JsonObject jsonObject = JsonParser.parseString(content.toString()).getAsJsonObject();

        // Check for direct match
        if (jsonObject.has(attributeName)) {
            return jsonObject.get(attributeName).getAsString();
        }

        // Check for nested match (e.g., "rates.USD")
        if (jsonObject.has("rates")) {
            JsonObject rates = jsonObject.getAsJsonObject("rates");
            if (rates.has(attributeName)) {
                return rates.get(attributeName).getAsString();
            }
        }

        // If attribute not found, throw an exception
        throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in the JSON response.");
    }
}
