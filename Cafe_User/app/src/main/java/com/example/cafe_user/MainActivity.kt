package com.example.cafe_user

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cafe_user.ui.cart.CartFragment
import com.example.cafe_user.ui.home.HomeFragment
import com.example.cafe_user.ui.home.MenuRecycleItem
import com.example.cafe_user.ui.home.RecyclerCardAdapter
import kotlinx.android.synthetic.main.main_card_recycle_menu.*

class MainActivity : AppCompatActivity() {
    var homeview = HomeFragment()
    var cartview = CartFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_order, R.id.navigation_cart))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        
    }
}