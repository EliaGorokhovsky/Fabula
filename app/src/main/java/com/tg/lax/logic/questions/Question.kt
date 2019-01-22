package com.tg.lax.logic.questions

import android.util.Log

/**
 * Represents a multiple choice question
 */
class Question(
        val id: Int,
        val type: QuestionType,
        val text: String? = null,
        val answerId: Int
) {
    /**
     * Gets n random matching answers (including the correct one) for this question
     */
    fun getAnswers(number: Int = 4): Array<Answer> {
        if (number < 1) {
            return arrayOf()
        }
        val validAnswers = allAnswers.filter { it.type == allAnswers.find { it.id == this.answerId }!!.type }.minus(allAnswers.find { it.id == this.answerId }!!)
        val answers = (arrayOf(allAnswers.find { it.id == this.answerId }!!) + validAnswers.shuffled().take(number - 1)).toList().shuffled().toTypedArray()
        Log.i("answers", answers.map { it.text }.toString())
        return answers
    }

}

val allQuestions = mutableListOf<Question>(
        Question(0, QuestionType.MISC, "Who is the author of Something Witty?", 0),
        Question(1, QuestionType.NATIONAL_OFFICERS, "Who is the current FBLA National President?", 2),
        Question(2, QuestionType.NATIONAL_OFFICERS, "Who is the current FBLA National Secretary?", 3),
        Question(3, QuestionType.NATIONAL_OFFICERS, "Who is the current FBLA National Treasurer?", 4),
        Question(4, QuestionType.NATIONAL_OFFICERS, "Who is the current FBLA National Parliamentarian?", 5),
        Question(5, QuestionType.NATIONAL_OFFICERS, "Who is the current FBLA Eastern Region VP?", 6),
        Question(6, QuestionType.NATIONAL_OFFICERS, "Who is the current FBLA Mountain Plains Region VP?", 7),
        Question(7, QuestionType.NATIONAL_OFFICERS, "Who is the current FBLA North Central Region VP?", 8),
        Question(8, QuestionType.NATIONAL_OFFICERS, "Who is the current FBLA Southern Region VP?", 9),
        Question(9, QuestionType.NATIONAL_OFFICERS, "Who is the current FBLA Western Region VP?", 10)
)