package com.geektech.filmapp.ui.fragments.film

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.filmapp.R
import com.geektech.filmapp.base.BaseFragment
import com.geektech.filmapp.databinding.FragmentFilmBinding
import com.geektech.filmapp.ui.adapters.FilmAdapter
import com.geektech.filmapp.ui.adapters.OnClick
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmFragment : BaseFragment<FragmentFilmBinding, FilmViewModel>(R.layout.fragment_film),
    OnClick {

    override val binding by viewBinding(FragmentFilmBinding::bind)
    override val viewModel: FilmViewModel by viewModels()
    private val filmAdapter = FilmAdapter(this)

    override fun initialize() {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = filmAdapter
        }
    }

    override fun setupObserve() {
        viewModel.fetchFilms().subscribe(
            onError = {},
            onSuccess = {
                filmAdapter.submitList(it.body())
            }
        )
    }

    override fun onShortClick(id: String) {
        findNavController().navigate(
            FilmFragmentDirections
                .actionFilmFragmentToDetailFilmFragment(id)
        )
    }
}