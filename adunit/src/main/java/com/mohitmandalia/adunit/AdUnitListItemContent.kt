package com.mohitmandalia.adunit

import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout

/**
 *   Created by Mohit Mandalia
 */
interface AdUnitListItemContentBindingContract {

    val bulletPoint: ImageView
    val adUnitContentTextView: AppCompatTextView
    val containerView: ConstraintLayout

    fun inflate(parent: ViewGroup): AdUnitListItemContentBindingContract
}