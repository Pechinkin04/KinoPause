package com.example.kinopause

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class FilmActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)

        val image: ImageView = findViewById(R.id.film_poster)
        val title: TextView = findViewById(R.id.film_list_title)
        val viewing_time: TextView = findViewById(R.id.film_list_viewing_time)
        val release_date: TextView = findViewById(R.id.film_list_release_date)
        val genre: TextView = findViewById(R.id.film_list_genre)
        val border: ImageView = findViewById(R.id.border)
        val unborder: ImageView = findViewById(R.id.unborder)

        val image_after: ImageView = findViewById(R.id.image_after)

        var imageId = resources.getIdentifier(intent.getStringExtra("imageId"), "drawable", packageName)
        var imageAfterId = resources.getIdentifier(intent.getStringExtra("imageAfterId"), "drawable", packageName)
        var sceneAfterText = intent.getStringExtra("scene_after_description")

        val count_outs: TextView = findViewById(R.id.count_outs)

        title.text = intent.getStringExtra("filmTitle")
        viewing_time.text = intent.getStringExtra("viewing_time")
        release_date.text = intent.getStringExtra("release_date")
        genre.text = intent.getStringExtra("genre")

        image.setImageResource(imageId)
        border.setImageResource(imageId)
        imageId = resources.getIdentifier("@android:drawable/screen_background_dark_transparent", "drawable", packageName)
        unborder.setImageResource(imageId)
        image_after.setImageResource(imageAfterId)

        count_outs.text = intent.getStringExtra("count_outs")

        val button_afterimage: Button = findViewById(R.id.button_afterimage)
        button_afterimage.setOnClickListener {
            val intent = Intent(this@FilmActivity, afterScene::class.java)

            intent.putExtra("scene_after_description", sceneAfterText)

            this.startActivity(intent)
        }

        val count_out = intent.getStringExtra("count_outs")
        val array_timeouts = intent.getStringArrayListExtra("array_timeouts")
        val array_out_before = intent.getStringArrayListExtra("array_out_before")
        val array_out_description = intent.getStringArrayListExtra("array_out_description")
        val button_timeouts: Button = findViewById(R.id.button_timeouts)
        button_timeouts.setOnClickListener {
            val intent = Intent(this@FilmActivity, timeOuts::class.java)
            intent.putExtra("array_timeouts", array_timeouts)
            intent.putExtra("array_out_before", array_out_before)
            intent.putExtra("array_out_description", array_out_description)
            intent.putExtra("count_outs", count_out)
            this.startActivity(intent)
        }

        val button_back: Button = findViewById(R.id.button_back)
        button_back.setOnClickListener {
            val intent = Intent(this@FilmActivity, MainActivity::class.java)
            this.startActivity(intent)
        }
    }
}