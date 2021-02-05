import entities.SunriseSunset
import entities.Temp
import logic.sunriseAndSunset.SunriseAndSunsetFindEasiest
import logic.sunriseAndSunset.SunriseAndSunsetStrategy
import repository.GeneratedTempRepository
import repository.Repository

fun main() {
    val tempRepository: Repository<Temp> = GeneratedTempRepository()

    val temps: List<Temp> = tempRepository.getAll()

    val sunriseSunsetStrategy: SunriseAndSunsetStrategy = SunriseAndSunsetFindEasiest()

    val sunrisesAndSunsets: List<SunriseSunset> = sunriseSunsetStrategy.find(temps)

    //todo output here
}