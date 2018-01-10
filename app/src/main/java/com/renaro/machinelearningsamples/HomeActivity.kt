package com.renaro.machinelearningsamples

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.renaro.machinelearningsamples.view.PageAdapter

/**
 * Created by renarosantos1 on 10/01/18.
 */
class HomeActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: PageAdapter? = null

    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        mSectionsPagerAdapter = PageAdapter(supportFragmentManager, this)

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById<ViewPager?>(R.id.container)
        mViewPager!!.adapter = mSectionsPagerAdapter

        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)
        tabLayout.getTabAt(0)?.text = "K-mean"
        tabLayout.getTabAt(1)?.text = "Linear Reg."

    }
}