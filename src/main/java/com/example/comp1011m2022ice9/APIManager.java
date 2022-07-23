package com.example.comp1011m2022ice9;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIManager {
    /******************singleton*****************/
    // Step 1. private static instance member variable
    private static APIManager m_instance = null;

    // Step 2. make the default constructor private
    private APIManager() {}

    // Step 3. Create a public static entry point / instance method
    public static APIManager Instance() {

        //Step 4. Check if the private instance member variable is null
        if (m_instance == null) {

            //Step 5. Initiate a new DBMember instance
            m_instance = new APIManager();
        }
        return m_instance;
    }

    /*************************/
    public Movie getMovieFromOMDBByTitleAndYear(String title, String year) {
        // Step 1. Construct your URL
        String APIKey = "769bf72f";
        title = title.replace(" ", "%20");
        String URL = "https://www.omdbapi.com/?apikey=" + APIKey + "&t=" + title + "&y=" + year;

        // Step 2. Create a Client Object
        HttpClient client = HttpClient.newHttpClient();

        // Step 3. Create a Request Object
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(URL)).build();

        try {
            // Step 4. Create a Response object
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Step 5. Create a Gson object
            Gson gson = new Gson();

            // Step 6. Deserialize the data using the fromJSON method
            return gson.fromJson(response.body(), Movie.class);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }
}
