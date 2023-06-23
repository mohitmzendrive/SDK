package com.mohitmandalia.adunit

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 *   Created by Mohit Mandalia
 */
object IQLAdExperienceModule {

    fun initializeAdExperienceFlow(
        activity: ComponentActivity,
        iqlAdExperienceFlowDelegate: IQLAdExperienceFlowDelegate,
        iqlAdExperienceStyleFactory: IQLAdExperienceStyleFactory? = null,
        adUnitViewFactory: AdUnitViewFactory? = null,
        adUnitViewModel: AdUnitViewModel? = null
    ): IQLAdExperienceFlow {

        return internalInit(
            activity = activity,
            iqlAdExperienceStyleFactory = iqlAdExperienceStyleFactory,
            adUnitViewFactory = adUnitViewFactory,
            iqlAdExperienceFlowDelegate = iqlAdExperienceFlowDelegate,
            adUnitViewModel = adUnitViewModel
        )
    }

    private fun internalInit(
        activity: ComponentActivity,
        iqlAdExperienceFlowDelegate: IQLAdExperienceFlowDelegate,
        iqlAdExperienceStyleFactory: IQLAdExperienceStyleFactory? = null,
        adUnitViewFactory: AdUnitViewFactory? = null,
        adUnitViewModel: AdUnitViewModel? = null
    ): IQLAdExperienceFlow {

        AdUnitStore.adUnitViewFactory = adUnitViewFactory ?: AdUnitDefaultViewFactory()
        AdUnitStore.adUnitViewModel = adUnitViewModel
        AdUnitStore.iqlAdUnitStyleFactory = iqlAdExperienceStyleFactory
        AdUnitStore.contentViewManager = iqlAdExperienceFlowDelegate.provideContentViewManager()



        if(AdUnitStore.contentViewManager != null) {
            launchFragment(AdUnitStore.contentViewManager!!)
        } else {
            val adUnitView = AdUnitStore.adUnitViewFactory.createAdUnitView(activity.applicationContext)

            if(adUnitViewModel == null) {
                val viewModel: AdUnitViewModel by activity.viewModels()
                AdUnitStore.adUnitViewModel = viewModel
            }

            adUnitView.bind(AdUnitStore.adUnitViewModel!!)
            observers(
                adUnitView = adUnitView,
                iqlAdExperienceFlowDelegate = iqlAdExperienceFlowDelegate,
                activity = activity
            )
        }

        return IQLAdExperienceFlow()
    }

    private fun observers(
        activity: ComponentActivity,
        iqlAdExperienceFlowDelegate: IQLAdExperienceFlowDelegate,
        adUnitView: AdUnitView
    ) {
        activity.lifecycleScope.launch {
            AdUnitStore.adUnitViewModel?.userQualification?.collectLatest {
                if(it) {
                    iqlAdExperienceFlowDelegate.presentInitialView(adUnitView)
                }
            }
        }
    }

    private fun launchFragment(
        contentViewManager: ContentViewManager
    ) {
        val navHost = NavHostFragment.create(R.navigation.adunit_navigation)
        val supportFragmentManager = contentViewManager.supportFragmentManager
        val containerView = contentViewManager.fragmentContainerView

        supportFragmentManager.beginTransaction()
            .replace(containerView.id, navHost)
            .setPrimaryNavigationFragment(navHost)
            .commit()

    }
}