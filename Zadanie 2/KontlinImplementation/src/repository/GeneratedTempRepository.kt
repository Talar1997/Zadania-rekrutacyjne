package repository

import entities.Temp
import repository.generator.GenerateTempDataset

class GeneratedTempRepository : Repository<Temp>{
    override fun getAll(): List<Temp> {
        return GenerateTempDataset.generate(25)
    }
}