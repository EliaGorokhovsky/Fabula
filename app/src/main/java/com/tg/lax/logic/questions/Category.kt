package com.tg.lax.logic.questions

/**
 * Represents a set of questions with probabilities
 */
class Category {

    var weights = QuestionType.values().map { it to 1 }.toMap().toMutableMap()
    var questionType: QuestionType? = null

    /**
     * Gets a random question according to the weights of the question types in the category
     */
    fun getQuestion(): Question {
        val randomChoice = Math.random() * this.weights.values.sum()
        var weightsSum = 0
        for (type in this.weights.keys) {
            if (randomChoice < weightsSum + this.weights[type]!!) {
                questionType = type
            }
            weightsSum += this.weights[type]!!
        }
        val validQuestions = allQuestions.filter { it.type == questionType }
        return validQuestions[(Math.random() * validQuestions.size).toInt()]
    }

}