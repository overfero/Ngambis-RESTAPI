package com.ngambis.plugins

import com.ngambis.routes.projectRoute
import com.ngambis.routes.userRoute
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        userRoute()
        projectRoute()
        get("/") {
            call.respondText("Hello World!")
        }
    }

}
