package com.geektech.filmapp.data.repositories

import com.geektech.filmapp.base.BaseRepositories
import com.geektech.filmapp.data.remote.api.FilmApiService
import javax.inject.Inject

class FilmRepository @Inject constructor(
    private val filmApiService: FilmApiService,
) : BaseRepositories() {

    fun fetchFilms() = doRequest {
        filmApiService.fetchFilms()
    }

    fun fetchDetailFilm(id: String) = doRequest {
        filmApiService.fetchDetailFilm(id)
    }

}