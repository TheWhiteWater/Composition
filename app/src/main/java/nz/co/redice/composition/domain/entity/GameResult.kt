package nz.co.redice.composition.domain.entity

data class GameResult(
    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfAnsweredQuestions: Int,
    val gameSettings: GameSettings
)