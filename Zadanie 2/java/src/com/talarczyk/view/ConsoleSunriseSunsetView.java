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
        for (SunriseSunset sunriseSunset : dataset) {
            String formattedDate = FormatTimestamp.formatTimestamp(sunriseSunset.getDay());
            System.out.print(formattedDate + " | ");
            if (sunriseSunset.getSunrise() != null) {
                System.out.print(sunriseSunset.getSunrise().getTime() + " | ");
            } else {
                System.out.print("-\t" + " | ");
            }

            if (sunriseSunset.getSunset() != null) {
                System.out.print(sunriseSunset.getSunset().getTime() + " | ");
            } else {
                System.out.print("-\t" + " | ");
            }

            System.out.println();
        }
    }
}
