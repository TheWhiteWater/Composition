package nz.co.redice.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import nz.co.redice.composition.R
import nz.co.redice.composition.databinding.FragmentChooseLevelBinding
import nz.co.redice.composition.domain.entity.GameLevel


class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            buttonLevelTest.setOnClickListener {
                launchGameFragment(GameLevel.TEST)
            }
            buttonLevelEasy.setOnClickListener {
                launchGameFragment(GameLevel.EASY)
            }
            buttonLevelNormal.setOnClickListener {
                launchGameFragment(GameLevel.NORMAL)
            }
            buttonLevelHard.setOnClickListener {
                launchGameFragment(GameLevel.HARD)
            }
        }
    }

    private fun launchGameFragment(gameLevel: GameLevel) {
        findNavController().navigate(ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(gameLevel))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}