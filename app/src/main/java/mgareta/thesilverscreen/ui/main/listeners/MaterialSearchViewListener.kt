package mgareta.thesilverscreen.ui.main.listeners

import com.miguelcatalan.materialsearchview.MaterialSearchView

class MaterialSearchViewListener : MaterialSearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(query: String?): Boolean {
        println("Query submitted: $query")

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        println("Query changed: $newText")

        return true
    }
}