package com.tg.lax.logic.questions

/**
 * Represents one of possible categories a question could be from
 */
enum class QuestionType(val description: String): java.io.Serializable {
    COMPETITIVE_EVENTS("Competitive Events"),
    BUSINESS_JARGON("Business Jargon"),
    BUSINESS_PROCEDURES("Business Procedures"),
    STOCK_TRADING("Stock Trading"),
    NATIONAL_OFFICERS("National Officers"),
    NATIONAL_PARTNERS("National Partners"),
    PARLIAMENTARY_PROCEDURE("Parliamentary Procedures"),
    NETWORKING("Networking"),
    NATIONAL_LEADERSHIP_CONFERENCES("NLCs"),
    FBLA_HISTORY("FBLA History"),
    MISC("Miscellaneous")
}