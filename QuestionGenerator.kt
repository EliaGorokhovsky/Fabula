import java.io.File

/**
 * A short script to format questions nicely
 * Questions should be written on each line:
 * question; answer; answerType
 */
fun main(args: Array<String>) {
    var questionId = 91
    var answerId = 93
    var questions = mutableListOf<String>()
    var answers = mutableListOf<String>()
    val type = "QuestionType.MISC"
    File("./QuestionGenerator.dat").forEachLine {
        val inputs = it.split("; ")
        questions.add(
                "Question($questionId, $type, \"${inputs[0]}\", $answerId),"
        )
        answers.add(
                "Answer($answerId, AnswerType.${inputs[2]}, text = \"${inputs[1]}\"),"
        )
        questionId++
        answerId++
    }
    println("Copy these into allQuestions")
    for (question in questions) {
        println(question)
    }
    println("Copy these into allAnswers")
    for (answer in answers) {
        println(answer)
    }
}