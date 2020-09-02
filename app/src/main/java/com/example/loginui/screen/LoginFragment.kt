package com.example.loginui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.loginui.R
import com.example.loginui.domain.login.LoginAccount
import com.example.loginui.domain.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(),  View.OnClickListener {


    val loginViewModel by activityViewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginButton.setOnClickListener(this)

        loginViewModel.getLoginAccountInfo().observe(viewLifecycleOwner, Observer {
            println("=============================")
            println("FRAGMENT LOGIN -> ")
            if (it != null) {
                println(it.message)
                println(it.token)
                println(it.account.id)
                println(it.account.username)
                println(it.account.password)
                println(it.account.status_account)

                println("sukses login")

            }
            println("=============================")
        })

    }

    override fun onClick(v: View) {
        when (v) {
            loginButton -> {

                loginViewModel.requestMontirLogin(
                    LoginAccount(
                        username = editTextUsername.text.toString(),
                        password = editTextPassword.text.toString()
                    )
                )
            }
        }
    }


}