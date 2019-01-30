package com.tg.lax.logic.questions

/**
 * Represents one of possible categories a question could be from
 */
enum class QuestionType(val description: String): java.io.Serializable {
    BUSINESS_JARGON("Business Jargon"),
    BUSINESS_PROCEDURES("Business Procedures"),
    INVESTMENT("Investment"),
    NATIONAL_OFFICERS("National Officers"),
    PARLIAMENTARY_PROCEDURE("Parliamentary Procedures"),
    NATIONAL_LEADERSHIP_CONFERENCES("NLCs"),
    FBLA_HISTORY("FBLA History"),
    MISC("Miscellaneous")
}