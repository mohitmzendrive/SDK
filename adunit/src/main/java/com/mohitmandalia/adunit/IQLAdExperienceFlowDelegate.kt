package com.mohitmandalia.adunit

/**
 *   Created by Mohit Mandalia
 */
interface IQLAdExperienceFlowDelegate {

    fun onStartIQLAdExperienceFlow()

    fun onStopIQLAdExperienceFlow()

    fun provideContentViewManager(): ContentViewManager?

    fun presentInitialView(adUnitView: AdUnitView, )

    fun removeInitialView()

}