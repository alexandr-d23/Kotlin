package com.example.myapplication

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_info.*



class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        id_emailUser.setText(intent.getStringExtra("email"))
        id_firstNameUser.setText(intent.getStringExtra("firstName"))
        id_lastNameUser.setText(intent.getStringExtra("lastName"))
        var imageId = intent.getIntExtra("imageId",-1)
        if(imageId!=-1) {
            imageView.setImageBitmap(
                BitmapFactory.decodeResource(
                    this.getResources(),
                    imageId
                )
            )
        }
    }




    fun logOut(view: View){
        MainActivity.saveLogOut()
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}
