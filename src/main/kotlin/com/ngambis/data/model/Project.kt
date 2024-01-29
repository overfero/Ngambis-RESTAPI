package com.ngambis.data.model

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Project(
    @BsonId
    var _id: ObjectId = ObjectId(),
    val title: String,
    val categoryName: String,
    val experience: String,
    val subCategoryName: String,
    val currency: String,
    val budget: Double,
    val location: String,
    val freelancerPreferredFrom: String,
    val type: String,
    val datePosted: String,
    val description: String,
    val duration: String,
    val clientRegistrationDate: String,
    val clientCity: String,
    val clientCountry: String,
    val clientCurrency: String,
    val clientJobTitle: String
)
