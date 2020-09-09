package com.challenge.comicus.ui.comic

import android.graphics.drawable.Drawable
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.challenge.comicus.R
import com.challenge.comicus.ui.base.model.ComicUi
import com.challenge.comicus.utils.extensions.setDrawableColor
import kotlinx.android.synthetic.main.fragment_comic.view.*

/**
 * Created by Pavel on 08/09/2020.
 **/
class ComicViewController(
    private val view: View,
    private val eventCallback: EventCallback
) {

    interface EventCallback {
        fun onFavoriteClicked()
        fun onRandomComicClicked()
        fun onExplanationClicked(comicNumber: Int, comicTitle: String)
    }

    lateinit var currentComic: ComicUi

    fun setComicData() {
        view.titleText.text = currentComic.title
        setFavoriteImg()
        drawComicImg()
    }

    private fun setFavoriteImg() {
        view.favoriteImg.setDrawableColor(if (currentComic.favorite) (R.color.yellow) else (R.color.line_color))
    }

    private fun drawComicImg() {
        view.progressBar.visibility = View.VISIBLE
        Glide
            .with(view.context)
            .load(currentComic.imgLink)
            .optionalFitCenter()
            .listener(object : RequestListener<Drawable>{
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    view.progressBar.visibility = View.GONE
                    return false
                }
                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    view.progressBar.visibility = View.GONE
                    return false
                }
            })
            .into(view.comicImg)
    }

    val favoriteSectionClickListener = View.OnClickListener {
        eventCallback.onFavoriteClicked()
        currentComic.favorite = !currentComic.favorite
        setFavoriteImg()
    }

    val randomSectionClickListener = View.OnClickListener {
        eventCallback.onRandomComicClicked()
    }

    val explainSectionClickListener = View.OnClickListener {
        eventCallback.onExplanationClicked(currentComic.comicNumber, currentComic.title)
    }
}