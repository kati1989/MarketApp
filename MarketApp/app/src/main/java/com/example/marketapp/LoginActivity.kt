package com.example.marketapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    var foodDb: MarketDatabase? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginUser(view: View) {
        val username = findViewById<EditText>(R.id.username).text
        val password = findViewById<EditText>(R.id.password).text
        //ha letezik a felhasznalo atnavigalunk a MainActivityre
        foodDb = MarketDatabase.getInstance(context = this)
        var profile: ProfileEntity = foodDb?.profileDao()!!.getProfileByEmail(username.toString(), password.toString());
        //hogyha van profil a db ben tovabb navigallunk, jelszo ellenorzes meg nincs.
        if (profile!=null) {
            var intent = Intent(this, MainActivity::class.java)

            val sharedPref = applicationContext?.getSharedPreferences("test", Context.MODE_PRIVATE)
            with (sharedPref!!.edit()) {
                putString("userName", username.toString())
                apply()
            }
            startActivity(intent)
        } else{
            val toast = Toast.makeText(applicationContext, "Invalid username or password!", Toast.LENGTH_SHORT)
            toast.show()
            toast.setGravity(Gravity.TOP or Gravity.LEFT, 0, 0)
        }
    }
}