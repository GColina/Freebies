package com.gcolina.freebies.repository

import android.util.Log
import com.gcolina.freebies.data.GameApi
import com.gcolina.freebies.model.GameModelItem
import com.gcolina.freebies.model.gameModelById.GameModelById
import javax.inject.Inject

class GameRepository
    @Inject
    constructor(private val gameApi: GameApi) {
        suspend fun getCharacters(): List<GameModelItem>? {
            return try {
                val response = gameApi.getCharacters()
                Log.d("GAbriel", "-------Body: ${response.body()}")
                Log.d("GAbriel", "-------ErrorBody: ${response.errorBody()}")
                response.body()
            } catch (e: Exception) {
                // Manejar cualquier excepción que pueda ocurrir durante la llamada a la API
                Log.d("GAbriel", "-------$e")
                null
            }
        }

        suspend fun getGameById(id: Int): GameModelById? {
            return try {
                val response = gameApi.getGameById(id)

                return response.body()
            } catch (e: Exception) {
                // Manejar cualquier excepción que pueda ocurrir durante la llamada a la API
                Log.d("GAbriel", "-------$e")
                null
            }
        }
    }
