package com.challenge.comicus.ui.comic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.challenge.comicus.R
import com.challenge.comicus.ui.base.ComicViewModelFactory
import com.challenge.comicus.ui.base.model.ComicUi
import com.challenge.comicus.utils.extensions.getViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by Pavel on 03/09/2020.
 **/

class ComicFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ComicViewModelFactory

    private lateinit var currentComic: ComicUi

    private val viewModel: ComicViewModel? by lazy {
        viewModelFactory.getViewModel(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_comic, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModelListeners()
    }

    private fun initViewModelListeners() {
        viewModel?.getLatestComic()?.observe(viewLifecycleOwner) {
            currentComic = it
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel?.fetchLatestComic()
    }
}