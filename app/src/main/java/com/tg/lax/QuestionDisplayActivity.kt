package com.tg.lax

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import com.tg.lax.logic.questions.Answer
import com.tg.lax.logic.questions.Question
import com.tg.lax.logic.questions.QuestionSet
import kotlinx.android.synthetic.main.activity_question_display.*

/**
 * Displays a single question, with options, and handles verifying its accuracy
 */
class QuestionDisplayActivity : AppCompatActivity() {

    //The buttons that represent possible answers mapped to the actual answers
    val answerButtons = mutableMapOf<Button, Answer>()
    //The question being displayed and the set it's from
    lateinit var question: Question
    lateinit var questionSet: QuestionSet

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        //Default code
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_display)

        //Get the question and answers
        this.questionSet = this.intent.extras["questionSet"] as QuestionSet
        this.question = this.questionSet.questionKeys[this.questionSet.questionIndex]
        val answers = this.question.getAnswers()
        questionText.text = this.question.text
        questionText.setPadding(15, 15, 15, 15)
        questionText.gravity = Gravity.CENTER
        questionText.id = 1

        for (optionIndex in 0 until answers.size) {
            val option = answers[optionIndex]
            val button = Button(this)
            val layoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
            layoutParams.addRule(RelativeLayout.BELOW, optionIndex + 1)
            button.text = option.text
            button.id = optionIndex + 2
            button.layoutParams = layoutParams
            layout.addView(button)
            //Logic
            this.answerButtons[button] = option
            button.setOnClickListener { this.checkAnswer(button) }
        }

        //Swipe for another question
        layout.setOnTouchListener { v, event -> this.onTouch(v, event) }
        nextButton.setOnClickListener { this.goToNextQuestion() }
    }

    /**
     * Checks if the pressed button is correct
     */
    fun checkAnswer(pressedButton: Button) {
        pressedButton.backgroundTintList = ColorStateList.valueOf(Color.RED)
        this.answerButtons.keys.find { this.answerButtons[it]!!.id == this.question.answerId }!!.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
        this.answerButtons.keys.forEach { it.isEnabled = false }
        this.questionSet.questions[this.questionSet.questionKeys[this.questionSet.questionIndex]] = this.answerButtons[pressedButton]
    }

    /**
     * Handles swiping for the next question
     */
    fun onTouch(v: View, event: MotionEvent): Boolean {
        var downX = 0
        var upX = 0

        if (event.action == MotionEvent.ACTION_DOWN) {
            //In case we decide to add functionality for this
            downX = event.x.toInt()
            return true
        } else if (event.action == MotionEvent.ACTION_UP) {
            upX = event.x.toInt()
            if (downX - upX > -100) {
                this.goToNextQuestion()
            }
            return true
        }
        return false
    }

    fun goToNextQuestion() {
        this.questionSet.questionIndex += 1
        if (this.questionSet.questionIndex == this.questionSet.questionKeys.size) {
            startActivity(
                    Intent(this, SetCompletionActivity::class.java)
                            .putExtra("questionSet", this.questionSet)
            )
        } else {
            startActivity(
                    Intent(this, QuestionDisplayActivity::class.java)
                            .putExtra("questionSet", this.questionSet)
            )
        }
    }

    /**
     * Ensures the back button will lead to the main menu screen
     */
    override fun onBackPressed() {
        startActivity(
                Intent(this, CategorySelectActivity::class.java)
        )
        super.onBackPressed()
    }

}
