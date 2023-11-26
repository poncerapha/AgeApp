package br.com.raphaelfleury.ageapp.viewmodel

import androidx.lifecycle.ViewModel
import br.com.raphaelfleury.ageapp.models.game.Games
import br.com.raphaelfleury.ageapp.repository.AgeRepository
import br.com.raphaelfleury.ageapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val repository: AgeRepository
) : ViewModel() {

    suspend fun getAgeInfo(playerId: String): Resource<Games> {
        return repository.getAgePlayerInfo(playerId)
    }
}