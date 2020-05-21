package rs.raf.vezbe11.presentation.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.vezbe11.data.models.Movie

class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.title == newItem.title
    }

}