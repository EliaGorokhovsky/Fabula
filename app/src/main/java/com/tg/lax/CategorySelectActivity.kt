package com.tg.lax

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.InputType
import android.text.SpannableStringBuilder
import android.view.Gravity
import android.widget.*
import com.tg.lax.logic.helpers.CategoryAdapter
import com.tg.lax.logic.questions.Category
import com.tg.lax.logic.questions.QuestionSet
import com.tg.lax.logic.questions.QuestionType
import com.tg.lax.logic.questions.allCategories
import kotlinx.android.synthetic.main.activity_category_select.*

class CategorySelectActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_select)
        gridview.adapter = CategoryAdapter((allCategories + Category(arrayOf(), "", R.drawable.add_button)).toMutableList(), this)
        gridview.setOnItemClickListener { adapterView, view, i, l ->
            this.openCategoryDialog(adapterView.adapter as CategoryAdapter, i)
        }
        gridview.setPadding(25, 25, 25, 25)
    }

    /**
     * Opens a dialog to edit the category
     */
    private fun openCategoryDialog(adapter: CategoryAdapter, index: Int) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle(adapter.categories[index].name)
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        val nameEditField = EditText(this)
        nameEditField.hint = "category name"
        nameEditField.text = SpannableStringBuilder(if (adapter.categories[index].name == "Create New Category") "New Category${adapter.categories.count { it.name.contains("New Category") } - 1}" else adapter.categories[index].name)
        nameEditField.gravity = Gravity.CENTER
        layout.addView(nameEditField)
        val editFields = mutableListOf<EditText>()
        for (category in 1 until QuestionType.values().size + 1) {
            //Question type
            val type = QuestionType.values()[category - 1]

            val editLayout = LinearLayout(this)
            editLayout.orientation = LinearLayout.HORIZONTAL

            val edit = EditText(this)
            edit.inputType = InputType.TYPE_CLASS_NUMBER
            edit.width = 100
            edit.text = SpannableStringBuilder(adapter.categories[index].weights[type].toString())
            editFields.add(edit)
            editLayout.addView(edit)

            val text = TextView(this)
            text.text = type.description
            text.textSize = 20f
            editLayout.addView(text)

            layout.addView(editLayout)
        }

        dialog.setNegativeButton("Close") { _, _ -> }
        dialog.setNeutralButton("Save") { _, _ ->
            if (index != adapter.categories.size - 1) {
                editFields.forEach { if (it.text.toString() == "") it.text = SpannableStringBuilder("0") }
                adapter.categories[index].weights = (1 until QuestionType.values().size + 1).map {
                    adapter.categories[index].weights.keys.toMutableList()[it - 1] to editFields[it - 1].text.toString().toInt()
                }.toMap().toMutableMap()
                allCategories.first { it == adapter.categories[index] }.name = nameEditField.text.toString()
            } else {
                val newCategory = Category(QuestionType.values(), nameEditField.text.toString())
                newCategory.weights = (1 until QuestionType.values().size + 1).map {
                    adapter.categories[index].weights.keys.toMutableList()[it - 1] to editFields[it - 1].text.toString().toInt()
                }.toMap().toMutableMap()
                allCategories.add(newCategory)
            }
            adapter.categories = (allCategories + Category(arrayOf(), "")).toMutableList()
            this.finish()
            this.overridePendingTransition(0, 0)
            startActivity(this.intent)
            this.overridePendingTransition(0, 0)
        }
        dialog.setPositiveButton("Start New Set") { _, _ ->
            if (index != adapter.categories.size - 1) {
                editFields.forEach { if (it.text.toString() == "") it.text = SpannableStringBuilder("0") }
                adapter.categories[index].weights = (1 until QuestionType.values().size + 1).map {
                    adapter.categories[index].weights.keys.toMutableList()[it - 1] to editFields[it - 1].text.toString().toInt()
                }.toMap().toMutableMap()
                allCategories.first { it == adapter.categories[index] }.name = nameEditField.text.toString()
            } else {
                val newCategory = Category(QuestionType.values(), nameEditField.text.toString())
                newCategory.weights = (1 until QuestionType.values().size + 1).map {
                    adapter.categories[index].weights.keys.toMutableList()[it - 1] to editFields[it - 1].text.toString().toInt()
                }.toMap().toMutableMap()
                allCategories.add(newCategory)
            }
            adapter.categories = (allCategories + Category(arrayOf(), "")).toMutableList()
            if (adapter.categories[index].weights.values.sum() == 0) {
                Toast.makeText(this, "Please indicate which question types you would like.", Toast.LENGTH_SHORT).show()
            } else {
                this.openSetDialog(adapter.categories[index])
            }
        }

        val scrollView = ScrollView(this)
        scrollView.addView(layout)
        dialog.setView(scrollView)
        dialog.show()
    }

    /**
     * Opens a dialog to play a new set
     */
    @SuppressLint("SetTextI18n")
    private fun openSetDialog(category: Category) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("New Set of ${category.name} Questions (Max ${category.options.size})")
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.HORIZONTAL
        val textView = TextView(this)
        textView.text = "Set Size: "
        textView.textSize = 20f
        val editText = EditText(this)
        editText.inputType = InputType.TYPE_CLASS_NUMBER
        editText.text = SpannableStringBuilder("1")
        layout.addView(textView)
        layout.addView(editText)
        layout.gravity = Gravity.CENTER
        dialog.setView(layout)
        dialog.setNegativeButton("Cancel") { _, _ -> }
        dialog.setPositiveButton("Start") { _, _ ->
            if (editText.text.toString().toInt() > category.options.size) {
                Toast.makeText(this, "Please select fewer questions...", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(
                        Intent(this, QuestionDisplayActivity::class.java)
                                .putExtra("questionSet", QuestionSet(category, editText.text.toString().toInt()))
                )
            }
        }
        dialog.show()
    }

    override fun onBackPressed() {
        startActivity(
                Intent(this, MainActivity::class.java)
        )
        super.onBackPressed()
    }

}
