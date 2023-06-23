package com.mohitmandalia.adunit

import android.content.Context
import android.content.Intent

/**
 *   Created by Mohit Mandalia
 */
class IQLAdExperienceFlow {

    /**
     *  launch flow as an Activity
     */
    fun launchAsScreen(context: Context) {
        val intent = Intent(context, IQLAdExperienceActivity::class.java)
        context.startActivity(intent)
    }

}