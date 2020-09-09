package com.challenge.comicus.utils.extensions

import android.view.View
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

/**
 * Created by Pavel on 08/09/2020.
 **/

@ColorInt
infix fun View.getColor(@ColorRes color: Int): Int {
    return ContextCompat.getColor(context, color)
}

fun ImageView.setDrawableColor(@ColorRes colorRes: Int) {
    val imageDrawable = this.drawable.mutate()
    DrawableCompat.setTint(imageDrawable, getColor(colorRes))
    this.setImageDrawable(imageDrawable)
}