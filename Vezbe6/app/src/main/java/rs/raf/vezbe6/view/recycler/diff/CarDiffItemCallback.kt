package rs.raf.vezbe6.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.vezbe6.model.Car

class CarDiffItemCallback : DiffUtil.ItemCallback<Car>() {

    override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem.picture == newItem.picture &&
                oldItem.manufacturer == newItem.manufacturer &&
                oldItem.model == newItem.model
    }

}