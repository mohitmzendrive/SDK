package com.mohitmandalia.adunit

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.mohitmandalia.adunit.databinding.LayoutItemPointBinding

/**
 *   Created by Mohit Mandalia
 */
class AdUnitListItemDefaultBindingImplContract: AdUnitListItemContentBindingContract {

    private lateinit var binding: LayoutItemPointBinding
    override val bulletPoint: ImageView
        get() = binding.setupIntroBulletFirst
    override val adUnitContentTextView: AppCompatTextView
        get() = binding.textView
    override val containerView: ConstraintLayout
        get() = binding.root


    override fun inflate(parent: ViewGroup): AdUnitListItemContentBindingContract {
        binding = LayoutItemPointBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return this
    }

}