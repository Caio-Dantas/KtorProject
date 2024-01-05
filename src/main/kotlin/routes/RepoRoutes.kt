package routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import models.Repo

fun Route.listRepos() {
    get("repos") {
        val repos = listOf<Repo>(Repo("SBCBD", "Engenharia de Software"), Repo("Kworkflow", "KW"))
        call.respond(repos)
    }
}

fun Route.searchRepo() {
    get("repos/{name?}") {
        val name = call.parameters["name"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        val repos = listOf<Repo>(Repo("SBCBD", "Engenharia de Software"), Repo("Kworkflow", "KW"))
        call.respond(repos.filter { repo -> repo.title.contains(name) })
    }
}