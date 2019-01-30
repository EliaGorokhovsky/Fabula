package com.tg.lax.logic.questions

/**
 * Represents one of possible types a question could have
 * Used to generate false answers to multiple choice questions
 */
enum class AnswerType(name: String): java.io.Serializable {
    IMAGE("Image"),
    DATE("Date"),
    LOCATION("Location"),
    ENTITY("Person"),
    EVENT("Event"),
    MISC_NOUN("Thing"),
    MISC_VERB("Action"),
    MISC_ADJ("Descriptor")
}