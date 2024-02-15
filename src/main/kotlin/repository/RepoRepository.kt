package repository

import models.Repo

interface RepoRepository {
    suspend fun getRepos(): List<Repo>
    suspend fun addRepo(title: String, org: String): Repo?
}