package br.com.raphaelfleury.ageapp.utils

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import br.com.raphaelfleury.ageapp.R
import br.com.raphaelfleury.ageapp.models.game.Player
import br.com.raphaelfleury.ageapp.ui.theme.LossPlayer
import br.com.raphaelfleury.ageapp.ui.theme.WinPlayer

@DrawableRes
fun getCivIcon(civilization: String): Int {
    return when(civilization) {
        "byzantines" -> {
            R.drawable.ic_byzantines
        } else -> {
            R.drawable.ic_ottomans
        }
    }
}

fun getPlayerResultColor(player: Player): Color {
    return when(player.result) {
        "win" -> {
            WinPlayer
        } else -> {
            LossPlayer
        }
    }
}


val samplePlayer = Player(
    civilization = "byzantines",
    civilization_randomized = false,
    mmr = 100,
    mmr_diff = 50,
    name = "Anibal",
    profile_id = 111,
    rating = 222,
    rating_diff = 444,
    result = "win"
)

val samplePlayer2 = Player(
    civilization = "byzantines",
    civilization_randomized = false,
    mmr = 100,
    mmr_diff = 50,
    name = "Almicar Bacar",
    profile_id = 111,
    rating = 222,
    rating_diff = 444,
    result = "win"
)