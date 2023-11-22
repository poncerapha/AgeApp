package br.com.raphaelfleury.ageapp.models

data class Rm1v1(
    val _notice_: String,
    val civilizations: List<Any>,
    val games_count: Int,
    val losses_count: Int,
    val previous_seasons: List<PreviousSeason>,
    val rank_level: String,
    val season: Int,
    val streak: Int,
    val wins_count: Int
)