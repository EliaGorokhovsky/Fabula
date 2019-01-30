package com.tg.lax.logic.helpers

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
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
        //Enforce squareness
        val textView = object : TextView(this.context) {
            override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
                super.onMeasure(widthMeasureSpec, widthMeasureSpec)
            }
        }
        textView.text = this.categories[p0].name
        textView.setTextColor(ColorStateList.valueOf(Color.BLACK))
        textView.gravity = Gravity.CENTER
        textView.textSize = 20f
        textView.typeface = Typeface.DEFAULT_BOLD
        textView.setBackgroundResource(this.categories[p0].imageRef)
        if (p0 != this.categories.size - 1) textView.background.alpha = 70
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