package mgareta.thesilverscreen.ui.main.listeners

import android.view.View
import android.widget.AdapterView

class SpinnerListener : AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        println("Item selected: ${parent?.adapter?.getItem(position)}")
    }
}