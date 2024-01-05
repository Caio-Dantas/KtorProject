import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import io.ktor.server.testing.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import models.Repo

class ReposTest {
    @Test
    fun testGetRepos() = testApplication {
        val response = client.get("/repos")
        val reposString: String = response.body()

        val repos = Json.decodeFromString<List<Repo>>(reposString)

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("SBCBD", repos[0].title)
    }
}