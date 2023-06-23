package com.mohitmandalia.sdk

import android.content.Context
import com.mohitmandalia.adunit.AdUnitView
import com.mohitmandalia.adunit.AdUnitViewFactory
import com.mohitmandalia.adunit.PersonalInformationView

/**
 *   Created by Mohit Mandalia
 */
class AdUnitViewFactoryImpl: AdUnitViewFactory {

    override fun createAdUnitView(context: Context): AdUnitView {
        return CustomAdUnitView(context)
    }

    override fun createPersonalInformationView(context: Context): PersonalInformationView {
        return CustomPiView(context)
    }
}