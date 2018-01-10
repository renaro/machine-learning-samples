package com.renaro.machinelearningsamples

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by renarosantos1 on 10/01/18.
 *
 */
abstract class SamplesFragment : Fragment() {

    override fun onResume() {
        super.onResume()
        view?.findViewById<View>(R.id.button)?.setOnClickListener({ v ->
            onRunClicked()
        })
        view?.findViewById<View>(R.id.reset)?.setOnClickListener({
            onResetClicked()
        })
    }
    abstract fun onRunClicked()
    abstract fun onResetClicked()


}