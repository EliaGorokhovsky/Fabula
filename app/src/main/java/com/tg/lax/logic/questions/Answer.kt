package com.tg.lax.logic.questions

/**
 * Represents a multiple choice answer
 */
data class Answer(
        val id: Int,
        val type: AnswerType,
        val picture: String? = null,
        val text: String? = null
)

val allAnswers = mutableListOf<Answer>(
        Answer(0, AnswerType.ENTITY, text = "Saurabh Totey"),
        Answer(1, AnswerType.ENTITY, text = "Elia Gorokhovsky"),
        Answer(2, AnswerType.ENTITY, text = "Eu Ro Wang"),
        Answer(3, AnswerType.ENTITY, text = "Keerti Soundappan"),
        Answer(4, AnswerType.ENTITY, text = "Galadriel Coury"),
        Answer(5, AnswerType.ENTITY, text = "Michael Zhao"),
        Answer(6, AnswerType.ENTITY, text = "Garett Koch"),
        Answer(7, AnswerType.ENTITY, text = "Madelyn Remington"),
        Answer(8, AnswerType.ENTITY, text = "Eli Amyx"),
        Answer(9, AnswerType.ENTITY, text = "Ty Rickard"),
        Answer(10, AnswerType.ENTITY, text = "Trentyn Tennant")
)