package com.tg.lax.logic.helpers

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.tg.lax.logic.questions.Category

/**
 * Adapts allCategories into a set of items displayable by GridView
 */
class CategoryAdapter(var categories: MutableList<Category>, val context: Context): BaseAdapter() {

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val textView = TextView(this.context)
        textView.text = this.categories[p0].name
        return textView
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return this.categories.size
    }

}