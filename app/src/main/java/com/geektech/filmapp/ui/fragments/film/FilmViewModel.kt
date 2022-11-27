package com.geektech.filmapp.ui.fragments.film

import androidx.lifecycle.ViewModel
import com.geektech.filmapp.base.BaseViewModel
import com.geektech.filmapp.data.repositories.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val repositories: FilmRepository
) : ViewModel() {

    fun fetchFilms() = repositories.fetchFilms()
}