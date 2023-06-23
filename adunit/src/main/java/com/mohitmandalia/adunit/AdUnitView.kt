package com.mohitmandalia.adunit

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

/**
 *   Created by Mohit Mandalia
 */
interface AdUnitView {

    var titleTextView: AppCompatTextView?
    var bodyTextView: AppCompatTextView?
    var policyTextView: AppCompatTextView?
    var adImage: AppCompatImageView?
    var logo: AppCompatImageView?
    var logoCard: MaterialCardView?
    var adUnitNextButton: MaterialButton?
    var containerView: MaterialCardView?
    var adUnitListItemContentBindingContract: AdUnitListItemContentBindingContract?
    var adUnitContentRecyclerView: RecyclerView?
    var viewModel: AdUnitViewModel?

    fun bind(viewModel: AdUnitViewModel) {
        this.viewModel = viewModel
    }

}