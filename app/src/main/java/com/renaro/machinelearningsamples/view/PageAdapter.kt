package com.renaro.machinelearningsamples.view

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.renaro.machinelearningsamples.KMeansFragment
import com.renaro.machinelearningsamples.LinearRegressionFragment

/**
 * Created by renarosantos1 on 10/01/18.
 */
class PageAdapter(fm: FragmentManager, context: Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return KMeansFragment()
            else -> return LinearRegressionFragment()
        }
    }

    override fun getCount(): Int = 2


}