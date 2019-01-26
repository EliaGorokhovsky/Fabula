package com.tg.lax.logic.questions

/**
 * Represents an ordered questionSet of questions with a player's score
 */
class QuestionSet(val category: Category, size: Int): java.io.Serializable {

    //Store answer given; if it is the same as the question's answer, then the question is correct; else incorrect
    val questions = mutableMapOf<Question, Answer?>()
    val questionKeys: List<Question>
        get() = questions.keys.toMutableList()
    //The next question to answer
    var questionIndex = 0

    //The amount of questions the user has gotten right
    val amountCorrect: Int
        get() = this.questions.keys.count { this.questions[it]!!.id == it.answerId }

    //The amount of questions the user has gotten wrong
    val amountIncorrect: Int
        get() = this.questions.keys.count { this.questions[it]!!.id != it.answerId && this.questions[it] != null }

    //The amount of questions the user has not answered yet
    val amountUnanswered: Int
        get() = this.questions.keys.count { this.questions[it] == null }

    //The amount of questions the user has answered
    val amountAnswered: Int
        get() = this.questions.keys.count { this.questions[it] != null }

    init {
        assert(size <= this.category.options.size)
        for (i in 0 until size) {
            this.questions[category.getQuestion(allQuestions.minus(this.questionKeys))] = null
        }
    }

}
