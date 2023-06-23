package com.mohitmandalia.adunit

import android.content.Context

/**
 *   Created by Mohit Mandalia
 */

interface AdUnitViewFactory {

    fun createAdUnitView(context: Context): AdUnitView {
        return AdUnitDefaultView(context)
    }

    fun createPersonalInformationView(context: Context): PersonalInformationView {
        return PersonalInformationDefaultView(context)
    }

}