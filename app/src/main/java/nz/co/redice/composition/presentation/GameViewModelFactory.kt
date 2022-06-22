package nz.co.redice.composition.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nz.co.redice.composition.domain.entity.GameLevel

class GameViewModelFactory(
    private val application: Application,
    private val level: GameLevel
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java))
            return GameViewModel(application, level) as T
        throw RuntimeException("Unknow viewmodel class $modelClass")
    }
}