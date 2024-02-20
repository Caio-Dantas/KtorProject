package routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import models.Repo
import repository.RepoRepository

fun Route.repos(repository: RepoRepository) {
    get("repos") {
        val repos = repository.getRepos()
        call.respond(repos)
    }

    get("repos/{name?}") {
        val name = call.parameters["name"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        val repos = repository.getRepos()
        call.respond(repos.filter { repo -> repo.title.contains(name) })
    }

    post(path = "repos") {
        /** Implementação utilizando deserialization (JSON -> Object)
        val repo = call.receive<Repo>()
        repository.addRepo(repo.title, repo.org)
        call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
         */

        val formParameters = call.receiveParameters()
        val title = formParameters.getOrFail("title")
        val org = formParameters.getOrFail("org")
        repository.addRepo(title, org)
        call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
    }
}