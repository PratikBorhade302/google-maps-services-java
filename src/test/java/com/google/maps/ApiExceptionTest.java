package com.google.maps;


import com.google.maps.errors.ApiException;
import com.google.maps.errors.OverDailyLimitException;
import com.google.maps.errors.OverQueryLimitException;
import com.google.maps.model.GeocodingResult;
import jdk.internal.org.jline.utils.Log;
import org.junit.Test;

import java.io.IOException;

public class ApiExceptionTest {

    public static void main(String[] args) {
        try {
            // TODO: 25-11-2020 generate APi key
            GeoApiContext geoApiContext = new GeoApiContext.Builder().apiKey(new String("AIzaSyDsqVv4EGJAfk8Ha4H0Cofz5I53dgZq3M4")).build();
            String address="abb";
            /*GeocodingResult[] results =*/  GeocodingApi.geocode(geoApiContext, address).await();
        } catch (ApiException e) {

            if (e instanceof OverDailyLimitException) {

               // Log.warn("The daily query limit has been reached for the apiKey {}", geocodingModule.getApiKey());
                System.out.println("The daily query limit has been reached for the apiKey {}");
            } else if (e instanceof OverQueryLimitException) {

               // Log.warn("A rate limit has been reached for the apiKey {}, please try again in 1 minute", geocodingModule.getApiKey());
                System.out.println("A rate limit has been reached for the apiKey {}, please try again in 1 minute");
            } else {
              //  Log.error("An API exception occurred while trying to geocode {} with the apiKey {}", address,  apiKey, e);
                System.out.println("An API exception occurred while trying to geocode {} with the apiKey {}");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
