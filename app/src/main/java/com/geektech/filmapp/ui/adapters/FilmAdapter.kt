package com.geektech.filmapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.filmapp.base.BaseDiffutilsCallback
import com.geektech.filmapp.databinding.ItemFilmBinding
import com.geektech.filmapp.models.FilmModel

class FilmAdapter(
    private val onShortClick: OnClick
) : ListAdapter<FilmModel, FilmAdapter.ViewHolder>(BaseDiffutilsCallback()) {

    class ViewHolder(private val binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: FilmModel?, onShortClick: OnClick) = with(binding) {
            itemTitle.text = item?.title
            itemRating.text = item?.rtScore
            itemDescription.text = item?.description
            Glide.with(itemImageView).load(item?.image).into(itemImageView)

            itemView.setOnClickListener {
                onShortClick.onShortClick(item?.id!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFilmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position), onShortClick)
    }
}

interface OnClick {
    fun onShortClick(id: String)
}