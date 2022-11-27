package com.geektech.filmapp.models

import com.geektech.filmapp.base.IBaseDiffutils
import com.google.gson.annotations.SerializedName

data class FilmModel(

    @SerializedName("id")
    override var id: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("director")
    var director: String,

    @SerializedName("producer")
    var producer: String,

    @SerializedName("release_date")
    var releaseDate: String,

    @SerializedName("running_time")
    var runningTime: String,

    @SerializedName("rt_score")
    var rtScore: String,

): IBaseDiffutils