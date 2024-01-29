package com.ngambis.data.model

import com.google.gson.annotations.SerializedName

data class DeveloperRecommendations(
    @SerializedName("Back End") val backEnd: List<String>,
    @SerializedName("Front End") val frontEnd: List<String>,
    @SerializedName("Full Stack") val fullStack: List<String>,
    @SerializedName("Sys Admin") val sysAdmin: List<String>,
    @SerializedName("Desktop Developer") val desktopDeveloper: List<String>,
    @SerializedName("QA Engineer") val qaEngineer: List<String>,
    @SerializedName("Designer") val designer: List<String>,
    @SerializedName("Data Science and Machine Learning") val dataScienceAndML: List<String>,
    @SerializedName("Data Analyst") val dataAnalyst: List<String>,
    @SerializedName("Mobile Developer") val mobileDeveloper: List<String>,
    @SerializedName("Database Admin") val databaseAdmin: List<String>,
    @SerializedName("Data Engineer") val dataEngineer: List<String>,
    @SerializedName("Software Engineer") val softwareEngineer: List<String>,
    @SerializedName("Game Development") val gameDevelopment: List<String>,
    @SerializedName("Cloud Engineer") val cloudEngineer: List<String>,
    @SerializedName("DevOps") val devOps: List<String>
)
