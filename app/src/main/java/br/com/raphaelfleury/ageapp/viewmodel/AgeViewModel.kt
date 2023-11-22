package br.com.raphaelfleury.ageapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.raphaelfleury.ageapp.models.AgeResponse
import br.com.raphaelfleury.ageapp.repository.AgeRepository
import br.com.raphaelfleury.ageapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val repository: AgeRepository
) : ViewModel() {

    suspend fun getAgeInfo(playerId: String): Resource<AgeResponse> {
        return repository.getAgePlayerInfo(playerId)
    }
}