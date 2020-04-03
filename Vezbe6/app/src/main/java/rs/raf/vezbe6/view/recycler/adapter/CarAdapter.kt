package rs.raf.vezbe6.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.vezbe6.R
import rs.raf.vezbe6.model.Car
import rs.raf.vezbe6.view.recycler.diff.CarDiffItemCallback
import rs.raf.vezbe6.view.recycler.viewholder.CarViewHolder

class CarAdapter(
    carDiffItemCallback: CarDiffItemCallback,
    private val onCarClicked: (Car) -> Unit) : ListAdapter<Car, CarViewHolder>(carDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_car_list_item, parent, false)
        return CarViewHolder(containerView) {
            val car = getItem(it)
            onCarClicked.invoke(car)
        }
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = getItem(position)
        holder.bind(car)
    }

}