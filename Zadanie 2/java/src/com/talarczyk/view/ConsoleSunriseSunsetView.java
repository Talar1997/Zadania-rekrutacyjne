package com.talarczyk.view;

import com.talarczyk.entities.SunriseSunset;
import com.talarczyk.utils.FormatTimestamp;

import java.util.List;

public class ConsoleSunriseSunsetView implements View {
    public List<SunriseSunset> dataset;

    public ConsoleSunriseSunsetView(List<SunriseSunset> dataset) {
        this.dataset = dataset;
    }

    @Override
    public void display() {
        System.out.println("Dzień \t | Wschód \t | Zachód");

        for (SunriseSunset sunriseSunset : dataset) {
            String formattedDate = FormatTimestamp.format(sunriseSunset.getDay(), "yyyy-MM-dd");

            String sunriseString = sunriseSunset.getSunrise() != null
                    ? String.valueOf(sunriseSunset.getSunrise().getTime())
                    : " - ";

            String sunsetString = sunriseSunset.getSunset() != null
                    ? String.valueOf(sunriseSunset.getSunset().getTime())
                    : " - ";

            System.out.printf("%s | %s | %s \n", formattedDate, sunriseString, sunsetString);
        }
    }
}
