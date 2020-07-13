package com.example.smashitvmvvm.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.smashitvmvvm.R
import com.example.smashitvmvvm.consants.Constants
import com.example.smashitvmvvm.databinding.HomeHolderFragmentBinding
import com.example.smashitvmvvm.ui.activities.MainActivity
import com.example.smashitvmvvm.ui.base.BaseFragment
import com.example.smashitvmvvm.utils.Logger

class HomeHolderFragment : BaseFragment(){

    private lateinit var bindingHomeHolder : HomeHolderFragmentBinding
    private var activity: AppCompatActivity? = null
    private var mainActivity: MainActivity? = null
    private var homeFragment = HomeFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingHomeHolder = DataBindingUtil.inflate(inflater,
            R.layout.home_holder_fragment,
            container,
            false)
        return bindingHomeHolder.root
    }


    override fun onAttach(context: Context) {
        super.onAttach(context = context)
        activity = context as AppCompatActivity
        mainActivity = context as MainActivity
    }

    override fun setupViews(view: View) {
        parentFragmentManager.beginTransaction()
            .add(R.id.flHomeHolder, homeFragment, Constants.HOME_FRAGMENT_VAL)?.commit()
        Logger.logError(
            getString(R.string.backstackentrycount_home),
            "" + parentFragmentManager.backStackEntryCount
        )
    }

    /*fun addEstateFragment(categoryBundle: String) {
        // If the Estate Fragment is already on the top, the
        // category change will be handled on Estate Fragment
        // The Drawer Layout is common for HomeFragmentNew and
        // PlayerEstateFragment
        if (!categoriesFragment.isAdded) {
            Logger.logError(
                getString(R.string.backstackentrycount_home),
                "" + parentFragmentManager.backStackEntryCount
            )
            if (doesStackExist()) {
                removeAddedStack()
            }
            homeFragment.pauseVOD()
            val b = Bundle()
            b.putString("fragment_data", categoryBundle)
            categoriesFragment.arguments = b
            fragmentManager?.beginTransaction()
                ?.add(R.id.flHomeHolder, categoriesFragment, Constants.CATEGORIES_FRAGMENT_VAL)
                ?.addToBackStack(null)?.commit()
            Logger.logError(
                getString(R.string.backstackentrycount_home),
                "" + fragmentManager?.backStackEntryCount
            )
        } else categoriesFragment.onCategoryChanged(categoryBundle)
    }

    override fun onMenuItemChanged(playOn: Boolean) {
        // Fragment Communication so that respective player
        // can be paused and played at different times
        // according to the existence of the Stack of Fragments
        if (doesStackExist()) {
            if (categoriesFragment.isAdded)
                categoriesFragment.playPausePlayer(playOn)
        } else
            homeFragment.playPausePlayer(playOn)
    }

    fun regainHomePlayerFocus(){
        homeFragment.regainOrientation()
    }

    fun doesStackExist() : Boolean{
        return fragmentManager?.backStackEntryCount!! > 0
    }

    fun removeAddedStack(){
        fragmentManager?.popBackStack()
    }*/


}