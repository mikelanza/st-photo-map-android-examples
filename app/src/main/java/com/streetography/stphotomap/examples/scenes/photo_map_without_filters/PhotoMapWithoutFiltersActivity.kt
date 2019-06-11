package com.streetography.stphotomap.examples.scenes.photo_map_without_filters

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.streetography.stphotomap.examples.R
import com.streetography.stphotomap.scenes.stphotomap.STPhotoMapView

class PhotoMapWithoutFiltersActivity: AppCompatActivity() {
    private var photoMapView: STPhotoMapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setupContentView()
        this.findSubviews()
        this.setupSubviews()
    }

    //region Subviews configuration
    private fun setupContentView() {
        this.setContentView(R.layout.activity_photo_map_without_filters)
    }

    private fun findSubviews() {
        this.photoMapView = this.findViewById(R.id.photoMapView)
    }

    private fun setupSubviews() {
        this.setupBackButton()
        this.setupPhotoMap()
    }

    private fun setupBackButton() {
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupPhotoMap() {

    }
    //endregion

    override fun onSupportNavigateUp(): Boolean {
        this.onBackPressed()
        return super.onSupportNavigateUp()
    }
}