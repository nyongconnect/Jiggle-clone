package com.nyongconnect.jiggle

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nyongconnect.jiggle.adapter.TransactionAdapter
import com.nyongconnect.jiggle.dataManager.TransactionDataManager
import com.nyongconnect.jiggle.model.Transaction

class MainActivity : AppCompatActivity() {


    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setDefaultDisplayHomeAsUpEnabled(false)
            actionbar.setDisplayShowHomeEnabled(false)
            actionbar.setDisplayShowTitleEnabled(false)
            actionbar.setDisplayUseLogoEnabled(false)
            actionbar.setHomeButtonEnabled(false)
        }


        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onStart() {
        super.onStart()
        setHomeFragment()
    }

    //TODO: change the function signature to accept other fragment and move code to mainActivity
    private fun setHomeFragment() {
        val homeFragment = HomeFragment()
        val fragment = supportFragmentManager
        val transaction = fragment.beginTransaction()
        transaction.replace(R.id.fragment_layout, homeFragment)
        transaction.commit()
    }

}