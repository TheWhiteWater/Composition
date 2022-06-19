package nz.co.redice.composition.domain.usecase

import nz.co.redice.composition.domain.entity.Question
import nz.co.redice.composition.domain.repo.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(
            maxSumValue = maxSumValue,
            countOfAnswerOptions = COUNT_OF_ANSWER_OPTIONS
        )
    }

    private companion object {
        private const val COUNT_OF_ANSWER_OPTIONS = 6
    }
}