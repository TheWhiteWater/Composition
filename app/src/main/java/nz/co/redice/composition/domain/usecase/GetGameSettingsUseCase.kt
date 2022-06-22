package nz.co.redice.composition.domain.usecase

import nz.co.redice.composition.domain.entity.GameSettings
import nz.co.redice.composition.domain.entity.GameLevel
import nz.co.redice.composition.domain.repo.GameRepository

class GetGameSettingsUseCase(
   private val repository: GameRepository
) {

    operator fun invoke(gameLevel: GameLevel): GameSettings {
        return repository.getGameSettings(gameLevel = gameLevel)
    }

}