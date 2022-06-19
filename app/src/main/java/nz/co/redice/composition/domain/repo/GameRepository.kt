package nz.co.redice.composition.domain.repo

import nz.co.redice.composition.domain.entity.GameSettings
import nz.co.redice.composition.domain.entity.Level
import nz.co.redice.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfAnswerOptions:Int
    ): Question

    fun getGameSettings(level: Level): GameSettings


}