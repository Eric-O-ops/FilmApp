package com.geektech.filmapp.data.remote.api

import com.geektech.filmapp.models.FilmModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmApiService {

    @GET("films")
    suspend fun fetchFilms():Response<ArrayList<FilmModel>>

    @GET("films/{id}")
    suspend fun fetchDetailFilm(
        @Path("id") id: String
    ): FilmModel

}