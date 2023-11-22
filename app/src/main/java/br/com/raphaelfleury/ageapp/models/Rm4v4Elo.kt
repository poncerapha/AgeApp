package br.com.raphaelfleury.ageapp.models

data class Rm4v4Elo(
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
    val rating_history: RatingHistoryXXXXX,
    val streak: Int,
    val win_rate: Double,
    val wins_count: Int
)