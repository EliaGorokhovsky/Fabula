package com.tg.lax

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tg.lax.logic.questions.QuestionSet
import com.tg.lax.logic.questions.allCategories
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        singleplayer.setOnClickListener {
            startActivity(
                    Intent(this, QuestionDisplayActivity::class.java)
                            .putExtra("questionSet", QuestionSet(allCategories["National Officers"]!!, 9))
            )
        }
    }
}
