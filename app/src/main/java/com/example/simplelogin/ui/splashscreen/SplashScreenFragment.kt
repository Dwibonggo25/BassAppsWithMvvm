package com.example.simplelogin.ui.splashscreen

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.simplelogin.BR.fragment
import com.example.simplelogin.R
import com.example.simplelogin.databinding.FragmentLoginBinding
import com.example.simplelogin.databinding.FragmentSplashScreenBinding
import com.example.simplelogin.ui.LoginViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SplashScreenFragment : Fragment() {

    private lateinit var viewModel : SplashScreenViewmodel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var binding: FragmentSplashScreenBinding

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashScreenViewmodel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash_screen, container, false)
        binding.apply {
            fragment = this@SplashScreenFragment
            vm = viewModel
            binding.setLifecycleOwner(activity)
            binding.executePendingBindings()
        }

        return binding.root
    }
}
