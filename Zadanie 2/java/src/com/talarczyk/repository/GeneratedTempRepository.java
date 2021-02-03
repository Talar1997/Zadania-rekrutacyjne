package com.talarczyk.repository;

import com.talarczyk.entities.Temp;
import com.talarczyk.logic.dataset.GenerateTempDataset;

import java.util.List;

public class GeneratedTempRepository implements Repository<Temp> {
    @Override
    public List<Temp> getAll() {
        return GenerateTempDataset.generate(3);
    }
}
