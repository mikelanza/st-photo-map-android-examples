package com.streetography.stphotomap.examples.scenes.main

class MainActivityModels {
    enum class ExampleType(val title: String) {
        PhotoMapWithoutFilters("Photo Map Without Filters"),
        PhotoMapWithUserFilter("Photo Map With User Filter"),
        PhotoMapWithCollectionFilter("Photo Map With Collection Filter")
    }

    class Example(val type: ExampleType) {
    }
}