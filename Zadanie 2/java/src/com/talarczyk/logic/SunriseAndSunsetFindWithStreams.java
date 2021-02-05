package com.talarczyk.logic;

import com.talarczyk.entities.SunriseSunset;
import com.talarczyk.entities.Temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class SunriseAndSunsetFindWithStreams implements SunriseAndSunsetStrategy {
    public List<SunriseSunset> find(List<Temp> measurements) {
        Predicate<Temp> byMeasurement = measurement -> measurement.getMeasurement() != null;

        Map<String, List<Temp>> filterResult = measurements.stream()
                .filter(byMeasurement)
                .collect(groupingBy(Temp::getSimplifiedTime));

        var tempValues = new ArrayList<>(filterResult.values());

        return tempValues.stream()
                .map(this::createSunriseSunsetFromTempList)
                .sorted(this::sortSunriseSunset)
                .collect(Collectors.toList());
    }

    private int sortSunriseSunset(SunriseSunset temp1, SunriseSunset temp2) {
        return temp1.getDayTime() > temp2.getDayTime() ? 1 : -1;
    }

    private SunriseSunset createSunriseSunsetFromTempList(List<Temp> temps) {
        Temp sunrise = temps.get(0);
        Temp sunset = temps.get(temps.size() - 1);

        return new SunriseSunset(sunrise.getTime(), sunset, sunrise);
    }
}