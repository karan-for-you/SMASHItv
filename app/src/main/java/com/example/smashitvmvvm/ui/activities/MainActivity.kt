package com.example.smashitvmvvm.ui.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.smashitvmvvm.R
import com.example.smashitvmvvm.databinding.ActivityMainBinding
import com.example.smashitvmvvm.ui.base.BaseActivity
import com.example.smashitvmvvm.ui.handler.MainHandler
import com.example.smashitvmvvm.ui.viewmodel.MainViewModel
import com.example.smashitvmvvm.utils.Logger

class MainActivity : BaseActivity(), MainHandler {

    private lateinit var bindingMainActivity : ActivityMainBinding
    private lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setupViewModelAndHandler()
        initUI()
        letAndRunInstances()
    }

    private fun setupViewModelAndHandler(){
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        bindingMainActivity.viewModel = mainViewModel
        bindingMainActivity.handler = this
    }

    private fun initUI(){
        bindingMainActivity.bottomNavView.itemIconTintList = null
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