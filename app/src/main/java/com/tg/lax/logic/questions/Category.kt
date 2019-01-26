package com.tg.lax.logic.questions

/**
 * Represents a questionSet of questions with probabilities
 */
class Category(questionTypes: Array<QuestionType> = QuestionType.values()): java.io.Serializable {

    var weights = QuestionType.values().map { it to 0 }.toMap().toMutableMap()
    var questionType: QuestionType? = null
    val options: List<Question>
        get() = allQuestions.filter { this.weights[it.type]!! > 0 }

    init {
        questionTypes.forEach { this.weights[it] = 1 }
    }

    /**
     * Gets a random question according to the weights of the question types in the category
     */
    fun getQuestion(possibleQuestions: List<Question> = this.options): Question {
        val randomChoice = Math.random() * this.weights.values.sum()
        var weightsSum = 0
        for (type in this.weights.keys) {
            if (randomChoice < weightsSum + this.weights[type]!!) {
                questionType = type
                break
            }
            weightsSum += this.weights[type]!!
        }
        val validQuestions = possibleQuestions.filter { it.type == questionType }
        return validQuestions[(Math.random() * validQuestions.size).toInt()]
    }

}

val allCategories = mutableMapOf<String, Category>(
        "Business Jargon" to Category(arrayOf(QuestionType.BUSINESS_JARGON)),
        "Business Procedures" to Category(arrayOf(QuestionType.BUSINESS_PROCEDURES)),
        "Competitive Events" to Category(arrayOf(QuestionType.COMPETITIVE_EVENTS)),
        "FBLA History" to Category(arrayOf(QuestionType.FBLA_HISTORY)),
        "National Officers" to Category(arrayOf(QuestionType.NATIONAL_OFFICERS)),
        "National Leadership Conferences" to Category(arrayOf(QuestionType.NATIONAL_LEADERSHIP_CONFERENCES)),
        "Networking" to Category(arrayOf(QuestionType.NETWORKING)),
        "Parliamentary Procedure" to Category(arrayOf(QuestionType.PARLIAMENTARY_PROCEDURE)),
        "Stock Trading" to Category(arrayOf(QuestionType.STOCK_TRADING)),
        "National Partners" to Category(arrayOf(QuestionType.NATIONAL_PARTNERS)),
        "Miscellaneous" to Category(arrayOf(QuestionType.MISC))
)