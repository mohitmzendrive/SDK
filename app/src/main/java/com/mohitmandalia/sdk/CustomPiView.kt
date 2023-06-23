package com.mohitmandalia.sdk

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mohitmandalia.adunit.PersonalInformationView
import com.mohitmandalia.adunit.databinding.PersonalInformationViewBinding
import com.mohitmandalia.sdk.databinding.PiViewBinding

/**
 *   Created by Mohit Mandalia
 */
class CustomPiView: ConstraintLayout, PersonalInformationView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    override var titleTextView: TextView? = null
    override var descriptionTextView: TextView? = null
    override var firstNameContainer: TextInputLayout? = null
    override var firstNameEditText: TextInputEditText? = null
    override var lastNameContainer: TextInputLayout? = null
    override var lastNameEditText: TextInputEditText? = null
    override var emailContainer: TextInputLayout? = null
    override var emailEditText: TextInputEditText? = null
    override var dobContainer: TextInputLayout? = null
    override var dobEditText: TextInputEditText? = null
    override var streetContainer: TextInputLayout? = null
    override var streetEditText: TextInputEditText? = null
    override var cityContainer: TextInputLayout? = null
    override var cityEditText: TextInputEditText? = null
    override var zipCodeContainer: TextInputLayout? = null
    override var zipCodeEditText: TextInputEditText? = null
    override var stateListContainer: TextInputLayout? = null
    override var stateListEditText: TextInputEditText? = null
    override var zipCodeErrorTextView: TextView? = null
    override var termsAndCondition: AppCompatTextView? = null
    override var disclaimer: AppCompatTextView? = null
    override var buttonConfirm: MaterialButton? = null
    override var piContainer: ConstraintLayout? = null


    init {
        val personalInformationViewBinding = PiViewBinding.inflate(
            LayoutInflater.from(context), null, false
        )

        this.titleTextView = personalInformationViewBinding.yourAreAlmost
        this.descriptionTextView = personalInformationViewBinding.letsMakeSure
        this.firstNameContainer = personalInformationViewBinding.firstNameContainer
        this.firstNameEditText = personalInformationViewBinding.firstNameEditText
        this.lastNameContainer = personalInformationViewBinding.lastNameContainer
        this.lastNameEditText = personalInformationViewBinding.lastNameEditText
        this.emailContainer = personalInformationViewBinding.emailContainer
        this.emailEditText = personalInformationViewBinding.emailEditText
        this.dobContainer = personalInformationViewBinding.dobContainer
        this.dobEditText = personalInformationViewBinding.dobEditText
        this.streetContainer = personalInformationViewBinding.streetContainer
        this.streetEditText = personalInformationViewBinding.streetEditText
        this.cityContainer = personalInformationViewBinding.cityContainer
        this.cityEditText = personalInformationViewBinding.cityEditText
        this.zipCodeContainer = personalInformationViewBinding.zipCodeContainer
        this.zipCodeEditText = personalInformationViewBinding.zipCodeEditText
        this.zipCodeErrorTextView = personalInformationViewBinding.zipCodeErrorTextView
        this.stateListContainer = personalInformationViewBinding.stateListContainer
        this.stateListEditText = personalInformationViewBinding.stateEditText
        this.termsAndCondition = personalInformationViewBinding.termsAndCondition
        this.disclaimer = personalInformationViewBinding.disclaimer
        this.buttonConfirm = personalInformationViewBinding.buttonConfirm
        this.piContainer = personalInformationViewBinding.appPiContainerLayout

    }
}