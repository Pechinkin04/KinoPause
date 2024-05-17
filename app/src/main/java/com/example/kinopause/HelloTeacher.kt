package com.example.kinopause

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HelloTeacher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_teacher)

        val button_back: Button = findViewById(R.id.button_back)
        button_back.setOnClickListener {
            val intent = Intent(this@HelloTeacher, MainActivity::class.java)
            this.startActivity(intent)
        }
    }
}