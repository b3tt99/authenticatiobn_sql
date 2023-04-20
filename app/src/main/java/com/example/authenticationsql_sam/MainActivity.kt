package com.example.authenticationsql_sam

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edtfirstname:EditText
    lateinit var edtsecondname:EditText
    lateinit var edtemailaddress:EditText
    lateinit var edtpass:EditText
    lateinit var btnreg:Button
    lateinit var btnlog:Button
    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    edtfirstname=findViewById(R.id.edtfirst)
    edtsecondname=findViewById(R.id.edtsecond)
    edtemailaddress=findViewById(R.id.edtemail)
    edtpass=findViewById(R.id.edtpassword)
    btnreg=findViewById(R.id.btnregister)
    btnlog=findViewById(R.id.btnlogin)

    db = openOrCreateDatabase("samanthaDB", Context.MODE_PRIVATE, null)

        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina1 VARCHAR, jina2 VARCHAR, arafa VARCHAR, funguo VARCHAR)")

        btnreg.setOnClickListener{
            //Receive data from the user
            var name1_edt = edtfirstname.text.toString().trim()
            var name2_edt = edtsecondname.text.toString().trim()
            var email_edt = edtemailaddress.text.toString().trim()
            var pass_edt = edtpass.text.toString().trim()
            //Check if the user is trying to submit empty records
            if (name1_edt.isEmpty()|| name2_edt.isEmpty() ||email_edt.isEmpty()|| pass_edt.isEmpty() ){
                Toast.makeText(this, "Check your input fields", Toast.LENGTH_SHORT).show()
            }else {
                //Proceed to save your data into the db
                //db.execSQL("CREATE TABLE IF NOT EXISTS users(jina1 VACHAR, jina2 VACHAR, arafa VACHAR, funguo VACHAR)")

                db.execSQL("INSERT INTO users VALUES ('"+name1_edt+"','"+name2_edt+"','"+email_edt+"','"+pass_edt+"')")
                Toast.makeText(this, "Data has been saved successfully", Toast.LENGTH_SHORT).show()

            }
        }
        btnlog.setOnClickListener {
            var gotologin = Intent(this, login_activity::class.java)
            startActivity(gotologin)
        }
    }
}