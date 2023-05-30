package com.example.book_flight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.book_flight.databinding.ActivityHomeBinding
import com.example.book_flight.fragments.HomeFragment
import com.example.book_flight.fragments.ProfileFragment
import com.example.book_flight.fragments.TicketFragment


class Home_activity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val ticketFragment = TicketFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home ->makeCurrentFragment(homeFragment)
                R.id.ic_profile ->makeCurrentFragment(profileFragment)
                R.id.ic_ticket ->makeCurrentFragment(ticketFragment)

            }
            true
        }

    }//oncreate


    fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }
    }


}//class