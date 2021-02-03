package com.talarczyk.logic;

import com.talarczyk.entities.SunriseSunset;
import com.talarczyk.entities.Temp;
import com.talarczyk.utils.FormatTimestamp;

import java.util.ArrayList;
import java.util.List;

public class SunriseAndSunsetFindInLoop implements SunriseAndSunsetStrategy {
    public List<SunriseSunset> find(List<Temp> measurements) {
        List<SunriseSunset> results = new ArrayList<>();

        for (int i = 0; i < measurements.size() - 1; i++) {
            SunriseSunset sunriseSunset = new SunriseSunset();
            Temp tail = measurements.get(i);
            Temp head = measurements.get(i + 1);

            sunriseSunset.setDay(tail.getTime());

            if (isSunrise(tail, head)) {
                sunriseSunset.setSunrise(head);
            }

            if (isSunset(tail, head)) {
                sunriseSunset.setSunset(tail);
            }

            if (sunriseSunset.isValid()) results.add(sunriseSunset);
        }

        return merge(results);
    }

    private boolean isSunset(Temp tail, Temp head) {
        return tail.measurement != null && head.measurement == null;
    }

    private boolean isSunrise(Temp tail, Temp head) {
        return tail.measurement == null && head.measurement != null;
    }

    public List<SunriseSunset> merge(List<SunriseSunset> sunriseSunsetList) {
        List<SunriseSunset> results = new ArrayList<>();

        for (int i = 0; i < sunriseSunsetList.size() - 1; i++) {
            SunriseSunset tail = sunriseSunsetList.get(i);
            SunriseSunset head = sunriseSunsetList.get(i + 1);

            String tailFormattedDate = FormatTimestamp.formatTimestamp(tail.getDay());
            String headFormattedDate = FormatTimestamp.formatTimestamp(head.getDay());

            if(tailFormattedDate.equals(headFormattedDate)){
                SunriseSunset merged = new SunriseSunset();
                merged.setDay(tail.getDay());
                merged.setSunset(head.getSunset());
                merged.setSunrise(tail.getSunrise());
                results.add(merged);
            }
        }

        return results;
    }
}