package com.ngambis.routes

import com.ngambis.data.*
import com.ngambis.data.model.Project
import com.ngambis.data.model.User
import com.ngambis.data.requests.DeleteProjectRequest
import com.ngambis.data.requests.DeleteUserRequest
import com.ngambis.data.requests.ProjectRequest
import com.ngambis.data.requests.UserRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.bson.types.ObjectId

fun Route.userRoute(){
    route("/get-user"){
        get {
            val userId = call.receive<UserRequest>().id
            val user = getUserById(ObjectId(userId))
            user?.let {
                call.respond(
                    HttpStatusCode.OK,
                    it
                )
            } ?: call.respond(
                HttpStatusCode.OK,
                "Tidak ada user dengan id tersebut $userId"
            )
        }
    }

    route("/create-update-user") {
        post {
            val request = try {
                call.receive<User>()
            } catch (e: ContentTransformationException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            if (createOrUpdateUserById(request)){
                call.respond(
                    HttpStatusCode.OK,
                    "Sukses menambahkan atau mengupdate user"
                )
            } else {
                call.respond(
                    HttpStatusCode.Conflict
                )
            }
        }
    }

    route("/delete-user") {
        post {
            val request = try {
                call.receive<DeleteUserRequest>()
            } catch (e: ContentTransformationException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            if (deleteUserById(ObjectId(request.id))){
                call.respond(
                    HttpStatusCode.OK,
                    "Sukses menghapus user"
                )
            } else {
                call.respond(
                    HttpStatusCode.OK,
                    "Tidak ada user dengan id tersebut"
                )
            }
        }
    }
}

fun Route.projectRoute(){
    route("/get-project"){
        get {
            val projectId = call.receive<ProjectRequest>().id
            val project = getProjectById(ObjectId(projectId))
            project?.let {
                call.respond(
                    HttpStatusCode.OK,
                    it
                )
            } ?: call.respond(
                HttpStatusCode.OK,
                "Tidak ada projek dengan id tersebut"
            )
        }
    }

    route("/create-update-project") {
        post {
            val request = try {
                call.receive<Project>()
            } catch (e: ContentTransformationException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            if (createOrUpdateProjectById(request)){
                call.respond(
                    HttpStatusCode.OK,
                    "Sukses menambahkan atau mengupdate project"
                )
            } else {
                call.respond(
                    HttpStatusCode.Conflict
                )
            }
        }
    }

    route("/delete-project") {
        post {
            val request = try {
                call.receive<DeleteProjectRequest>()
            } catch (e: ContentTransformationException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            if (deleteProjectById(ObjectId(request.id))){
                call.respond(
                    HttpStatusCode.OK,
                    "Sukses menghapus projek"
                )
            } else {
                call.respond(
                    HttpStatusCode.OK,
                    "Tidak ada projek dengan id tersebut"
                )
            }
        }
    }
}