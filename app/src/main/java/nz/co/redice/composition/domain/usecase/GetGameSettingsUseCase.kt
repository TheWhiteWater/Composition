package nz.co.redice.composition.domain.usecase

import nz.co.redice.composition.domain.entity.GameSettings
import nz.co.redice.composition.domain.entity.Level
import nz.co.redice.composition.domain.repo.GameRepository

class GetGameSettingsUseCase(
   private val repository: GameRepository
) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level = level)
    }

}