package com.mohitmandalia.adunit

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.mohitmandalia.adunit.databinding.AdunitBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


/**
 *   Created by Mohit Mandalia
 */
class AdUnitDefaultView: ConstraintLayout, AdUnitView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )


    override var titleTextView: AppCompatTextView? = null

    override var bodyTextView: AppCompatTextView? = null

    override var policyTextView: AppCompatTextView? = null

    override var adImage: AppCompatImageView? = null

    override var logo: AppCompatImageView? = null

    override var adUnitNextButton: MaterialButton? = null

    override var containerView: MaterialCardView? = null

    override var viewModel: AdUnitViewModel? = null

    override var adUnitListItemContentBindingContract: AdUnitListItemContentBindingContract? = AdUnitListItemDefaultBindingImplContract()
    override var adUnitContentRecyclerView: RecyclerView? = null

    override var logoCard: MaterialCardView? = null

    init {
        val adUnitDefaultBinding = AdunitBinding.inflate(
            LayoutInflater.from(context),null,false
        )
        this.titleTextView = adUnitDefaultBinding.title
        this.adUnitNextButton = adUnitDefaultBinding.next
        this.containerView = adUnitDefaultBinding.root
        this.bodyTextView = adUnitDefaultBinding.body
        this.policyTextView = adUnitDefaultBinding.currentPolicyHolder
        this.adImage = adUnitDefaultBinding.adImage
        this.logo = adUnitDefaultBinding.logo
        this.logoCard = adUnitDefaultBinding.logoCard
        this.adUnitContentRecyclerView = adUnitDefaultBinding.points
    }

    override fun bind(viewModel: AdUnitViewModel) {
        this.viewModel = viewModel
    }
}