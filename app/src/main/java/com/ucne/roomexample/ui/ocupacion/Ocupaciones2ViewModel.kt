package com.ucne.roomexample.ui.ocupacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.roomexample.data.remote.dto.OcupacionesDto
import com.ucne.roomexample.data.repository.Ocupaciones2Repository
import com.ucne.roomexample.util.Resource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

data class OcupacionesListState(
    val isLoading: Boolean = false,
    val ocupaciones: List<OcupacionesDto> = emptyList(),
    val error: String = ""
)

class Ocupaciones2ViewModel @Inject constructor(
    private val ocupaciones2Repository: Ocupaciones2Repository
) : ViewModel() {

    var uiState = MutableStateFlow(OcupacionesListState())
        private set

    init {
        ocupaciones2Repository.getOcupaciones().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    uiState.update {
                        it.copy(isLoading = true)
                    }
                }

                is Resource.Success -> {
                    uiState.update {
                        it.copy(ocupaciones = result.data ?: emptyList())
                    }
                }

                is Resource.Error -> {
                    uiState.update {
                        it.copy(error = result.message ?: "Error desconocido")
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

}