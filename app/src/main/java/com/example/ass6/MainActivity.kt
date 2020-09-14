package com.example.ass6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().add(
                R.id.frameLayout,One_Fragment()
            ).commit()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val manager: FragmentManager = supportFragmentManager
        val transaction : FragmentTransaction = manager.beginTransaction()
        when (item?.itemId){

            R.id.menu1 ->{
                transaction.replace(R.id.frameLayout,Two_Fragment())
                transaction.addToBackStack(null)
                transaction.commit()
                return true
            }
            R.id.menu2 -> {
                transaction.replace(R.id.frameLayout,Three_Fragment())
                transaction.addToBackStack(null)
                transaction.commit()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}