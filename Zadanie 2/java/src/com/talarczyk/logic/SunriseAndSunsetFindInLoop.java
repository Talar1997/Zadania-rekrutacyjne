package com.talarczyk.logic;

import com.talarczyk.entities.SunriseSunset;
import com.talarczyk.entities.Temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class SunriseAndSunsetFindInLoop implements SunriseAndSunsetStrategy {
    public List<SunriseSunset> find(List<Temp> measurements) {
        List<SunriseSunset> results;

        Predicate<Temp> byMeasurement = measurement -> measurement.getMeasurement() != null;

        Map<String, List<Temp>> filterResult = measurements.stream()
                .filter(byMeasurement)
                .collect(groupingBy(Temp::getSimplifiedTime));


        var tempValues = new ArrayList<>(filterResult.values());

        results = tempValues.stream()
                .map(this::createSunriseSunsetFromTempList)
                .sorted(this::sortSunriseSunset)
                .collect(Collectors.toList());

        return results;
    }

    private int sortSunriseSunset(SunriseSunset temp1, SunriseSunset temp2) {
        return temp1.getDay().getTime() > temp2.getDay().getTime() ? 1 : -1;
    }

    private SunriseSunset createSunriseSunsetFromTempList(List<Temp> temps) {
        SunriseSunset sunriseSunset = new SunriseSunset();

        Temp sunrise = temps.get(0);
        Temp sunset = temps.get(temps.size() - 1);

        sunriseSunset.setDay(sunrise.getTime());
        sunriseSunset.setSunrise(sunrise);
        sunriseSunset.setSunset(sunset);

        return sunriseSunset;
    }
}