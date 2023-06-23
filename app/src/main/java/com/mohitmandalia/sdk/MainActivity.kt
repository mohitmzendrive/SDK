package com.mohitmandalia.sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import com.mohitmandalia.adunit.AdUnitView
import com.mohitmandalia.adunit.IQLAdExperienceModule
import com.mohitmandalia.adunit.AdUnitViewModel
import com.mohitmandalia.adunit.ContentViewManager
import com.mohitmandalia.adunit.IQLAdExperienceFlow
import com.mohitmandalia.adunit.IQLAdExperienceFlowDelegate
import com.mohitmandalia.adunit.IQLAdExperienceStyleFactory
import com.mohitmandalia.sdk.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val viewModel: CustomAdUnitViewModel by viewModels()

    lateinit var adUnitFlow: IQLAdExperienceFlow


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(
            LayoutInflater.from(this),null,false
        )
        setContentView(binding.root)

        binding.iqlUiButton.setOnClickListener {
            adUnitFlow = IQLAdExperienceModule.initializeAdExperienceFlow(
                activity = this,
                iqlAdExperienceFlowDelegate = IQLAdExperienceFlowDelegateImpl(
                    supportFragmentManager = supportFragmentManager,
                    fragmentContainerView = binding.fragmentContainer,
                    container = binding.root
                )
            )
        }

        binding.publisherCustomUiButton.setOnClickListener {
            adUnitFlow = IQLAdExperienceModule.initializeAdExperienceFlow(
                activity = this,
                adUnitViewFactory = AdUnitViewFactoryImpl(),
                adUnitViewModel = viewModel,
                iqlAdExperienceFlowDelegate = IQLAdExperienceFlowDelegateImpl(
                    supportFragmentManager = supportFragmentManager,
                    fragmentContainerView = binding.fragmentContainer,
                    container = binding.root
                )
            )
        }

        binding.publisherStyleUiButton.setOnClickListener {
            adUnitFlow = IQLAdExperienceModule.initializeAdExperienceFlow(
                activity = this,
                iqlAdExperienceFlowDelegate = IQLAdExperienceFlowDelegateImpl(
                    supportFragmentManager = supportFragmentManager,
                    fragmentContainerView = binding.fragmentContainer,
                    container = binding.root
                ),
                iqlAdExperienceStyleFactory = IQLAdExperienceStyleFactoryImpl()
            )
        }

    }


    companion object {
        val TAG = "MainActivity"
    }
}


class CustomAdUnitViewModel: AdUnitViewModel() {

    override val adUnitContent: MutableStateFlow<List<String>> = MutableStateFlow(
        listOf(
            "Get customized quote in minutes",
            "Customer satisfaction is a major priority",
            "Quality coverage with super affordable rates"
        )
    )
}

class IQLAdExperienceStyleFactoryImpl: IQLAdExperienceStyleFactory {
    override val backgroundColor: String
        get() = "#EDE7F6"
    override val buttonColor: String
        get() = "#673AB7"

}

class IQLAdExperienceFlowDelegateImpl(
    val supportFragmentManager: FragmentManager? = null,
    val fragmentContainerView: FragmentContainerView? = null,
    val container: ConstraintLayout
): IQLAdExperienceFlowDelegate {

    override fun onStartIQLAdExperienceFlow() {

    }

    override fun onStopIQLAdExperienceFlow() {

    }

    override fun provideContentViewManager(): ContentViewManager? {
        return if(supportFragmentManager != null && fragmentContainerView != null) {
            ContentViewManager(
                supportFragmentManager = supportFragmentManager,
                fragmentContainerView = fragmentContainerView
            )
        } else null

    }

    override fun presentInitialView(adUnitView: AdUnitView) {
//        container.addView(adUnitView.containerView)
//
//        val constraintSet = ConstraintSet()
//        constraintSet.clone(container)
//
//        constraintSet.constrainWidth(container!!.id, ConstraintSet.MATCH_CONSTRAINT)
//        constraintSet.constrainHeight(container.id, ConstraintSet.WRAP_CONTENT)
//
//
//        constraintSet.connect(
//            container.id,
//            ConstraintSet.TOP,
//            ConstraintSet.PARENT_ID,
//            ConstraintSet.TOP
//        )
//        constraintSet.connect(
//            container.id,
//            ConstraintSet.START,
//            ConstraintSet.PARENT_ID,
//            ConstraintSet.START
//        )
//        constraintSet.connect(
//            container.id,
//            ConstraintSet.END,
//            ConstraintSet.PARENT_ID,
//            ConstraintSet.END
//        )
//
//        constraintSet.applyTo(container)
    }

    override fun removeInitialView() {

    }

}