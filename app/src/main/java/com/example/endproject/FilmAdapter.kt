package com.example.endproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

interface ICellClickListener{
    fun onCellClickListener(film: Film)
}

class FilmAdapter(private val context: Context,
                  private val films: ArrayList<FilmsList>,
                  private val listener: ICellClickListener) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val filmPoster = itemView.findViewById<ImageView>(R.id.showIcon)
        val filmName = itemView.findViewById<TextView>(R.id.showTitle)
        val filmInformation = itemView.findViewById<TextView>(R.id.countryAndYear)
        val filmRatings = itemView.findViewById<TextView>(R.id.raitings)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rview_layout, parent, false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = films[0].films[position]
        holder.filmName.text = film.nameRu
        holder.filmInformation.text = "%s, %d".format(film.countries[0].country, film.year)
        holder.filmRatings.setText("Кинопоиск: %.2f, Imdb: %.2f".format(film.ratingKinopoisk, film.ratingImdb))
        holder.itemView.setOnClickListener {
            listener.onCellClickListener(film)
        }
        Glide.with(holder.itemView.context).load(film.posterUrl).into(holder.filmPoster)
    }

    override fun getItemCount(): Int = films.size

}