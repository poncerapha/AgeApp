package br.com.raphaelfleury.ageapp.models

data class RmSolo(
    val civilizations: List<Any>,
    val games_count: Int,
    val losses_count: Int,
    val previous_seasons: List<PreviousSeason>,
    val rank_level: String,
    val season: Int,
    val streak: Int,
    val wins_count: Int
)