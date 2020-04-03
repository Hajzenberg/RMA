package rs.raf.vezbe6.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.vezbe6.model.Car
import kotlin.random.Random

class RecyclerViewModel : ViewModel() {

    private val cars : MutableLiveData<List<Car>> = MutableLiveData()
    /* Komentar u vezi sa bagom u TeacherViewModel-u na drugom terminu vezbi.
     * S obzirom da nam je lista u ViewModel-u single source of truth, ako je prosledimo direktno u adapter
     * tako sto je setujemo kao value u LiveData, svaka njena izmena u ViewModelu, dodavanje, brisanje,
     * ce se direktno reflektovati i u adapteru jer je lista prosledjena po referenci.
     * Gde je problem? Kada ponovo submitujemo listu iz ViewModel-a, differ ce porediti dve iste liste,
     * zakljucice da nema promena i nece obavestiti RecyclerView da ponovo iscrta iteme,
     * i zato nismo videli item koji je dodat.
     *
     * Sa ovim se necete susretati u praksi, jer tada kad se zatraze podaci gotovo uvek dolazi nova
     * lista sto znaci da nece biti ovakvih problema.
     */
    private val carList : MutableList<Car> = mutableListOf()

    init {
        for (i in 1..100) {
            val car = Car(
                i,
                "https://electric-fun.com/wp-content/uploads/2020/01/sony-car-796x418-1.jpg",
                "manufacturer$i",
                "model$i"
            )
            carList.add(car)
        }
        val listToSubmit = mutableListOf<Car>()
        listToSubmit.addAll(carList)
        cars.value = listToSubmit
    }

    fun getCars() : LiveData<List<Car>> {
        return cars
    }

    fun filterCars(filter: String) {
        val filteredList = carList.filter {
            it.manufacturer.toLowerCase().startsWith(filter.toLowerCase())
        }
        cars.value = filteredList
    }

    fun addCar(pictureUrl: String, manufacturer: String, model: String) {
        val car = Car(
            Random.nextInt(101, 99999),
            pictureUrl,
            manufacturer,
            model
        )
        carList.add(car)
        val listToSubmit = mutableListOf<Car>()
        listToSubmit.addAll(carList)
        cars.value = listToSubmit
    }

}