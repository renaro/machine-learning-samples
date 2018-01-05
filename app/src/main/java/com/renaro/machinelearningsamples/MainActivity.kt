package com.renaro.machinelearningsamples

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.renaro.machinelearningsamples.model.Element
import com.renaro.machinelearningsamples.model.Kernel
import com.renaro.machinelearningsamples.view.KmeanView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), KmeanView.OnClicked {

    lateinit var board: KmeanView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        board = findViewById<KmeanView>(R.id.canvas)
        board.listener = this
        button.setOnClickListener({v -> val isPossibleToProceed = board.onRunClicked()
            if (!isPossibleToProceed) {
                Snackbar.make(layout_container, "Number of Elements should be greater than Kernels", Snackbar.LENGTH_SHORT).show()
            }
        })
    }

    override fun onClick(posX: Float, posY: Float) {
        if (elementsRadio.isChecked) {
            board.addElement(Element(posX, posY))
        } else {
            val kernelAdded = board.addKernel(Kernel(posX, posY))
            if (!kernelAdded) {
                Snackbar.make(layout_container, "Max Kernel number is 5", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

}
