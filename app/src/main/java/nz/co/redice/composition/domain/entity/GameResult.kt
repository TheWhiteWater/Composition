package nz.co.redice.composition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResult(
    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfAnsweredQuestions: Int,
    val gameSettings: GameSettings
) : Parcelable