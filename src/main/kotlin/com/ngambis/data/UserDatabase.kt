package com.ngambis.data

import com.google.gson.Gson
import com.ngambis.data.model.Project
import com.ngambis.data.model.User
import com.mongodb.ConnectionString
import com.ngambis.data.model.DeveloperRecommendations
import org.bson.types.ObjectId
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.eq
import org.litote.kmongo.reactivestreams.KMongo
import java.lang.reflect.Field


private val client = KMongo.createClient(ConnectionString("mongodb://localhost:27017")).coroutine
private val userDatabase = client.getDatabase("UserDatabase")
private val projectDatabase = client.getDatabase("ProjectDatabase")

private val users = userDatabase.getCollection<User>()
private val projects = projectDatabase.getCollection<Project>()

suspend fun getUserById(id: ObjectId): User? {
    return users.findOneById(id)
}

suspend fun getProjectById(id: ObjectId): Project? {
    return projects.findOneById(id)
}

suspend fun createOrUpdateUserById(user: User): Boolean {
    val userExist = users.findOneById(user._id) != null
    return if (userExist) {
        users.updateOneById(user._id, user).wasAcknowledged()
    } else {
        user._id = ObjectId()
        users.insertOne(user).wasAcknowledged()
    }
}

suspend fun createOrUpdateProjectById(project: Project): Boolean {
    val projectExist = projects.findOneById(project._id) != null
    return if (projectExist) {
        projects.updateOneById(project._id, project).wasAcknowledged()
    } else {
        project._id = ObjectId()
        projects.insertOne(project).wasAcknowledged()
    }
}

suspend fun deleteUserById(id: ObjectId): Boolean {
    val user = users.findOne(User::_id eq id)
    user?.let {
        return users.deleteOneById(user._id).wasAcknowledged()
    } ?: return false
}

suspend fun deleteProjectById(id: ObjectId): Boolean {
    val project = projects.findOne(Project::_id eq id)
    project?.let {
        return projects.deleteOneById(project._id).wasAcknowledged()
    } ?: return false
}