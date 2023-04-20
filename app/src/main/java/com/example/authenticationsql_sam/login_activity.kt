package com.example.authenticationsql_sam

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login_activity : AppCompatActivity() {
    lateinit var editemail: EditText
    lateinit var editpass: EditText
    lateinit var buttonlog:Button
    lateinit var buttonreg: Button
    lateinit var db:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editemail=findViewById(R.id.edxtemail)
        editpass=findViewById(R.id.edxtpass)
        buttonlog=findViewById(R.id.btnlogh)
        buttonreg=findViewById(R.id.btnreg)

        db=openOrCreateDatabase("samanthaDB", MODE_PRIVATE,null)

        buttonlog.setOnClickListener {
            var email = editemail.text.toString().trim()
            var password = editpass.text.toString().trim()

            //validates
            if (email.isEmpty()|| password.isEmpty()){

                Toast.makeText(this, "Cannot submit an empty field", Toast.LENGTH_SHORT).show()

            }else{
                val cursor = db.rawQuery("SELECT * FROM users WHERE arafa=? AND funguo=?", arrayOf(email, password))

                if (cursor != null && cursor.moveToFirst()) {
                    // user is authenticated, start a new activity
                    val intent = Intent(this, dashboard_activity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid email or password, please try again", Toast.LENGTH_SHORT).show()
                }

            }
        }

        buttonreg.setOnClickListener {
            Toast.makeText(this, "User Successfully registered", Toast.LENGTH_SHORT).show()

            var gotomain = Intent(this,MainActivity::class.java)
            startActivity(gotomain)
        }

    }
}