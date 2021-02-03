package com.talarczyk.logic;

import com.talarczyk.entities.SunriseSunset;
import com.talarczyk.entities.Temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.groupingBy;

public class SunriseAndSunsetFindInLoop implements SunriseAndSunsetStrategy {
    public List<SunriseSunset> find(List<Temp> measurements) {
        List<SunriseSunset> results = new ArrayList<>();

        Predicate<Temp> byMeasurement = measurement -> measurement.getMeasurement() != null;

        Map<String, List<Temp>> result = measurements.stream()
                .filter(byMeasurement)
                .collect(groupingBy(Temp::getSimplifiedTime));


        for (Map.Entry<String, List<Temp>> entry : result.entrySet()) {
            SunriseSunset sunriseSunset = new SunriseSunset();

            List<Temp> value = entry.getValue();

            Temp sunrise = value.get(0);
            Temp sunset = value.get(value.size() - 1);

            sunriseSunset.setDay(sunrise.getTime());
            sunriseSunset.setSunrise(sunrise);
            sunriseSunset.setSunset(sunset);

            if (sunriseSunset.isValid()) results.add(sunriseSunset);
        }

        return results;
    }
}