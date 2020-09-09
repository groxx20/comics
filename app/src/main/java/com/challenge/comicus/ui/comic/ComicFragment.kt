package com.challenge.comicus.ui.comic

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.challenge.comicus.R
import com.challenge.comicus.ui.base.ComicViewModelFactory
import com.challenge.comicus.utils.extensions.constructExplanationUrl
import com.challenge.comicus.utils.extensions.getViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_comic.*
import javax.inject.Inject


/**
 * Created by Pavel on 03/09/2020.
 **/

class ComicFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ComicViewModelFactory

    private lateinit var comicViewController: ComicViewController

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
        initViewController(view)
        initViewModelListeners()
        initClickListeners()
    }

    private fun initViewController(view: View) {
        comicViewController = ComicViewController(view, eventCallback)
    }

    private fun initViewModelListeners() {
        viewModel?.getLatestComic()?.observe(viewLifecycleOwner) {
            comicViewController.currentComic = it
            comicViewController.setComicData()
        }

    }

    private fun initClickListeners() {
        favoriteSection.setOnClickListener(comicViewController.favoriteSectionClickListener)
        randomSection.setOnClickListener(comicViewController.randomSectionClickListener)
        explainSection.setOnClickListener(comicViewController.explainSectionClickListener)
    }

    private val eventCallback = object : ComicViewController.EventCallback {
        override fun onFavoriteClicked() {
            //  Send favorite to backend and DB
        }

        override fun onRandomComicClicked() {
            viewModel?.apply {
                publisherComic.removeObservers(viewLifecycleOwner)
                fetchRandomComic()
                getComicById().observe(viewLifecycleOwner) {
                    comicViewController.currentComic = it
                    comicViewController.setComicData()
                }
            }
        }

        override fun onExplanationClicked(comicNumber: Int, comicTitle: String) {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                constructExplanationUrl(comicNumber, comicTitle)
            )
            startActivity(browserIntent)
        }
    }
}