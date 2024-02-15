package plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import repository.RepoRepository
import routes.repos

fun Application.configureRouting(repository: RepoRepository) {
    routing {
        repos(repository)
    }
}