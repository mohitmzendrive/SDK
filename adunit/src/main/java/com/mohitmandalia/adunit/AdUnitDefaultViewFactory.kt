package com.mohitmandalia.adunit

import android.content.Context

/**
 *   Created by Mohit Mandalia
 */

class AdUnitDefaultViewFactory: AdUnitViewFactory {
    override fun createAdUnitView(context: Context): AdUnitView {
        return AdUnitDefaultView(context)
    }
}