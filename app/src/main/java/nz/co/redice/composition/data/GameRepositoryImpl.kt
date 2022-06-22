package nz.co.redice.composition.data

import nz.co.redice.composition.domain.entity.GameSettings
import nz.co.redice.composition.domain.entity.GameLevel
import nz.co.redice.composition.domain.entity.Question
import nz.co.redice.composition.domain.repo.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfAnswerOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNum = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNum
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfAnswerOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfAnswerOptions)
        while (options.size < countOfAnswerOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNum, options.toList())
    }

    override fun getGameSettings(gameLevel: GameLevel): GameSettings {
        return when (gameLevel) {
            GameLevel.TEST -> {
                GameSettings(
                    10,
                    3,
                    50,
                    8
                )
            }
            GameLevel.EASY -> {
                GameSettings(
                    10,
                    10,
                    70,
                    60
                )
            }
            GameLevel.NORMAL -> {
                GameSettings(
                    20,
                    20,
                    80,
                    40
                )
            }
            GameLevel.HARD -> {
                GameSettings(
                    30,
                    30,
                    90,
                    40
                )
            }
        }
    }
}