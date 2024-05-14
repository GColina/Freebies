package com.gcolina.freebies.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gcolina.freebies.model.GameModelItem
import com.gcolina.freebies.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class GameViewModel @Inject constructor(private val gameRepository: GameRepository) : ViewModel() {
    private val _characters = MutableStateFlow<List<GameModelItem>>(emptyList())
    val characters = _characters.asStateFlow()

    var firstTime = mutableStateOf(true)

    fun getCharacters() {
        viewModelScope.launch {
            Log.d("abc", "-------->>>")
            withContext(Dispatchers.IO) {
                val result = gameRepository.getCharacters()
                _characters.value = result ?: emptyList()
            }
        }
    }
}
