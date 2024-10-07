package com.example.lab4_mobile

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private var icount = ""
    private var scorecount = ""
    private var hintclick = ""
    private var i: Int = 0
    private var score: Int = 0
    private var hintIsClicked: Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val hints = listOf(
            "Гепард бегает со скоростью Scripps-Booth Bi-Autog 1912 года.",
            "Плотность населения в Красноярске - 2765 чел/км2.",
            "Снежный барс - вымирающий вид животного.",
            "У Ryzen 5 5500 12 потоков.",
            "Звезды на флаге США обозначают штаты страны.",
            "Карбонат натрия называют кальцинированной содой.",
            "На банкноте в 500 рублей написано название города - Арханьгельск.",
            "Дельфины, так же как и киты - живородящие.",
            "Релиз Windows XP - 25 октября 2001 года, Windows 7 - 22 октября 2009 года.",
            "Для бейсбола используется аббревиатура MLB",
        )
        val questions = listOf(
            "Гепард может бежать со скоростью в 120 км/ч.",
            "Площадь Красноярска равна 365 км².",
            "В Красной книге нет снежного барса.",
            "В процессоре Ryzen 5 5500 ровно 6 ядер.",
            "В США более 50 штатов.",
            "Пищевая сода - это гидрокарбонат натрия.",
            "На банкноте в 500 рублей нарисован памятник Петру Великому.",
            "Дельфины относятся к классу млекопитающих.",
            "По хронологии ОС Windows, после Windows XP идет Windows 7.",
            "NBA - национальная бейсбольная организация"
        )
        val answers = listOf(
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            true,
            false,
            false
        )

        val yesb = findViewById<Button>(R.id.YESbutton)
        val nob = findViewById<Button>(R.id.NObutton)
        val nextb = findViewById<Button>(R.id.NEXTbutton)
        val hint = findViewById<Button>(R.id.HintBut1)
        val que = findViewById<TextView>(R.id.Question)
        val hinttext = findViewById<TextView>(R.id.HintViev)
        val queN = findViewById<TextView>(R.id.TextNum)
        val restart = findViewById<TextView>(R.id.RESTARTbutton)
        val resultscr = findViewById<TextView>(R.id.ResultScreen)

        hinttext.visibility = View.INVISIBLE
        nextb.visibility = View.INVISIBLE
        restart.visibility = View.INVISIBLE
        resultscr.visibility = View.INVISIBLE
        que.text = questions[i]
        queN.text = "Вопрос №${i + 1}:"

        if (savedInstanceState != null) {
            i = savedInstanceState.getInt(icount, 0);
            score = savedInstanceState.getInt(scorecount, 0);
            hintIsClicked = savedInstanceState.getBoolean(hintclick, false);
            if (hintIsClicked) {
                hinttext.visibility = View.VISIBLE
                hinttext.text = hints[i]
            }
            else hinttext.visibility = View.INVISIBLE
            que.text = questions[i];
            queN.text = "Вопрос №${i + 1}:"
        }

        yesb.setOnClickListener {
            if (answers[i]){
                score++
            }
            nextb.visibility = View.VISIBLE
            yesb.visibility = View.INVISIBLE
            nob.visibility = View.INVISIBLE
            hint.visibility = View.INVISIBLE
            hinttext.visibility = View.INVISIBLE
        }

        nob.setOnClickListener {
            if (!answers[i]){
                score++
            }
            nextb.visibility = View.VISIBLE
            yesb.visibility = View.INVISIBLE
            nob.visibility = View.INVISIBLE
            hint.visibility = View.INVISIBLE
            hinttext.visibility = View.INVISIBLE
        }

        hint.setOnClickListener{
            hinttext.visibility = View.VISIBLE
            hinttext.text = hints[i]
            hintIsClicked = true
        }

        nextb.setOnClickListener {
            i++
            hintIsClicked = false
            nextb.visibility = View.INVISIBLE
            if (i < questions.size) {
                hint.visibility = View.VISIBLE
                hinttext.visibility = View.INVISIBLE
                yesb.visibility = View.VISIBLE
                nob.visibility = View.VISIBLE
                que.text = questions[i]
                queN.text = "Вопрос №${i + 1}:"
            }
            else {
                yesb.visibility = View.INVISIBLE
                nob.visibility = View.INVISIBLE
                que.visibility = View.INVISIBLE
                queN.visibility = View.INVISIBLE
                restart.visibility = View.VISIBLE
                resultscr.text = "РЕЗУЛЬТАТ: ${score}/${questions.size}"
                resultscr.visibility = View.VISIBLE
                hinttext.visibility = View.INVISIBLE
                hint.visibility = View.INVISIBLE
            }
        }

        restart.setOnClickListener {
            i = 0
            score = 0
            que.text = questions[i]
            queN.text = "Вопрос №${i + 1}:"
            hint.visibility = View.VISIBLE
            yesb.visibility = View.VISIBLE
            nob.visibility = View.VISIBLE
            que.visibility = View.VISIBLE
            queN.visibility = View.VISIBLE
            restart.visibility = View.INVISIBLE
            resultscr.visibility = View.INVISIBLE
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(icount, i)
        outState.putInt(scorecount, score)
        outState.putBoolean(hintclick, hintIsClicked)
    }
}