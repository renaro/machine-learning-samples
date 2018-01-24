package com.renaro.machinelearningsamples

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.renaro.machinelearningsamples.model.Element
import com.renaro.machinelearningsamples.model.Kernel
import com.renaro.machinelearningsamples.view.KmeanView
import kotlinx.android.synthetic.main.kmeans_fragment.*

class KMeansFragment : SamplesFragment(), KmeanView.UserInterface {

    lateinit var board: KmeanView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.kmeans_fragment, null)
        board = view.findViewById(R.id.canvas)
        board.listener = this
        return view
    }

    override fun onRunClicked() {
        board.onRunClicked()
    }

    override fun onResetClicked() {
        board.resetBoard()
    }



    override fun onClick(posX: Float, posY: Float) {
        if (elementsRadio.isChecked) {
            board.addElement(Element(posX, posY))
        } else {
            board.addKernel(Kernel(posX, posY))
        }
    }

    override fun onError(message: String) {
        Snackbar.make(layout_container, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun hasConverged() {
        Snackbar.make(layout_container, "Has converged", Snackbar.LENGTH_SHORT).show()
    }

    override fun nextStepIteration(iteration: Int) {
        if (iteration == 0) {
            button.text = "Run"
        } else {
            button.text = "Step"
        }
    }


}
