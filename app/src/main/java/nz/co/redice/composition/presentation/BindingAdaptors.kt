package nz.co.redice.composition.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import nz.co.redice.composition.R
import nz.co.redice.composition.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_score),
        count
    )
}

@BindingAdapter("scoredAnswers")
fun bindScoredAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        count
    )
}

@BindingAdapter("requiredPercentOfRightAnswers")
fun bindMinPercent(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        count
    )
}

@BindingAdapter("scoredPercentage")
fun bindScoredPercent(textView: TextView, gameResult: GameResult) {
    textView.text = String.format(
        textView.context.getString(R.string.score_percentage), getPercentOfScoredAnswers(gameResult)
    )
}

fun getPercentOfScoredAnswers(gameResult: GameResult) =
    with(gameResult) {
        if (countOfRightAnswers == 0)
            0
        else
            ((countOfRightAnswers / countOfAnsweredQuestions.toDouble()) * 100).toInt()
    }

@BindingAdapter("faceIcon")
fun bindFaceIcon(imageView: ImageView, winner: Boolean) {
    if (winner)
        imageView.setImageResource(R.drawable.ic_smile)
    else
        imageView.setImageResource(R.drawable.ic_sad)
}


@BindingAdapter("enoughCount")
fun bindEnoughCount(textView: TextView, count: Boolean) {
    textView.setTextColor(getColorByState(textView.context, count))
}

@BindingAdapter("enoughPercent")
fun bindEnoughPercent(progressBar: ProgressBar, enough: Boolean) {
    val color = getColorByState(progressBar.context, enough)
    progressBar.progressTintList = ColorStateList.valueOf(color)
}

private fun getColorByState(context: Context, it: Boolean): Int {
    val colorResId = if (it) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor(context, colorResId)
}

@BindingAdapter("numberAsText")
fun convertNumberToText(textView: TextView, num: Int) {
    textView.text = num.toString()
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView, clickListener: OnOptionClickListener) {
    textView.setOnClickListener {
        clickListener.onOptionClick(textView.text.toString().toInt())
    }
}

interface OnOptionClickListener {
    fun onOptionClick(option: Int)
}