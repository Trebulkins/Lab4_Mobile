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
        val questions = listOf(
            "Может ли бегемот бежать со скоростью в 30 км/ч?.",
            "Вопрос 2",
            "ВОПРОС 3!"
        )
        val answers = listOf(
            true,
            false,
            false
        )

        val yesb = findViewById<Button>(R.id.YESbutton)
        val nob = findViewById<Button>(R.id.NObutton)
        val nextb = findViewById<Button>(R.id.NEXTbutton)
        val que = findViewById<TextView>(R.id.Question)
        val queN = findViewById<TextView>(R.id.TextNum)
        val restart = findViewById<TextView>(R.id.RESTARTbutton)
        val resultscr = findViewById<TextView>(R.id.ResultScreen)

        var i = 0
        var score = 0


        nextb.visibility = View.INVISIBLE
        restart.visibility = View.INVISIBLE
        resultscr.visibility = View.INVISIBLE
        que.text = questions[i]
        queN.text = "Вопрос №${i + 1}:"
        yesb.setOnClickListener {
            if (answers[i]){
                score++
            }
            nextb.visibility = View.VISIBLE
            yesb.visibility = View.INVISIBLE
            nob.visibility = View.INVISIBLE
        }

        nob.setOnClickListener {
            if (!answers[i]){
                score++
            }
            nextb.visibility = View.VISIBLE
            yesb.visibility = View.INVISIBLE
            nob.visibility = View.INVISIBLE
        }

        nextb.setOnClickListener {
            i++
            if (i < questions.size) {
                nextb.visibility = View.INVISIBLE
                yesb.visibility = View.VISIBLE
                nob.visibility = View.VISIBLE
                que.text = questions[i]
                queN.text = "Вопрос №${i + 1}:"
            }
            else {
                nextb.visibility = View.INVISIBLE
                yesb.visibility = View.INVISIBLE
                nob.visibility = View.INVISIBLE
                que.visibility = View.INVISIBLE
                queN.visibility = View.INVISIBLE
                restart.visibility = View.VISIBLE
                resultscr.text = "РЕЗУЛЬТАТ: ${score}/${questions.size}"
                resultscr.visibility = View.VISIBLE
            }
        }

        restart.setOnClickListener {
            i = 0
            score = 0
            que.text = questions[i]
            queN.text = "Вопрос №${i + 1}:"
            yesb.visibility = View.VISIBLE
            nob.visibility = View.VISIBLE
            que.visibility = View.VISIBLE
            queN.visibility = View.VISIBLE
            restart.visibility = View.INVISIBLE
            resultscr.visibility = View.INVISIBLE
        }
    }
}