package com.tg.lax

import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.EXTRA_SUBJECT
import android.content.Intent.EXTRA_TEXT
import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.tg.lax.logic.questions.QuestionSet
import kotlinx.android.synthetic.main.activity_set_completion.*

/**
 * Displays the statistics of the set: questions completed, etc.
 */
class SetCompletionActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_completion)

        val questionSet = this.intent.extras["questionSet"] as QuestionSet
        //Report results
        completedQuestionsText.text = "Set Complete!\n\nCorrect: ${questionSet.amountCorrect}\nIncorrect: ${questionSet.amountIncorrect}\nTotal Answered: ${questionSet.amountAnswered}/${questionSet.questionKeys.size}"
        completedQuestionsText.setPadding(15, 15, 15, 15)
        completedQuestionsText.gravity = Gravity.CENTER

        mainMenuButton.backgroundTintList = ColorStateList.valueOf(Color.BLUE)
        retrySetButton.backgroundTintList = ColorStateList.valueOf(Color.RED)

        //Back buttons
        mainMenuButton.setOnClickListener {
            startActivity(
                    Intent(this, CategorySelectActivity::class.java)
            )
        }
        retrySetButton.setOnClickListener {
            startActivity(
                    Intent(this, QuestionDisplayActivity::class.java)
                            .putExtra("questionSet", questionSet.cleanCopy)
            )
        }
        shareButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
                    .setType("text/plain")
                    .putExtra(EXTRA_SUBJECT, "My FaBuLA score!")
                    .putExtra(EXTRA_TEXT, "I scored ${questionSet.amountCorrect} out of ${questionSet.questionKeys.size} ${questionSet.category.name} questions in Fabula! You should check out this app!")
            startActivity(Intent.createChooser(shareIntent, "Share with"))
        }
    }

    /**
     * Ensures that going back returns to the main menu
     */
    override fun onBackPressed() {
        startActivity(
                Intent(this, CategorySelectActivity::class.java)
        )
        super.onBackPressed()
    }

}