package com.renaro.machinelearningsamples

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.renaro.machinelearningsamples.model.Element
import com.renaro.machinelearningsamples.view.LinearRegressionView

/**
 * Created by renarosantos1 on 10/01/18.
 */
class LinearRegressionFragment : SamplesFragment(), LinearRegressionView.OnViewClicked {
    lateinit var board : LinearRegressionView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.linearreg_fragment, null)
        board = view.findViewById(R.id.canvas)
        board.listener = this
        return view
    }

    override fun onClick(posX: Float, posY: Float) {
        board.addElement(Element(posX, posY))
    }

    override fun onResetClicked() {
        board.resetBoard()
    }

    override fun onRunClicked() {
        board.runClicked()
    }
}