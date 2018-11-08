package mgareta.thesilverscreen

import android.content.res.TypedArray
import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import kotlinx.android.synthetic.main.main_activity.*
import mgareta.thesilverscreen.ui.main.MainFragment
import mgareta.thesilverscreen.ui.main.listeners.MaterialSearchViewListener
import com.nightonke.boommenu.BoomButtons.HamButton
import com.nightonke.boommenu.Util
import mgareta.thesilverscreen.ui.main.listeners.EndPointChooseListener

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_materialsearchview, menu)

        materialSearchView_toolbar.setMenuItem(menu?.findItem(R.id.action_materialSearchView))

        return true
    }

    override fun onResume() {
        super.onResume()

        configEndPointChooser()
        materialSearchView_toolbar.setOnQueryTextListener(MaterialSearchViewListener())
    }

    override fun onPause() {
        boomMenuButton_toolbar.clearBuilders()
        materialSearchView_toolbar.setOnQueryTextListener(null)

        super.onPause()
    }

    private fun configEndPointChooser() {
        val endPointsIcons: TypedArray = resources.obtainTypedArray(R.array.toolbar_endPointEntriesIcons)
        val endPointsTitleEntries = resources.getStringArray(R.array.toolbar_endPointEntriesTitle)
        val endPointsSubtitleEntries = resources.getStringArray(R.array.toolbar_endPointEntriesSubtitle)

        for (i in 0 until boomMenuButton_toolbar.piecePlaceEnum.pieceNumber()) {
            val builder = HamButton.Builder()
                .normalColorRes(R.color.colorAccent)
                .highlightedColor(R.color.ripple_material_light)
                .normalImageDrawable(endPointsIcons.getDrawable(i))
                .normalText(endPointsTitleEntries[i])
                .subNormalText(endPointsSubtitleEntries[i])
                .imagePadding(Rect(Util.dp2px(15f),0,Util.dp2px(5f),0))
                .rotateImage(false)
                .listener(EndPointChooseListener())
            boomMenuButton_toolbar.addBuilder(builder)
        }

        endPointsIcons.recycle()

        textView_boomMenuButton.text = endPointsTitleEntries[0].toString()
    }
}
