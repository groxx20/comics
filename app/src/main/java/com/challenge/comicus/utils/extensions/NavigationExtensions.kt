package com.challenge.comicus.utils.extensions

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment

/**
 * Created by Pavel on 08/09/2020.
 **/

fun Fragment.findNavController(): NavController = NavHostFragment.findNavController(this)
fun Fragment.navigate(
    @IdRes actionId: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null,
    navigatorExtras: FragmentNavigator.Extras? = null
) {
    findNavController().navigate(actionId, args, navOptions, navigatorExtras)
}