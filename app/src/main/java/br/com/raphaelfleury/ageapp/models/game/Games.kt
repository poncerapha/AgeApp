package br.com.raphaelfleury.ageapp.models.game

data class Games(
    val count: Int,
    val filters: Filters,
    val games: List<Game>,
    val offset: Int,
    val page: Int,
    val per_page: Int
)