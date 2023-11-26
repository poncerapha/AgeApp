package br.com.raphaelfleury.ageapp.models.game

data class Filters(
    val leaderboard: List<String>,
    val order: String,
    val profile_ids: List<String>,
    val since: Any
)