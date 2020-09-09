package com.challenge.comicus.utils.extensions

import android.net.Uri
import com.challenge.comicus.utils.constants.ComicAppConstants.EXPLAIN_URL
import kotlin.random.Random

/**
 * Created by Pavel on 08/09/2020.
 **/

fun getRandomNumberInRange(maxRange: Int) = Random.nextInt(0, maxRange)

fun constructExplanationUrl(comicNum: Int, comicTitle: String): Uri =
    Uri.parse("$EXPLAIN_URL$comicNum:_${formatTitle(comicTitle)}")

fun formatTitle(title: String) = title.replace(" ".toRegex(), "_")