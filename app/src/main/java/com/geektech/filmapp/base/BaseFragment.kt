package com.geektech.filmapp.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.geektech.filmapp.common.Resource

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    protected abstract val binding: VB
    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupObserve()

    }

    protected open fun initialize() {}

    protected open fun setupObserve() {}

    protected open fun <T> LiveData<Resource<T>>.subscribe(
        onError: (error: String) -> Unit,
        onLoading:((state: Resource<T>) ->Unit)? = null,
        onSuccess: (data: T) -> Unit
    ) {
        observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {

                    onError(it.massage.toString())
                }
                is Resource.Loading -> {}

                is Resource.Success -> {

                    it.data?.let { data ->
                        onSuccess(data)
                    }

                }
            }
        }

    }
}