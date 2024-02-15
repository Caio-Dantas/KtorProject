import dao.DatabaseSingleton
import io.ktor.server.application.*
import plugins.configureRouting
import plugins.configureSerialization
import repository.RepoRepositoryDatabase
import repository.RepoRepositoryMock

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {

    val repository = RepoRepositoryDatabase()

    DatabaseSingleton.init()
    configureRouting(repository)
    configureSerialization()
}