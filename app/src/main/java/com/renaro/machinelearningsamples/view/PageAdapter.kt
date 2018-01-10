package com.renaro.machinelearningsamples.view

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.renaro.machinelearningsamples.KMeansFragment

/**
 * Created by renarosantos1 on 10/01/18.
 */
class PageAdapter(fm: FragmentManager, context: Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return KMeansFragment()
            else -> return KMeansFragment()
        }
    }

    override fun getCount(): Int = 2


}