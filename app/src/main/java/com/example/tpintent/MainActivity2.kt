package com.example.tpintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var contact= intent.getSerializableExtra("clé") as Contacts

            nomtxt.text=contact.nom
            teltxt.text=contact.tel
            mailtxt.text=contact.mail

        btn1.setOnClickListener {
            var i = Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+contact.tel))
            startActivity(i)
        }
        btn3.setOnClickListener {

            var i = Intent(Intent.ACTION_SEND, Uri.parse("sms:"+contact.tel))
            startActivity(i)
        }
        btn2.setOnClickListener {

            var i = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+contact.mail))
            startActivity(i)
        }
    }
}