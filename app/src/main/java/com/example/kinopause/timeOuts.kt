package com.example.kinopause

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class timeOuts : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_outs)

        val timeOutsList: RecyclerView = findViewById(R.id.time_outs_list)
        val time_outs = intent.getStringArrayListExtra("array_timeouts")
        val out_before = intent.getStringArrayListExtra("array_out_before")
        val out_description = intent.getStringArrayListExtra("array_out_description")
        val count_outs = intent.getStringExtra("count_outs")

        val timeouts = arrayListOf<TimeOutScene>()
        //for (i in 0 until count_outs!!){
          //  timeouts.add(TimeOutScene(time_outs!![i], out_before!![i], out_description!![i]))
        //}
        if (count_outs != null) {
            for (i in 0 until count_outs.toInt()) {
                val time_out = TimeOutScene(time_outs!![i], out_before!![i], out_description!![i])
                timeouts.add(time_out)
            }
        }

        timeOutsList.layoutManager = LinearLayoutManager(this)
        timeOutsList.adapter = TimeOutsAdapter(timeouts, this)

        val button_back: Button = findViewById(R.id.button_back_activity_film)
        button_back.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}