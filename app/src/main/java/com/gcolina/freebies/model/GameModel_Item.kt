@file:Suppress("ktlint:standard:filename")

package com.gcolina.freebies.model

import com.google.gson.annotations.SerializedName

class GameModel : ArrayList<GameModelItem>()

data class GameModelItem(
    // @SerializedName("developer") val developer: String,
    // @SerializedName("freetogame_profile_url") val freetogame_profile_url: String,
    // @SerializedName("game_url") val game_url: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("id") val id: Int,
    @SerializedName("platform") val platform: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("release_date") val release_date: String,
    @SerializedName("short_description") val short_description: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("title") val title: String
)
