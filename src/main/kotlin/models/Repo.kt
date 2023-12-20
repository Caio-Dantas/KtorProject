package models

import kotlinx.serialization.Serializable

@Serializable
data class Repo(val title: String, val org: String)
