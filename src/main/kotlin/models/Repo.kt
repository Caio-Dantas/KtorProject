package models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Repo(val title: String, val org: String)

object Repos: Table() {
    val id = integer("id").autoIncrement()
    val title = varchar("title", 128)
    val org = varchar("org",128)

    override val primaryKey = PrimaryKey(id)
}
