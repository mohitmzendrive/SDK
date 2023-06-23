package com.mohitmandalia.adunit

import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 *   Created by Mohit Mandalia
 */
interface PersonalInformationView {

    var titleTextView: TextView?
    var descriptionTextView: TextView?

    var firstNameContainer: TextInputLayout?
    var firstNameEditText: TextInputEditText?

    var lastNameContainer: TextInputLayout?
    var lastNameEditText: TextInputEditText?

    var emailContainer: TextInputLayout?
    var emailEditText: TextInputEditText?

    var dobContainer: TextInputLayout?
    var dobEditText: TextInputEditText?

    var streetContainer: TextInputLayout?
    var streetEditText: TextInputEditText?

    var cityContainer: TextInputLayout?
    var cityEditText: TextInputEditText?

    var zipCodeContainer: TextInputLayout?
    var zipCodeEditText: TextInputEditText?

    var stateListContainer: TextInputLayout?
    var stateListEditText: TextInputEditText?

    var zipCodeErrorTextView: TextView?
    var termsAndCondition: AppCompatTextView?
    var disclaimer: AppCompatTextView?

    var buttonConfirm: MaterialButton?

    var piContainer: ConstraintLayout?


    fun setDefaultValues() {
        this.firstNameEditText?.setText("Mohit")
        this.lastNameEditText?.setText("Mandalia")
        this.emailEditText?.setText("mohitm@zendrive.com")
        this.dobEditText?.setText("01/01/1998")
        this.streetEditText?.setText("Whitefield")
        this.cityEditText?.setText("Bengaluru")
        this.stateListEditText?.setText("KA")
        this.zipCodeEditText?.setText("568899")

        this.buttonConfirm?.isEnabled = true
    }

}