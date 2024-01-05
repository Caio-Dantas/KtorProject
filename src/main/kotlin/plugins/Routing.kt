package plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import routes.listRepos
import routes.searchRepo

fun Application.configureRouting() {
    routing {
        listRepos()
        searchRepo()
    }
}