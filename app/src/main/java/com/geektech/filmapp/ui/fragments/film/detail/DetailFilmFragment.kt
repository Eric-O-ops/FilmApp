package com.geektech.filmapp.ui.fragments.film.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.geektech.filmapp.R
import com.geektech.filmapp.base.BaseFragment
import com.geektech.filmapp.common.Resource
import com.geektech.filmapp.databinding.FragmentDetailFilmBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFilmFragment :
    BaseFragment<FragmentDetailFilmBinding, DetailFilmViewModel>(R.layout.fragment_detail_film) {

    override val binding by viewBinding(FragmentDetailFilmBinding::bind)
    override val viewModel: DetailFilmViewModel by viewModels()
    private val args by navArgs<DetailFilmFragmentArgs>()

    override fun setupObserve() = with(binding) {
        viewModel.fetchDetailFilm(args.id).subscribe(
            onError = {},
            onSuccess = {
                title.text = it.title
                Glide.with(imageView).load(it.image).into(imageView)
                rating.text = it.rtScore
                description.text = it.description
            }
        )
    }
}