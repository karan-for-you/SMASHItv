package com.example.smashitvmvvm.ui.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.smashitvmvvm.R
import com.example.smashitvmvvm.consants.Constants
import com.example.smashitvmvvm.databinding.ActivityMainBinding
import com.example.smashitvmvvm.ui.base.BaseActivity
import com.example.smashitvmvvm.ui.fragment.AccountFragment
import com.example.smashitvmvvm.ui.fragment.HomeHolderFragment
import com.example.smashitvmvvm.ui.fragment.SearchFragment
import com.example.smashitvmvvm.ui.fragment.SettingsFragment
import com.example.smashitvmvvm.ui.handler.MainHandler
import com.example.smashitvmvvm.ui.viewmodel.MainViewModel
import com.example.smashitvmvvm.utils.Logger

class MainActivity : BaseActivity(), MainHandler {

    private lateinit var bindingMainActivity : ActivityMainBinding
    private lateinit var mainViewModel : MainViewModel
    private lateinit var fragmentManager : FragmentManager

    // Main View Fragments
    var activeFragment : Fragment? = HomeHolderFragment()
    var homeHolder = HomeHolderFragment()
    var searchFragment = SearchFragment()
    var accountFragment = AccountFragment()
    var settingsFragment = SettingsFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = DataBindingUtil.setContentView(this,R.layout.activity_main)
        fragmentManager = supportFragmentManager
        setupViewModelAndHandler()
        initUI()
        //letAndRunInstances()
    }

    private fun setupViewModelAndHandler(){
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        bindingMainActivity.viewModel = mainViewModel
        bindingMainActivity.handler = this
    }

    private fun initUI(){
        bindingMainActivity.bottomNavView.itemIconTintList = null
        setupBottomNavigationObserver()
        setupHomeAsDefault()
        initializeFragments()
    }

    private fun initializeFragments(){
        fragmentManager.beginTransaction().add(homeHolder,Constants.HOME_FRAGMENT_VAL)
            .hide(homeHolder).commit()
        fragmentManager.beginTransaction().add(searchFragment,Constants.SEARCH_FRAGMENT_VAL)
            .hide(searchFragment).commit()
        fragmentManager.beginTransaction().add(accountFragment,Constants.ACCOUNT_FRAGMENT_VAL)
            .hide(accountFragment).commit()
        fragmentManager.beginTransaction().add(settingsFragment,Constants.SETTINGS_FRAGMENT_VAL)
            .hide(settingsFragment).commit()
    }

    private fun hideShowFragment(currentFragment: Fragment) {
        if (currentFragment != activeFragment) {
            var animArray: IntArray = intArrayOf(R.anim.slide_in_right, R.anim.slide_out_right)
            if (activeFragment != null && activeFragment?.tag != null) {
                val currentValue: Int = currentFragment.tag!!.toInt()
                val activeValue: Int = activeFragment?.tag!!.toInt()
                animArray = if (currentValue < activeValue)
                    intArrayOf(R.anim.slide_in_right, R.anim.slide_out_right)
                else
                    intArrayOf(R.anim.slide_in_left, R.anim.slide_new)
            }
            fragmentManager.beginTransaction()
                .setCustomAnimations(animArray[0], animArray[1])
                .hide(activeFragment!!).show(currentFragment).commit()
            activeFragment = currentFragment
            Logger.logError("BackstackEntryCount - Main", "" + fragmentManager.backStackEntryCount)
        } else Logger.logError(
            MainActivity::class.java.simpleName,
            getString(R.string.same_fragment_selected)
        )
    }


    private fun setupHomeAsDefault(){
        // To highlight Home on bottom navigation view without listener
        bindingMainActivity.bottomNavView.selectedItemId = R.id.home
        // To invoke the actual listener placed in View Model
        mainViewModel.setHomeLiveData()
    }

    private fun setupBottomNavigationObserver(){
        mainViewModel.getBottomMenuLiveData().observe(
            this,
            Observer<String> { t ->
                when(t){
                    Constants.HOME_FRAGMENT_VAL -> hideShowFragment(homeHolder)
                    Constants.SEARCH_FRAGMENT_VAL -> hideShowFragment(searchFragment)
                    Constants.ACCOUNT_FRAGMENT_VAL -> hideShowFragment(accountFragment)
                    Constants.SETTINGS_FRAGMENT_VAL -> hideShowFragment(settingsFragment)
                }
            }
        )
    }

    private fun letAndRunInstances(){

        // Will Print Data
        val str1 = "Data"
        str1.let { Logger.logError("Let Fun 1",it+" "+it.length) }

        // Let block will executed but results will be null
        val str2 : String? = null
        str2.let { Logger.logError("Let Fun 2",it+" "+it?.length) }

        // Let block won't be executed
        val str3 :String? = null
        str3?.let { Logger.logError("Let Fun 3",""+it.length) }

        // "run" changed the outer value, can't use "it" in run
        var tutorial = "This is Kotlin Tutorial"
        Logger.logError("Run 1",tutorial) //This is Kotlin Tutorial
        tutorial = run {
            val tutorial2 = "This is run function"
            tutorial2
        }
        Logger.logError("Run 2",tutorial) //This is run function

        // So did "let"
        var letTut1 = "Init Value"
        Logger.logError("Let Change Outer 1",letTut1)
        letTut1 = letTut1.let{
            val letTut2 =it+"Data"
            letTut2
        }
        Logger.logError("Let change outer 2",letTut1)
    }



}