package repository

import models.Repo

class RepoRepositoryMock : RepoRepository {

    private var repoMock = listOf<Repo>(Repo("SBCBD", "Engenharia de Software"), Repo("Kworkflow", "KW"))

    override suspend fun getRepos(): List<Repo> = repoMock
    override suspend fun addRepo(title: String, org: String): Repo {
        val newRepo = Repo(title, org)
        repoMock + newRepo
        return newRepo
    }
}