package com.tg.lax.logic.questions

/**
 * Represents a multiple choice question
 */
class Question(
        val id: Int,
        val type: QuestionType,
        val text: String? = null,
        val answerId: Int
): java.io.Serializable {
    /**
     * Gets n random matching answers (including the correct one) for this question
     */
    fun getAnswers(number: Int = 4): Array<Answer> {
        if (number < 1) {
            return arrayOf()
        }
        val validAnswers = allAnswers.filter { it.type == allAnswers.find { it.id == this.answerId }!!.type }.minus(allAnswers.find { it.id == this.answerId }!!)
        val answers = (arrayOf(allAnswers.find { it.id == this.answerId }!!) + validAnswers.shuffled().take(number - 1)).toList().shuffled().toTypedArray()
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
        Question(9, QuestionType.NATIONAL_OFFICERS, "Who is the current FBLA Western Region VP?", 10),
        Question(10, QuestionType.BUSINESS_JARGON, "What term refers to the fundamental and unique strength of a person or firm?", 11),
        Question(11, QuestionType.BUSINESS_JARGON, "What term refers to agreement on a course of action?", 12),
        Question(12, QuestionType.BUSINESS_JARGON, "What term refers to a specific responsibility within a business organization?", 13),
        Question(13, QuestionType.BUSINESS_JARGON, "What term refers to blindly accepting something such as a company's mission statement?", 14),
        Question(14, QuestionType.BUSINESS_JARGON, "What term refers to generating a reaction, like positive cash flow?", 15),
        Question(15, QuestionType.BUSINESS_JARGON, "What obscure term refers to revealing information?", 16),
        Question(16, QuestionType.BUSINESS_JARGON, "What term refers to something so novel it is better than the cutting edge?", 17),
        Question(17, QuestionType.BUSINESS_JARGON, "What term refers to a team of specialists brought together to work on a specific task?", 18),
        Question(18, QuestionType.BUSINESS_JARGON, "What term refers to an impending crisis?", 19),
        Question(19, QuestionType.BUSINESS_JARGON, "What refers to a business with many working components to manage?", 20),
        Question(20, QuestionType.BUSINESS_JARGON, "What term refers to being very productive in a short amount of time?", 21),
        Question(21, QuestionType.BUSINESS_JARGON, "What term refers to an activity with little marginal cost?", 22),
        Question(22, QuestionType.BUSINESS_JARGON, "What term refers to a method that returns superior results?", 23),
        Question(23, QuestionType.BUSINESS_JARGON, "What term refers to a company having a specific area of expertise?", 24),
        Question(24, QuestionType.BUSINESS_JARGON, "What term refers to effective collaboration?", 25),
        Question(25, QuestionType.BUSINESS_JARGON, "What term refers to a person with significant investment in a company's success?", 26),
        Question(26, QuestionType.BUSINESS_JARGON, "What term refers to the determination of the point where a company makes 0 net profit?", 27),
        Question(27, QuestionType.BUSINESS_JARGON, "What term refers to gross income from normal business activities?", 28),
        Question(28, QuestionType.BUSINESS_JARGON, "What term refers to net income for a company?", 29),
        Question(29, QuestionType.BUSINESS_PROCEDURES, "What compensates customers for some kinds of product failure?", 30),
        Question(30, QuestionType.BUSINESS_PROCEDURES, "What kind of marketing targets customers in certain areas (e.g. close to a business)", 31),
        Question(31, QuestionType.BUSINESS_PROCEDURES, "What kind of marketing relies on restricting access to a product to make it seem more elite?", 32),
        Question(32, QuestionType.BUSINESS_PROCEDURES, "What kind of marketing sends a variety of pre-written messages to consumers over time?", 33),
        Question(33, QuestionType.BUSINESS_PROCEDURES, "Which department is in charge of creating a product to sell?", 34),
        Question(34, QuestionType.BUSINESS_PROCEDURES, "Which department is in charge of innovating a product to introduce into the market?", 35),
        Question(35, QuestionType.BUSINESS_PROCEDURES, "Which department is in charge of obtaining goods and services for a company?", 36),
        Question(36, QuestionType.BUSINESS_PROCEDURES, "Which department is in charge of convincing the consumers to buy a product?", 37),
        Question(37, QuestionType.BUSINESS_PROCEDURES, "What kind of strategy involves minimizing price to beat competition?", 38),
        Question(38, QuestionType.BUSINESS_PROCEDURES, "What kind of strategy involves maximizing quality to beat competition?", 39),
        Question(39, QuestionType.BUSINESS_PROCEDURES, "Which department is in charge of hiring, training, and employee relations?", 40),
        Question(40, QuestionType.BUSINESS_PROCEDURES, "Which department is in charge of financial record keeping and payroll?", 41),
        Question(41, QuestionType.BUSINESS_PROCEDURES, "What strategy involves consolidating power among senior managers?", 42),
        Question(42, QuestionType.BUSINESS_PROCEDURES, "What strategy involves delegating some decision-making to people at lower levels?", 43),
        Question(43, QuestionType.INVESTMENT, "When an investor places 10 or more trades per month, it is called:", 45),
        Question(44, QuestionType.INVESTMENT, "When an investor buys, sells, and closes stocks in a small amount of time, it is called:", 46),
        Question(45, QuestionType.INVESTMENT, "When long-term investors analyze companies in hopes of getting rewarded decades down the line, it is called:", 47),
        Question(46, QuestionType.INVESTMENT, "When an investor regularly puts a constant amount into a stock regardless of share price, it is called:", 48),
        Question(47, QuestionType.INVESTMENT, "What is the term for a portfolio organization strategy?", 49),
        Question(48, QuestionType.INVESTMENT, "If a friend suggests you put some money into 'cash', what are they likely referring to?", 50),
        Question(49, QuestionType.INVESTMENT, "Which investment involves loaning money to the government?", 51),
        Question(50, QuestionType.INVESTMENT, "Which investment represents a share of ownership in a firm?", 52),
        Question(51, QuestionType.INVESTMENT, "What is the term for an invested sum of money coming from multiple people?", 53),
        Question(52, QuestionType.INVESTMENT, "What is the term for the annual fee payed to the manager of a mutual fund by investors?", 54),
        Question(53, QuestionType.INVESTMENT, "What kind of measurement represents a variety of companies and can be used to estimate the health of a commodity or the market?", 55),
        Question(54, QuestionType.INVESTMENT, "What kind of stock represents multiple companies and can be used to estimate the health of a commodity?", 56),
        Question(55, QuestionType.INVESTMENT, "What kind of stock amplifies the returns of an index?", 57),
        Question(56, QuestionType.INVESTMENT, "What is the term for the market's propensity for rapid change?", 58),
        Question(57, QuestionType.INVESTMENT, "What plan allows employees to save part of their paycheck (before taxes) for retirement?", 59),
        Question(58, QuestionType.INVESTMENT, "What kind of investment serves as an all-in-one portfolio tailored to expected retirement date?", 60),
        Question(59, QuestionType.INVESTMENT, "What measure of a company's stock value and profits gives investors a general measure of whether their investments are overvalued?", 61),
        Question(60, QuestionType.INVESTMENT, "What document contains in-depth details about investments?", 62),
        Question(61, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion limits the length of a (parliamentary) meeting?", 63),
        Question(62, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion ends a (parliamentary) meeting?", 64),
        Question(63, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion temporarily pauses a (parliamentary) meeting?", 65),
        Question(64, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion permits a request relating to the rights of an entire assembly?", 66),
        Question(65, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion permits a request relating to a single person's rights or comfort?", 67),
        Question(66, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion forces an assembly to immediately resume scheduled business?", 68),
        Question(67, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion forces an assembly to suspend consideration of a pending motion?", 69),
        Question(68, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion ends debate on a pending proposal and brings it to a vote?", 70),
        Question(69, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion modifies how much debate is allowed on a pending proposal?", 71),
        Question(70, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion is used to delay action on a pending question?", 72),
        Question(71, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion is used to send the main motion (and subsidiary questions) to a separate committee for consideration?", 73),
        Question(72, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion is used to modify another motion?", 74),
        Question(73, QuestionType.PARLIAMENTARY_PROCEDURE, "Which motion is used to kill a motion without voting on it?", 75),
        Question(74, QuestionType.PARLIAMENTARY_PROCEDURE, "Who published the 1876 manual of parliamentary procedure?", 76),
        Question(75, QuestionType.NATIONAL_LEADERSHIP_CONFERENCES, "Where is the 2019 FBLA NLC planned?", 77),
        Question(76, QuestionType.NATIONAL_LEADERSHIP_CONFERENCES, "Where is the 2020 FBLA NLC planned?", 78),
        Question(77, QuestionType.NATIONAL_LEADERSHIP_CONFERENCES, "Where is the 2021 FBLA NLC planned?", 79),
        Question(78, QuestionType.NATIONAL_LEADERSHIP_CONFERENCES, "Where was the 2018 FBLA NLC held?", 80),
        Question(79, QuestionType.NATIONAL_LEADERSHIP_CONFERENCES, "Who was the 2018 FBLA NLC keynote speaker?", 81),
        Question(80, QuestionType.NATIONAL_LEADERSHIP_CONFERENCES, "Who won the Mobile Application Development category in 2017?", 82),
        Question(81, QuestionType.FBLA_HISTORY, "When was the concept for FBLA developed?", 83),
        Question(82, QuestionType.FBLA_HISTORY, "Who founded FBLA?", 84),
        Question(83, QuestionType.FBLA_HISTORY, "Where did the founder of FBLA teach when the concept was developed?", 85),
        Question(84, QuestionType.FBLA_HISTORY, "What year did FBLA receive its name, its planning committees, and its first sponsor?", 86),
        Question(85, QuestionType.FBLA_HISTORY, "When was the first FBLA chapter founded?", 87),
        Question(86, QuestionType.FBLA_HISTORY, "In which city did Science Hill High School start the first FBLA chapter?", 88),
        Question(87, QuestionType.FBLA_HISTORY, "In which city was the second FBLA chapter started?", 89),
        Question(88, QuestionType.FBLA_HISTORY, "In what year were the FBLA headquarters established in Washington, D.C.?", 90),
        Question(89, QuestionType.FBLA_HISTORY, "When was the PBL postsecondary division formed?", 91),
        Question(90, QuestionType.FBLA_HISTORY, "When was the FBLA Middle-Level division formed?", 92),
        Question(91, QuestionType.MISC, "What is a proportionate saving in costs gained by an increased level of production?", 93),
        Question(92, QuestionType.MISC, "Whose profile can be found at www.facebook.com/4?", 94),
        Question(93, QuestionType.MISC, "If this person were a country, they'd be the 37th richest one on Earth:", 95),
        Question(94, QuestionType.MISC, "Which third founder of Apple left the company after 12 days, forfeiting his 10% share in the company for $2300?", 96),
        Question(95, QuestionType.MISC, "Which of the following is credited as an executive producer on Toy Story?", 97),
        Question(96, QuestionType.MISC, "Which multibillionaire stands to lose half his wealth to divorce?", 98),
        Question(97, QuestionType.MISC, "Who is the richest person in history?", 99),
        Question(98, QuestionType.MISC, "Who is the world's first \"negative billionaire\"?", 100),
        Question(99, QuestionType.MISC, "Which of the world's richest men is an inspiration for the character of Tony Stark?", 101),
        Question(100, QuestionType.MISC, "Who is an inspiration for Monopoly's Mr. Moneybags?", 102),
        Question(101, QuestionType.MISC, "Which founder of a now-billion-dollar company saved it from bankruptcy by winning big in Las Vegas?", 103)
)