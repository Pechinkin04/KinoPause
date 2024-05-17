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

class TimeOutsAdapter(var timeouts: List<TimeOutScene>, var context: Context) : RecyclerView.Adapter<TimeOutsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val time_exit: TextView = view.findViewById(R.id.time_exit)
        val out_text: TextView = view.findViewById(R.id.out_text)
        val out_description: TextView = view.findViewById(R.id.out_description)

        val button_description: Button = view.findViewById(R.id.button_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.timeout_in_list, parent, false)
        return TimeOutsAdapter.MyViewHolder(view)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.time_exit.text = timeouts[position].timeout
        holder.out_text.text = timeouts[position].scene_before
        holder.out_description.text = timeouts[position].description
        holder.out_description.text = ""

        holder.button_description.setOnClickListener {
            val intent = Intent(context, timeout_in_list_description::class.java)

            intent.putExtra("description", timeouts[position].description)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return timeouts.count()
    }
}