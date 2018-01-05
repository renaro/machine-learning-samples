package com.renaro.machinelearningsamples

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.renaro.machinelearningsamples.model.Element
import com.renaro.machinelearningsamples.model.Kernel
import com.renaro.machinelearningsamples.view.KmeanView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), KmeanView.BoardInterface {

    lateinit var board: KmeanView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        board = findViewById<KmeanView>(R.id.canvas)
        board.listener = this
        button.setOnClickListener({ v ->
            board.onRunClicked()
        })
        reset.setOnClickListener({
            board.resetBoard()
        })
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
