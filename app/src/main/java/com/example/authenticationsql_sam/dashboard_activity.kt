package com.example.authenticationsql_sam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class dashboard_activity : AppCompatActivity() {

    lateinit var btn_logout:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btn_logout=findViewById(R.id.btnlogout)

        btn_logout.setOnClickListener {

            Toast.makeText(this, "You have successfully been logged out", Toast.LENGTH_SHORT).show()

            var backtologin = Intent(this,login_activity::class.java)
            startActivity(backtologin)
        }

    }
}