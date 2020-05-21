package rs.raf.vezbe11.presentation.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_item_movie.*
import rs.raf.vezbe11.data.models.Movie

class MovieViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(movie: Movie) {
        titleTv.text = movie.title
    }

}