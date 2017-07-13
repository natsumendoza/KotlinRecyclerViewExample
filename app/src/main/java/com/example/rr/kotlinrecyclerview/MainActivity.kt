package com.example.rr.kotlinrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val users = ArrayList<User>()
        users.add(User("Roxel Mendoza", "Pembo, Makati"))
        users.add(User("Clarisse Quizora", "Pasay"))
        users.add(User("RR Mendoza", "Pembo, Makati"))

        val adapter = CustomAdapter(users) {
            toast("clicked! ${it.name}")
        }

        recyclerView.adapter = adapter

    }
}
