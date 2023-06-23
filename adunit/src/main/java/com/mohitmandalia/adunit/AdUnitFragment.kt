package com.mohitmandalia.adunit

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohitmandalia.adunit.databinding.FragmentAdUnitBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class AdUnitFragment : Fragment() {
    lateinit var binding: FragmentAdUnitBinding

    private val viewModel: AdUnitViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdUnitBinding.inflate(
            LayoutInflater.from(requireContext()), container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layout = binding.layout

        val adUnitView = AdUnitStore.adUnitViewFactory.createAdUnitView(requireContext())

        AdUnitStore.adUnitListItemContentBindingContract = adUnitView.adUnitListItemContentBindingContract!!

        val containerView = adUnitView.containerView
        AdUnitStore.iqlAdUnitStyleFactory?.let { styleFactory ->
            containerView?.backgroundTintList = ColorStateList.valueOf(Color.parseColor(styleFactory.backgroundColor))
            adUnitView.adUnitNextButton?.setBackgroundColor(Color.parseColor(styleFactory.buttonColor))
            adUnitView.adUnitNextButton?.setTextColor(Color.WHITE)
        }
        layout.addView(containerView)

        val constraintSet = ConstraintSet()
        constraintSet.clone(layout)

        constraintSet.constrainWidth(containerView!!.id, ConstraintSet.MATCH_CONSTRAINT)
        constraintSet.constrainHeight(containerView.id, ConstraintSet.WRAP_CONTENT)


        constraintSet.connect(
            containerView.id,
            ConstraintSet.TOP,
            ConstraintSet.PARENT_ID,
            ConstraintSet.TOP
        )
        constraintSet.connect(
            containerView.id,
            ConstraintSet.START,
            ConstraintSet.PARENT_ID,
            ConstraintSet.START
        )
        constraintSet.connect(
            containerView.id,
            ConstraintSet.END,
            ConstraintSet.PARENT_ID,
            ConstraintSet.END
        )

        constraintSet.applyTo(layout)

        adUnitView.viewModel = AdUnitStore.adUnitViewModel

        val adUnitViewModel = if(adUnitView.viewModel == null) {
            viewModel
        } else {
            adUnitView.viewModel
        }

        adUnitView.bind(viewModel = adUnitViewModel!!)

        lifecycleScope.launch {
            adUnitView.viewModel?.adUnitContent?.collectLatest { points ->
                adUnitView.adUnitContentRecyclerView.apply {
                    this?.visibility = View.VISIBLE
                    this?.layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    this?.adapter = PointsAdapter(points)
                }
            }
        }



        adUnitView.adUnitNextButton?.setOnClickListener {
           findNavController().navigate(R.id.action_adUnitFragment_to_PIFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = AdUnitFragment()
        val TAG = "AdUnitFragment"
    }
}