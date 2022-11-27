package com.geektech.filmapp.ui.fragments.film.detail

import com.geektech.filmapp.base.BaseViewModel
import com.geektech.filmapp.data.repositories.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailFilmViewModel @Inject constructor(
    private val repository: FilmRepository
) : BaseViewModel() {

    fun fetchDetailFilm(id: String) = repository.fetchDetailFilm(id)

}