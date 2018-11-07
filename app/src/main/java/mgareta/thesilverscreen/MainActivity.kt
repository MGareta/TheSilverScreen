package mgareta.thesilverscreen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*
import mgareta.thesilverscreen.ui.main.MainFragment
import mgareta.thesilverscreen.ui.main.listeners.SpinnerListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setSupportActionBar(toolbar_main)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun onResume() {
        super.onResume()

        spinner_toolbar.onItemSelectedListener = SpinnerListener()
    }

    override fun onPause() {
        spinner_toolbar.onItemSelectedListener = null

        super.onPause()
    }
}
