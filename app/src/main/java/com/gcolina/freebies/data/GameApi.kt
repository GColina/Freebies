package com.gcolina.freebies.data

import com.gcolina.freebies.model.GameModel
import com.gcolina.freebies.model.gameModelById.GameModelById
import com.gcolina.freebies.util.Constant.Companion.END_POINT
import com.gcolina.freebies.util.Constant.Companion.END_POINT_BY_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {
    @GET(END_POINT)
    suspend fun getCharacters(): Response<GameModel>

    @GET(END_POINT_BY_ID)
    suspend fun getGameById(
        @Query(value = "id") id: Int,
    ): Response<GameModelById?>
}
