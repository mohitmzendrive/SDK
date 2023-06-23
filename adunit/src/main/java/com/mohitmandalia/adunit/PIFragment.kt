package com.mohitmandalia.adunit

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import com.mohitmandalia.adunit.databinding.FragmentPIBinding


class PIFragment : Fragment() {

    lateinit var piFragmentBinding: FragmentPIBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        piFragmentBinding = FragmentPIBinding.inflate(
            LayoutInflater.from(requireContext()),container,false
        )
        return piFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layout = piFragmentBinding.piFragmentContainer

        val piView = AdUnitStore.adUnitViewFactory.createPersonalInformationView(requireContext())

        val containerView = piView.piContainer

        AdUnitStore.iqlAdUnitStyleFactory?.let { styleFactory ->
            containerView?.setBackgroundColor(Color.parseColor(styleFactory.backgroundColor))
            piView.buttonConfirm?.setTextColor(Color.WHITE)
            piView.buttonConfirm?.setBackgroundColor(Color.parseColor(styleFactory.buttonColor))
            piView.firstNameContainer?.boxBackgroundColor = Color.parseColor(styleFactory.backgroundColor)
            piView.lastNameContainer?.boxBackgroundColor = Color.parseColor(styleFactory.backgroundColor)
            piView.emailContainer?.boxBackgroundColor = Color.parseColor(styleFactory.backgroundColor)
            piView.dobContainer?.boxBackgroundColor = Color.parseColor(styleFactory.backgroundColor)
            piView.streetContainer?.boxBackgroundColor = Color.parseColor(styleFactory.backgroundColor)
            piView.cityContainer?.boxBackgroundColor = Color.parseColor(styleFactory.backgroundColor)
            piView.stateListContainer?.boxBackgroundColor = Color.parseColor(styleFactory.backgroundColor)
            piView.zipCodeContainer?.boxBackgroundColor = Color.parseColor(styleFactory.backgroundColor)
        }

        layout.addView(containerView)

        piView.setDefaultValues()

    }

    companion object {

        @JvmStatic
        fun newInstance() = PIFragment()
    }
}