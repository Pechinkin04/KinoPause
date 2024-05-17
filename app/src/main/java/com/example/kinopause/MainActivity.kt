package com.example.kinopause

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.io.IOException
import java.io.InputStream
import java.nio.file.Paths
import java.io.BufferedReader


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_hello:Button = findViewById(R.id.button_hello)
        button_hello.setOnClickListener {
            val intent = Intent(this@MainActivity, HelloTeacher::class.java)
            this.startActivity(intent)
        }


        val filmsList: RecyclerView = findViewById(R.id.films_to_pick)
        //val films = arrayListOf<Film>()
        val films = mutableListOf<Film>()


        val myTextView = findViewById<TextView>(R.id.textView)

        // A string variable to store the text from the text file
        val myOutput: String

        // Declaring an input stream to read data
        val myInputStream: InputStream

        // Try to open the text file, reads
        // the data and stores it in the string
        try {
            myInputStream = assets.open("MyText.txt")
            val size: Int = myInputStream.available()
            val buffer = ByteArray(size)
            myInputStream.read(buffer)
            myOutput = String(buffer)



            val dataArray = myOutput.split("\n").toTypedArray()

            // Использование массива данных
            /*for (item in dataArray) {
                // Действия с элементами массива
                myTextView.text = item
            }*/
            for (item in dataArray) {
                val values = item.split(";;").toTypedArray()
                val gratext = values[7]
                //myTextView.text = gratext
                // Создать объект Film и добавить его в список films
                val film = Film(
                    id = values[0].toInt(),
                    image = values[1],
                    title = values[2],
                    release_date = values[3],
                    viewing_time = values[4],
                    genre = values[5],
                    scene_after = values[6],
                    description = values[7],
                    count_outs = values[8].toInt(),
                    time_outs = ArrayList(values[9].split(";")),
                    outs_before = ArrayList(values[10].split(";")),
                    outs_description = ArrayList(values[11].split(";"))
                )
                films.add(film)
            }

        } catch (e: Exception) {
            // Exception
            e.printStackTrace()
        }



        films.add(Film(1, "barbie_poster_vertical_rus", "Барби", "21 Июля, 2023", "1 час 54 минуты", "Приключение | Комедия | Фантазия", "correct_yellow", getString(R.string.barbie_after_scene), 3, arrayListOf<String>("23:55 -> 3:30", "46:15 -> 3:25","1:22:30 -> 3:55"), arrayListOf<String>(getString(R.string.barbie_time_out_1), getString(R.string.barbie_time_out_2), getString(R.string.barbie_time_out_3)), arrayListOf<String>(getString(R.string.barbie_time_out_1_description), getString(R.string.barbie_time_out_2_description), getString(R.string.barbie_time_out_3_description))))
        films.add(Film(2, "spider_man_across_the_spider_ver", "Человек-Паук: Через вселенные", "2 июня, 2023", "2 часа 20 минут", "Экшен | Приключение | Анимация", "correct", getString(R.string.spider_man_after_scene), 3, arrayListOf<String>("26:05 -> 3:55", "38:20 -> 3:25", "1:33:50 -> 4:40"), arrayListOf<String>(getString(R.string.spider_man_time_out_1), getString(R.string.spider_man_time_out_2), getString(R.string.spider_man_time_out_3)), arrayListOf<String>(getString(R.string.spider_man_time_out_1_description), getString(R.string.spider_man_time_out_2_description), getString(R.string.spider_man_time_out_3_description))))
        films.add(Film(3, "oppenheimer_vertical_3158x5000", "Оппенгеймер", "21 июля, 2023", "3 часа 0 минут", "Биография | Драма | История", "correct_yellow", getString(R.string.oppenheimer_after_scene), 6, arrayListOf<String>("16:15 -> 3:55", "22:30 -> 2:00", "46:20 -> 3:40", "1:13:15 -> 3:30", "1:35:55 -> 3:35", "2:12:05 -> 4:30"), arrayListOf<String>(getString(R.string.oppenheimer_time_out_1), getString(R.string.oppenheimer_time_out_2), getString(R.string.oppenheimer_time_out_3), getString(R.string.oppenheimer_time_out_4), getString(R.string.oppenheimer_time_out_5), getString(R.string.oppenheimer_time_out_6)), arrayListOf<String>(getString(R.string.oppenheimer_time_out_1_description), getString(R.string.oppenheimer_time_out_2_description), getString(R.string.oppenheimer_time_out_3_description), getString(R.string.oppenheimer_time_out_4_description), getString(R.string.oppenheimer_time_out_5_description), getString(R.string.oppenheimer_time_out_6_description))))
        films.add(Film(4, "fastx_posterfilm", "Форсаж 10", "19 мая, 2023", "2 часа 21 минута", "Экшен | Приключение | Криминал", "correct", getString(R.string.fastx_after_scene), 4, arrayListOf<String>("22:40 -> 3:40", "53:25 -> 4:15", "1:15:35 -> 4:05", "1:43:45 -> 4:05"), arrayListOf<String>(getString(R.string.fastx_time_out_1), getString(R.string.fastx_time_out_2), getString(R.string.fastx_time_out_3), getString(R.string.fastx_time_out_4)), arrayListOf<String>(getString(R.string.fastx_time_out_1_description), getString(R.string.fastx_time_out_2_description), getString(R.string.fastx_time_out_3_description), getString(R.string.fastx_time_out_4_description))))
        films.add(Film(5, "the_covenant_vertical", "Переводчик", "21 апреля, 2023", "2 часа 3 минуты", "Экшен | Криминал | Триллер", "correct", getString(R.string.the_covenant_after_scene), 3, arrayListOf<String>("27:10 -> 4:10", "1:10:10 -> 4:50", "1:30:40 -> 3:55"), arrayListOf<String>(getString(R.string.the_covenant_time_out_1), getString(R.string.the_covenant_time_out_2), getString(R.string.the_covenant_time_out_3)), arrayListOf<String>(getString(R.string.the_covenant_time_out_1_description), getString(R.string.the_covenant_time_out_2_description), getString(R.string.the_covenant_time_out_3_description))))
        films.add(Film(6, "air_vertical", "Air: Большой прыжок","5 апреля, 2023", "1 час 51 минута", "Драма", "correct", getString(R.string.air_after_scene), 4, arrayListOf<String>("17:30 -> 4:15", "37:15 -> 4:05", "59:40 -> 3:50", "1:21:45 -> 3:45"), arrayListOf<String>(getString(R.string.air_time_out_1), getString(R.string.air_time_out_2), getString(R.string.air_time_out_3), getString(R.string.air_time_out_4)), arrayListOf<String>(getString(R.string.air_time_out_1_description), getString(R.string.air_time_out_2_description), getString(R.string.air_time_out_3_description), getString(R.string.air_time_out_4_description))))
        films.add(Film(7, "operation_fortune_vertical", "Операция 'Фортуна': Искусство побеждать","3 марта, 2023","1 час 53 минуты","Экшен | Комедия | Триллер", "correct", getString(R.string.operation_fortune_after_scene), 3, arrayListOf<String>("30:45 -> 4:20", "54:50 -> 4:55", "1:18:15 -> 3:25"), arrayListOf<String>(getString(R.string.operation_fortune_time_out_1), getString(R.string.operation_fortune_time_out_2), getString(R.string.operation_fortune_time_out_3)), arrayListOf<String>(getString(R.string.operation_fortune_time_out_1_description), getString(R.string.operation_fortune_time_out_2_description), getString(R.string.operation_fortune_time_out_3_description))))

        filmsList.layoutManager = LinearLayoutManager(this)
        filmsList.adapter = FilmsAdapter(films, this)
    }
}