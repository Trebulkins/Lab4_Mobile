package com.example.lab4_mobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val questions = listOf("Вопрос 1", "Вопрос 2", "ВОПРОС 3!")
        val yesb = findViewById<Button>(R.id.YESbutton)
        val nob = findViewById<Button>(R.id.NObutton)
        val nextb = findViewById<Button>(R.id.NEXTbutton)
        val que = findViewById<TextView>(R.id.Question)

        var i = 0

        nextb.visibility = View.INVISIBLE
        que.text = questions[i]
        yesb.setOnClickListener {
            Toast.makeText(this, "АГА!", Toast.LENGTH_SHORT).show()
            nextb.visibility = View.VISIBLE
            yesb.visibility = View.INVISIBLE
            nob.visibility = View.INVISIBLE
        }

        nob.setOnClickListener {
            Toast.makeText(this, "НЕА!", Toast.LENGTH_SHORT).show()
            nextb.visibility = View.VISIBLE
            yesb.visibility = View.INVISIBLE
            nob.visibility = View.INVISIBLE
        }

        nextb.setOnClickListener {
            Toast.makeText(this, "СЛЕДУЮЩИЙ ВОПРОС", Toast.LENGTH_SHORT).show()
            nextb.visibility = View.INVISIBLE
            yesb.visibility = View.VISIBLE
            nob.visibility = View.VISIBLE
            i++
            que.text = questions[i]
        }

    }
}