package com.example.mvvmloginexample

import android.text.TextUtils
import android.util.Patterns
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.journaldev.androidmvvmbasics.model.Login


class LoginViewModel(): BaseObservable() {


    private  var login:Login
   private val successMessage= "Login was successful";
   private val errorMessage = "Email or Password not valid";

 init{
    login = Login("","")
   }

    //to show  message and bind on button click
    @Bindable
       var toastMessage: String? = null
        get() = field
        set(value) {
            field = value
        notifyPropertyChanged(BR.toastMessage)
        }


    fun setUserName(username: String?) {
        login.username=username!!
        notifyPropertyChanged(BR.userName)
    }

    @Bindable
    fun getUserName(): String? {
        return login.username
    }


    @Bindable
    fun getUserPassword(): String? {
        return login.password
    }

    fun setUserPassword(password: String?) {
        login.password=password!!
        notifyPropertyChanged(BR.userPassword)
    }

    fun onLoginClicked() {
        if (isInputDataValid()) toastMessage=successMessage else toastMessage=errorMessage
    }

    fun isInputDataValid(): Boolean {
        return !TextUtils.isEmpty(getUserName()) && Patterns.EMAIL_ADDRESS.matcher(getUserName())
            .matches() && getUserPassword()!!.length > 5
    }
}
