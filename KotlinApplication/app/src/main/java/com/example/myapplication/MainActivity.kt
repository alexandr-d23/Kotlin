package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data = UserData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(checkLogged()){
            startInfoActivity(data.getUsers().get(getLoggedEmail()))
        }
    }

    companion object{
        lateinit var sPref: SharedPreferences
        val authorizated = "authorizationInfo"
        val checkLogged = "logged"
        val checkEmail = "currentEmail"
        public  fun saveLogOut(){
            if(sPref!=null) {
                val save = sPref.edit()
                save.putBoolean(checkLogged, false)
                save.apply()
            }
        }
    }

    fun clickLogIn(view: View){
        if(checkCorrect()){
            saveLogged(emailText.text.toString())
            startInfoActivity(data.getUsers().get(emailText.text.toString()))
        }
    }

    private fun startInfoActivity(user:User?){
        if(user!=null){
        val intentInfo = Intent(this, InfoActivity::class.java)
        intentInfo.putExtra("firstName",user.getFirstName())
        intentInfo.putExtra("lastName",user.getLastName())
        intentInfo.putExtra("email",user.getEmail())
        intentInfo.putExtra("imageId",user.getIdOfImage())
        startActivity(intentInfo)
        }
    }

    private fun checkCorrect():Boolean{
        var email = emailText.text.toString()
        var pass = passwordText.text.toString()
        val regEmail = Regex("[A-Za-z\\-_.0-9]{2,20}@[A-Za-z]{2,10}\\.[a-z]{2,5}")
        if(regEmail.matches(email)&& pass.length>=6 && Regex("""\d+""").containsMatchIn(pass) &&
            Regex("[A-Z]").containsMatchIn(pass) && Regex("[a-z]").containsMatchIn(pass) ){
            if (data.getUsers().containsKey(email) && data.getUsers().get(email)?.getPassword().equals(pass)){
                return true
            }
            else{
                Toast.makeText(this, "Incorrect email or password ", Toast.LENGTH_SHORT).show()
                return false
            }
            return false
        }
        else{
            Toast.makeText(this, "Incorrect format of email or password", Toast.LENGTH_SHORT).show()
        }
        return false
    }

    private fun checkLogged() :Boolean{
        sPref = getSharedPreferences(authorizated, AppCompatActivity.MODE_PRIVATE)
        if(sPref.contains(checkLogged) && sPref.getBoolean(checkLogged,false)){
            return true
        }
        return false
    }

    private fun getLoggedEmail ():String?{
        return sPref.getString(checkEmail,"")
    }

    private fun saveLogged(email :String){
        val save = sPref.edit()
        save.putBoolean(checkLogged,true)
        save.putString(checkEmail, email)
        save.apply()
    }
}
