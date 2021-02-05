package com.talarczyk;

import com.talarczyk.entities.SunriseSunset;
import com.talarczyk.entities.Temp;
import com.talarczyk.logic.SunriseAndSunsetFindWithStreams;
import com.talarczyk.logic.SunriseAndSunsetStrategy;
import com.talarczyk.repository.Repository;
import com.talarczyk.repository.GeneratedTempRepository;
import com.talarczyk.view.ConsoleSunriseSunsetView;
import com.talarczyk.view.View;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Repository<Temp> repository = new GeneratedTempRepository();

        List<Temp> temps = repository.getAll();

        SunriseAndSunsetStrategy sunriseAndSunsetStrategy = new SunriseAndSunsetFindWithStreams();
        //SunriseAndSunsetStrategy sunriseAndSunsetStrategy = new SunriseAndSunsetFindRecursive();

        List<SunriseSunset> sunrisesAndSunsets = sunriseAndSunsetStrategy.find(temps);

        View output = new ConsoleSunriseSunsetView(sunrisesAndSunsets);
        output.display();
    }
}
