package com.example.mvvmloginexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmloginexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val   binding:ActivityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel=LoginViewModel()
        binding.executePendingBindings()

    }
companion object {
    @BindingAdapter("toastMessage")
    @JvmStatic
    public fun show(view: View, message: String?) {
        if(message!=null)
           Toast.makeText(view.context,message,Toast.LENGTH_SHORT).show() }

    }
}



