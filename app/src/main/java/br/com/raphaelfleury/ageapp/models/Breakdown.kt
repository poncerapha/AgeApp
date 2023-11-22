package br.com.raphaelfleury.ageapp.models

data class Breakdown(
    val duration_range: String,
    val games_count: Int,
    val win_rate: Double,
    val wins_count: Int
)