package com.gcolina.freebies.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gcolina.freebies.model.gameModelById.GameModelById
import com.gcolina.freebies.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class DetailViewModel
@Inject
constructor(private val gameRepository: GameRepository) :
    ViewModel() {
    private val _gameById = MutableStateFlow<GameModelById?>(null)
    val gameById = _gameById.asStateFlow()

    var firstTime = mutableStateOf(true)

    fun getGameById(id: Int) {
        Log.d("abc", "----->$id")
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = gameRepository.getGameById(id)
                _gameById.value = result
            }
        }
    }
}
