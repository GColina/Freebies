package com.gcolina.freebies.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gcolina.freebies.model.GameModelItem
import com.gcolina.freebies.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class GameViewModel @Inject constructor(private val gameRepository: GameRepository) : ViewModel() {
    private val _characters = MutableStateFlow<List<GameModelItem>>(emptyList())
    val characters = _characters.asStateFlow()


    init {
        Log.d("GAbriel", "-----Init")
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = gameRepository.getCharacters()
                _characters.value = result ?: emptyList()
            }
        }
    }

}