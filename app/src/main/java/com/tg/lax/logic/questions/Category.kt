package com.tg.lax.logic.questions

/**
 * Represents a questionSet of questions with probabilities
 */
class Category(questionTypes: Array<QuestionType> = QuestionType.values(), var name: String = ""): java.io.Serializable {

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
        val newWeights = this.weights.filter { entry ->
            possibleQuestions.count { question ->
                question.type == entry.key
            } > 0
        }
        val randomChoice = Math.random() * newWeights.values.sum()
        var weightsSum = 0
        for (type in newWeights.keys) {
            if (randomChoice < weightsSum + newWeights[type]!!) {
                questionType = type
                break
            }
            weightsSum += newWeights[type]!!
        }
        val validQuestions = possibleQuestions.filter { it.type == questionType }
        return validQuestions[(Math.random() * validQuestions.size).toInt()]
    }

}

val allCategories = mutableListOf<Category>(
        Category(arrayOf(QuestionType.BUSINESS_JARGON), "Business Jargon"),
        Category(arrayOf(QuestionType.BUSINESS_PROCEDURES), "Business Procedures"),
        Category(arrayOf(QuestionType.COMPETITIVE_EVENTS), "Competitive Events"),
        Category(arrayOf(QuestionType.FBLA_HISTORY), "FBLA History"),
        Category(arrayOf(QuestionType.NATIONAL_OFFICERS), "National Officers"),
        Category(arrayOf(QuestionType.NATIONAL_LEADERSHIP_CONFERENCES), "NLCs"),
        Category(arrayOf(QuestionType.NETWORKING), "Networking"),
        Category(arrayOf(QuestionType.PARLIAMENTARY_PROCEDURE), "Parliamentary Procedure"),
        Category(arrayOf(QuestionType.STOCK_TRADING), "Stock Trading"),
        Category(arrayOf(QuestionType.NATIONAL_PARTNERS), "National Partners"),
        Category(arrayOf(QuestionType.MISC), "Miscellaneous")
)