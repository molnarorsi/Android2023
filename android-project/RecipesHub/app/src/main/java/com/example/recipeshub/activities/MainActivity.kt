package com.example.recipeshub.activities

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.recipeshub.databinding.ActivityMainBinding
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.recipeshub.R
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
            navController = findNavController(R.id.navHostFragment)
            when(it.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.homeFragment)
                    return@OnItemSelectedListener true
                }
                R.id.profile -> {
                    navController.navigate(R.id.profileFragment)
                    return@OnItemSelectedListener true
                }
                R.id.recipes -> {
                    navController.navigate(R.id.recipesFragment)
                    return@OnItemSelectedListener true
                }
                else -> return@OnItemSelectedListener true
            }
        })

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: MainActivity started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: MainActivity resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: MainActivity paused.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: MainActivity stopped.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: MainActivity destroyed.")
    }

}