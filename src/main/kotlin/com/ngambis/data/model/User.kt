package com.ngambis.data.model

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class User(
    @BsonId
    var _id: ObjectId = ObjectId(),
    val userId: Int,
    val age: String,
    val employment: String,
    val remoteWork: String,
    val education: String,
    val experience: Int,
    val developer: String,
    val country: String,
    val programming: String,
    val database: String,
    val industry: String
)
