package com.example.tpintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

//mes source de données
lateinit var listnom:ArrayList<String>
lateinit var listcontact:ArrayList<Contacts>

//my adapter
lateinit var MyAdapter: ArrayAdapter<String>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listnom= ArrayList()
        listcontact=ArrayList()
        MyAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,listnom)

        malistview.adapter=MyAdapter

        btnadd.setOnClickListener {
        var contact=Contacts(editnom.text.toString(),edittel.text.toString(),editmail.text.toString())
            listcontact.add(contact)
            listnom.add(contact.nom)
            MyAdapter.notifyDataSetChanged()
            malistview.setOnItemClickListener { adapterView, view, i, id ->
                var contactclic=listcontact[i]
                var i=Intent(this,MainActivity2::class.java)
                i.putExtra("clé",contactclic)
                startActivity(i)
            }


        }

    }
}