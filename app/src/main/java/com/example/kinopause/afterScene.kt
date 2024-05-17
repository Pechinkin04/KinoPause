package com.example.kinopause

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class afterScene : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_scene)

        val text_after_scene: TextView = findViewById(R.id.text_after_scene)

        var sceneAfterDescription = intent.getStringExtra("scene_after_description")

        text_after_scene.text = sceneAfterDescription

        val button_back: Button = findViewById(R.id.button_back)
        button_back.setOnClickListener {
            //val intent = Intent(this@afterScene, FilmActivity::class.java)
            //this.startActivity(intent)
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        // Вызываем метод super.onBackPressed() для стандартного поведения кнопки "Back"
        super.onBackPressed()

        // Добавьте свой код здесь, если нужно выполнить дополнительные действия перед закрытием активности
    }
}