package com.challenge.comicus.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.challenge.comicus.R
import com.challenge.comicus.ui.base.ComicViewModelFactory
import com.challenge.comicus.ui.comic.ComicViewModel
import com.challenge.comicus.utils.extensions.delayed
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickListener()
        fetchLatestComic()
        delayed(100){ initTransition() }
    }

    private fun initTransition() {
        motion_layout.transitionToEnd()
    }

    private fun initClickListener() {
        playButton.setOnClickListener {
            navigate(R.id.action_splashFragment_to_comicFragment)
        }
    }

    private fun fetchLatestComic() {
        comicViewModel?.fetchLatestComic()
    }
}