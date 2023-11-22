package br.com.raphaelfleury.ageapp.models

data class Qm3v3(
    val disputes_count: Int,
    val drops_count: Int,
    val games_count: Int,
    val last_game_at: String,
    val losses_count: Int,
    val max_rating: Int,
    val max_rating_1m: Int,
    val max_rating_7d: Int,
    val rank: Int,
    val rank_level: Any,
    val rating: Int,
    val rating_history: RatingHistoryX,
    val streak: Int,
    val win_rate: Double,
    val wins_count: Int
)