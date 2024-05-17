package com.example.kinopause

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class timeout_in_list_description : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timeout_in_list_description)

        val text_description: TextView = findViewById(R.id.text_description)

        var sceneTimeOutsDescription = intent.getStringExtra("description")

        text_description.text = sceneTimeOutsDescription

        val button_back: Button = findViewById(R.id.button_back_timeouts)
        button_back.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}