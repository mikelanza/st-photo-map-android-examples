package com.streetography.stphotomap.examples.scenes.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.streetography.stphotomap.examples.R
import com.streetography.stphotomap.examples.extensions.view.group.inflate
import kotlinx.android.synthetic.main.main_example_item_row.view.*

class MainActivityExampleAdapter(private val examples: ArrayList<MainActivityModels.Example>, private val exampleListener: (MainActivityModels.Example) -> Unit): RecyclerView.Adapter<MainActivityExampleAdapter.ExampleViewHolder>() {
    class ExampleViewHolder(val view: View, val viewListener: (MainActivityModels.Example) -> Unit): RecyclerView.ViewHolder(view) {
        fun bindExample(example: MainActivityModels.Example) {
            this.view.textView.text = example.type.title
            this.view.setOnClickListener { this.viewListener(example) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val inflatedView = parent.inflate(R.layout.main_example_item_row, false)
        return ExampleViewHolder(inflatedView, viewListener = this.exampleListener)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val example = this.examples[position]
        holder.bindExample(example)
    }

    override fun getItemCount() = this.examples.size
}