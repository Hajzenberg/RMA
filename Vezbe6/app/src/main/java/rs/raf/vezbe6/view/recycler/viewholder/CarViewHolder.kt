package rs.raf.vezbe6.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_car_list_item.*
import rs.raf.vezbe6.model.Car
import timber.log.Timber

class CarViewHolder(
    override val containerView: View,
    onItemClicked: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        containerView.setOnClickListener {
            onItemClicked.invoke(adapterPosition)
        }
    }

    fun bind(car: Car) {
        Picasso
            .get()
            .load(car.picture)
            .into(carPictureIv)
        manufacturerTv.text = car.manufacturer
        modelTv.text = car.model
    }
}