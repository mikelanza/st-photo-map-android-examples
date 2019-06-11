package com.streetography.stphotomap.examples.scenes.main

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.streetography.stphotomap.examples.R
import com.streetography.stphotomap.examples.extensions.router.ActivityRouter
import com.streetography.stphotomap.examples.scenes.photo_map_without_filters.PhotoMapWithoutFiltersActivity

class MainActivity: AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var recyclerViewAdapter: MainActivityExampleAdapter? = null

    private var examples: ArrayList<MainActivityModels.Example> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setupExamples()
        this.setupContentView()
        this.findSubviews()
        this.setupSubviews()
    }

    private fun setupExamples() {
        this.examples.add(MainActivityModels.Example(MainActivityModels.ExampleType.PhotoMapWithoutFilters))
        this.examples.add(MainActivityModels.Example(MainActivityModels.ExampleType.PhotoMapWithUserFilter))
        this.examples.add(MainActivityModels.Example(MainActivityModels.ExampleType.PhotoMapWithCollectionFilter))
    }

    //region Subviews configuration
    private fun setupContentView() {
        this.setContentView(R.layout.activity_main)
    }

    private fun findSubviews() {
        this.recyclerView = this.findViewById(R.id.recyclerView)
    }

    private fun setupSubviews() {
        this.setupRecyclerViewAdapter()
        this.setupRecyclerView()
    }

    private fun setupRecyclerViewAdapter() {
        this.recyclerViewAdapter = MainActivityExampleAdapter(this.examples, exampleListener = { example ->
            this.onExampleListener(example)
        })
    }

    private fun setupRecyclerView() {
        this.recyclerView?.adapter = this.recyclerViewAdapter
        this.recyclerView?.layoutManager = LinearLayoutManager(this)
        this.recyclerView?.setHasFixedSize(true)
        this.recyclerView?.setBackgroundColor(Color.WHITE)
    }
    //endregion

    private fun onExampleListener(example: MainActivityModels.Example) {
        when (example.type) {
            MainActivityModels.ExampleType.PhotoMapWithoutFilters -> ActivityRouter.start<PhotoMapWithoutFiltersActivity>(this)
            MainActivityModels.ExampleType.PhotoMapWithUserFilter -> Toast.makeText(this, "2: " + example.type.title, Toast.LENGTH_SHORT).show()
            MainActivityModels.ExampleType.PhotoMapWithCollectionFilter -> Toast.makeText(this, "3: " + example.type.title, Toast.LENGTH_SHORT).show()
        }
    }
}