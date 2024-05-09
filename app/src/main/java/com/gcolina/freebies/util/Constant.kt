package com.gcolina.freebies.util

import androidx.compose.ui.graphics.Color
import com.gcolina.freebies.ui.theme.Purple40

class Constant {

    companion object {
        const val BASE_URL = "https://www.freetogame.com/api/"
        const val END_POINT = "games"
        const val END_POINT_BY_ID = "game"
        val GRADIENT_COLORS: List<Color> = listOf(Purple40, Color.Cyan, Color.LightGray)
    }

    //   https://www.freetogame.com/api/games

    //   https://www.freetogame.com/api/game?id=452
}