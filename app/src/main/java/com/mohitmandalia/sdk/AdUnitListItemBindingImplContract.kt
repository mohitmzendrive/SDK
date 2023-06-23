package com.mohitmandalia.sdk

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.mohitmandalia.adunit.AdUnitListItemContentBindingContract
import com.mohitmandalia.sdk.databinding.AdUnitPointItemBinding

/**
 *   Created by Mohit Mandalia
 */
class AdUnitListItemBindingImplContract: AdUnitListItemContentBindingContract {

    private lateinit var binding: AdUnitPointItemBinding
    override val bulletPoint: ImageView
        get() = binding.setupIntroBulletFirst
    override val adUnitContentTextView: AppCompatTextView
        get() = binding.textView
    override val containerView: ConstraintLayout
        get() = binding.root


    override fun inflate(parent: ViewGroup): AdUnitListItemContentBindingContract {
        binding = AdUnitPointItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return this
    }

}