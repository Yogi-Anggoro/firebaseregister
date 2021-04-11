package com.example.firebaseapk1.fitur.register

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.example.firebaseapk1.R
import com.example.firebaseapk1.model.User
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterContract.View {

    override lateinit var presenter: RegisterContract.Presenter
    private var loading: ProgressDialog? = null
    init {
        RegisterPresenter(this,this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        loading = ProgressDialog(this)
        btn_register.setOnClickListener {
            if (handleInput()) {
                val user = User(
                    et_nama.text.toString(),
                    et_email.text.toString(),
                    et_lahir.text.toString(),
                    et_password.text.toString()

                )
                presenter.register(user)
            }
        }
    }

    override fun onError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        loading?.dismiss()
    }

    override fun onSucces(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        loading?.dismiss()
    }

    override fun onProcess(message: Boolean) {
        loading?.setMessage("Loading")
        loading?.setCancelable(false)
        loading?.show()
    }

    private fun handleInput() : Boolean{
        if (et_nama.text.isEmpty()){
            et_nama.error = getString(R.string.fill_data)
            et_nama.requestFocus()
            return false
        }
        if (et_email.text.isEmpty()) {
            et_email.error = getString(R.string.fill_data)
            et_email.requestFocus()
            return false
        }
        if (et_lahir.text.isEmpty()) {
            et_lahir.error = getString(R.string.fill_data)
            et_lahir.requestFocus()
            return false
        }
        if (et_password.text.isEmpty()) {
            et_password.error = getString(R.string.fill_data)
            et_password.requestFocus()
            return false
        }
        return true
    }
}