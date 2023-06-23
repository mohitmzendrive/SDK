package com.mohitmandalia.adunit

import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController

/**
 *   Created by Mohit Mandalia
 */
object AdUnitStore {

    var adUnitViewFactory: AdUnitViewFactory = AdUnitDefaultViewFactory()
    var adUnitViewModel: AdUnitViewModel? = null
    lateinit var adUnitListItemContentBindingContract: AdUnitListItemContentBindingContract
    var navController: NavController? = null
    var iqlAdUnitStyleFactory: IQLAdExperienceStyleFactory? = null

    var contentViewManager: ContentViewManager? = null

}