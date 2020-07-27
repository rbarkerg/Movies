package com.example.movies.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MMovie (
    @SerializedName("id") @Expose var identifier: Int = -1,
    @SerializedName("thumbnail") @Expose var thumbnail: String = "",
    @SerializedName("name") @Expose var name: String = "",
    @SerializedName("banner") @Expose var banner: String = "",
    @SerializedName("description") @Expose var description: String = ""
): Serializable