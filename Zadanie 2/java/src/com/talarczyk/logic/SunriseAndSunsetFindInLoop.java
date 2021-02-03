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

        Map<String, List<Temp>> filterResult = measurements.stream()
                .filter(byMeasurement)
                .collect(groupingBy(Temp::getSimplifiedTime));


        var tempValues = new ArrayList<>(filterResult.values());

        tempValues.forEach(value -> {
            SunriseSunset sunriseSunset = new SunriseSunset();

            Temp sunrise = value.get(0);
            Temp sunset = value.get(value.size() - 1);

            sunriseSunset.setDay(sunrise.getTime());
            sunriseSunset.setSunrise(sunrise);
            sunriseSunset.setSunset(sunset);

            if (sunriseSunset.isValid()) results.add(sunriseSunset);
        });

        results.sort((temp1, temp2) -> temp1.getDay().getTime() > temp2.getDay().getTime() ? 1 : -1);

        return results;
    }
}