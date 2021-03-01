package com.talarczyk.view;

import com.talarczyk.entities.SunriseSunset;
import com.talarczyk.entities.Temp;
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

            String sunriseString = getTempString(sunriseSunset.getSunrise());

            String sunsetString = getTempString(sunriseSunset.getSunset());

            System.out.printf("%s | %s | %s \n", formattedDate, sunriseString, sunsetString);
        }
    }

    private String getTempString(Temp temp) {
        return temp != null
                ? String.valueOf(temp.getTime())
                : " - ";
    }
}
