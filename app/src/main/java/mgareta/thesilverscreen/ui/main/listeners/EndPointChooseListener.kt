package mgareta.thesilverscreen.ui.main.listeners

import com.nightonke.boommenu.BoomButtons.OnBMClickListener

class EndPointChooseListener : OnBMClickListener {
    override fun onBoomButtonClick(index: Int) {
        println("Item clicked: $index")
    }
}