package com.talarczyk.logic.dataset;

import com.talarczyk.entities.Temp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class GenerateTempDataset {
    public static List<Temp> generate(int days) {
        int minutesInDay = 1440;
        int totalMeasurements = minutesInDay * days;
        List<Temp> dataset = new ArrayList<>();
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Double measurement = null;

        for (int i = 0; i < totalMeasurements; i++) {
            measurement = generateMeasurement(currentTimestamp);
            currentTimestamp = addValueToTimestamp(currentTimestamp, 60);

            Temp temp = new Temp(i, currentTimestamp, measurement);
            dataset.add(temp);
        }

        return dataset;
    }

    private static Double generateMeasurement(Timestamp time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time.getTime());

        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour >= 19 || hour <= 4) return null;
        else return getRandomMeasurement(-5, 5);
    }

    private static double getRandomMeasurement(double minRange, double maxRange) {
        Random rand = new Random();
        return (minRange) + (maxRange - (minRange)) * rand.nextDouble();
    }

    private static Timestamp addValueToTimestamp(Timestamp original, int seconds) {
        return new Timestamp(original.getTime() + (seconds * 1000L));
    }
}
