package com.challenge.comicus.ui.comic

import android.os.Bundle
import com.challenge.comicus.R
import com.challenge.comicus.ui.base.ComicViewModelFactory
import com.challenge.comicus.utils.extensions.getViewModel
import com.challenge.comicus.utils.extensions.navigate
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_splash.*
import javax.inject.Inject

/**
 * Created by Pavel on 07/09/2020.
 **/

class SplashFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ComicViewModelFactory

    private val comicViewModel: ComicViewModel? by lazy {
        viewModelFactory.getViewModel(activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initClickListener()
        fetchLatestComic()
    }

    private fun fetchLatestComic() {
        comicViewModel?.fetchLatestComic()
    }

    private fun initClickListener() {
        playButton.setOnClickListener {
            navigate(R.id.action_splashFragment_to_comicFragment)
        }
    }
}