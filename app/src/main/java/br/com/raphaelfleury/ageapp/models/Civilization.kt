package br.com.raphaelfleury.ageapp.models

data class Civilization(
    val civilization: String,
    val game_length: GameLength,
    val games_count: Int,
    val pick_rate: Double,
    val win_rate: Double
)