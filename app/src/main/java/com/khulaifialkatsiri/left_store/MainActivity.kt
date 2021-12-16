package com.khulaifialkatsiri.left_store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var currentFragment : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.nav_container, CatalogueFragment()).commit()
        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_navigaton)

        bottomNav.setOnNavigationItemSelectedListener(navListener)
    }

    val navListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.ic_Catalogue -> {
                currentFragment = CatalogueFragment()
            }
            R.id.ic_News -> {
                currentFragment = CekFragment()
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.nav_container, currentFragment).commit()
        true
    }
}