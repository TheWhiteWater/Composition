package nz.co.redice.composition.domain.repo

import nz.co.redice.composition.domain.entity.GameSettings
import nz.co.redice.composition.domain.entity.GameLevel
import nz.co.redice.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfAnswerOptions:Int
    ): Question

    fun getGameSettings(gameLevel: GameLevel): GameSettings


}