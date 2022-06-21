package com.ilhamhadisyah.suitmediatest.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.ilhamhadisyah.suitmediatest.R
import com.ilhamhadisyah.suitmediatest.databinding.ActivityScreen3Binding


class Screen3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityScreen3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.navigationIcon =
            resources.getDrawable(R.drawable.ic_back)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.event_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finishAndRemoveTask()
            }
            R.id.switch_map_list -> {
                val navHostFragment =
                    supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                val currentFragment =
                    navHostFragment!!.childFragmentManager.fragments[0] as Fragment
                val navController = Navigation.findNavController(
                    this,
                    R.id.nav_host_fragment
                )

                if (currentFragment is EventListFragment) {
                    item.setIcon(R.drawable.ic_list_view)
                    navController.navigate(R.id.action_eventListFragment_to_eventMapsFragment)
//                    navController.popBackStack(R.id.eventMapsFragment,false)
                } else if (currentFragment is EventMapsFragment) {
                    item.setIcon(R.drawable.ic_map_view)
                    navController.navigate(R.id.action_eventMapsFragment_to_eventListFragment)
//                    navController.popBackStack(R.id.eventListFragment,false)
                }

            }
        }
        return super.onOptionsItemSelected(item)
    }
}