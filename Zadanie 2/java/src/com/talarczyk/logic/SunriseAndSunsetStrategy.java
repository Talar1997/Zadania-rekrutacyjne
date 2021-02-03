package com.talarczyk.logic;

import com.talarczyk.entities.SunriseSunset;
import com.talarczyk.entities.Temp;

import java.util.List;

public interface SunriseAndSunsetStrategy {
    List<SunriseSunset> find(List<Temp> measurements);
}
