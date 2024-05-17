package com.example.kinopause

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class FilmsAdapter(var films: List<Film>, var context: Context) : RecyclerView.Adapter<FilmsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.film_poster)
        val title: TextView = view.findViewById(R.id.film_list_title)
        val viewing_time: TextView = view.findViewById(R.id.film_list_viewing_time)
        val release_date: TextView = view.findViewById(R.id.film_list_release_date)
        val genre: TextView = view.findViewById(R.id.film_list_genre)
        val border: ImageView = view.findViewById(R.id.border)
        val unborder: ImageView = view.findViewById(R.id.unborder)

        val btn: Button = view.findViewById(R.id.film_list_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = films[position].title
        holder.viewing_time.text = films[position].viewing_time
        holder.release_date.text = films[position].release_date
        holder.genre.text = films[position].genre

        var imageId = context.resources.getIdentifier(
            films[position].image, "drawable", context.packageName
        )

        holder.image.setImageResource(imageId)
        holder.border.setImageResource(imageId)
        imageId = context.resources.getIdentifier("@android:drawable/screen_background_dark_transparent", "drawable", context.packageName)
        holder.unborder.setImageResource(imageId)

        holder.btn.setOnClickListener {
            val intent = Intent(context, FilmActivity::class.java)

            intent.putExtra("filmTitle", films[position].title)
            intent.putExtra("viewing_time", films[position].viewing_time)
            intent.putExtra("release_date", films[position].release_date)
            intent.putExtra("genre", films[position].genre)
            intent.putExtra("imageId", films[position].image)
            intent.putExtra("imageAfterId", films[position].scene_after)
            intent.putExtra("scene_after_description", films[position].description)
            intent.putExtra("count_outs", films[position].count_outs.toString())
            intent.putExtra("array_timeouts", films[position].time_outs)
            intent.putExtra("array_out_before", films[position].outs_before)
            intent.putExtra("array_out_description", films[position].outs_description)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return films.count()
    }
}