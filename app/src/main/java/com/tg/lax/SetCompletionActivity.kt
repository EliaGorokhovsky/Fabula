package com.tg.lax

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tg.lax.logic.questions.QuestionSet
import kotlinx.android.synthetic.main.activity_set_completion.*

class SetCompletionActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_completion)

        val questionSet = this.intent.extras["questionSet"] as QuestionSet
        //Report results
        completedQuestionsText.text = "Set Complete!\n\nCorrect: ${questionSet.amountCorrect}\nIncorrect: ${questionSet.amountIncorrect}\nTotal Answered: ${questionSet.amountAnswered}/${questionSet.questionKeys.size}"

        Log.i("Answered", "${questionSet.questions.toString()}")

        //Back buttons
        mainMenuButton.setOnClickListener {
            startActivity(
                    Intent(this, MainActivity::class.java)
            )
        }
        retrySetButton.setOnClickListener {
            startActivity(
                    Intent(this, QuestionDisplayActivity::class.java)
                            .putExtra("questionSet", questionSet.cleanCopy)
            )
        }
    }
}
