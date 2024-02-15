package repository

import dao.DatabaseSingleton.dbQuery
import models.Repo
import models.Repos
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class RepoRepositoryDatabase: RepoRepository {

    override suspend fun getRepos(): List<Repo> = dbQuery {
        Repos.selectAll().map(::resultRowToRepo)
    }

    override suspend fun addRepo(title: String, org: String): Repo? = dbQuery {
        val insertedStatement = Repos.insert {
            it[Repos.title] = title
            it[Repos.org] = org
        }
        insertedStatement.resultedValues?.singleOrNull()?.let(::resultRowToRepo)
    }

    private fun resultRowToRepo(row: ResultRow) = Repo(
        title = row[Repos.title],
        org = row[Repos.org]
    )
}