package plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import models.Repo

fun Application.configureRouting() {
    routing {
        get("customer/{id?}") {
            val id = call.parameters["id"]
            call.respond("Olá $id")
        }
        get("repos") {
            val repos = listOf<Repo>(Repo("SBCBD", "Engenharia de Software"), Repo("Kworkflow", "KW"))
            call.respond(repos)
        }
    }
}