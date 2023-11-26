package br.com.raphaelfleury.ageapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.raphaelfleury.ageapp.models.game.Game
import br.com.raphaelfleury.ageapp.models.game.Games
import br.com.raphaelfleury.ageapp.models.game.Player
import br.com.raphaelfleury.ageapp.ui.theme.AgeAppTheme
import br.com.raphaelfleury.ageapp.ui.theme.GreyText
import br.com.raphaelfleury.ageapp.ui.theme.MapIconStroke
import br.com.raphaelfleury.ageapp.ui.theme.MatchCardBackground
import br.com.raphaelfleury.ageapp.ui.theme.WhiteText
import br.com.raphaelfleury.ageapp.util.Resource
import br.com.raphaelfleury.ageapp.utils.getCivIcon
import br.com.raphaelfleury.ageapp.utils.getPlayerResultColor
import br.com.raphaelfleury.ageapp.utils.samplePlayer
import br.com.raphaelfleury.ageapp.utils.samplePlayer2
import br.com.raphaelfleury.ageapp.viewmodel.AgeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: AgeViewModel = hiltViewModel()
                    val ageInfo = produceState<Resource<Games>>(initialValue = Resource.Loading()) {
                        value = viewModel.getAgeInfo("4875917")
                    }.value
                    Log.i("onCreate", "onCreate: ${ageInfo.data}")
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ageInfo.data?.let { games ->
                            LazyColumn(
                                Modifier
                                    .fillMaxSize(),
                                contentPadding = PaddingValues(16.dp),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(games.games) { game ->
                                    MatchCard(game)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun MatchCard(game: Game) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f, label = ""
    )
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .clickable {
                expandedState = !expandedState
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MatchCardBackground)
        ) {
            MatchTopDetails(game)

            IconButton(
                modifier = Modifier
                    .size(30.dp)
                    .rotate(rotationState)
                    .align(Alignment.CenterHorizontally),
                onClick = {
                    expandedState = !expandedState
                }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Drop-Down Arrow"
                )
            }
            if (expandedState) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    Column {
                        game.teams.first().forEach { team ->
                            PlayerInfo2(player = team.player)
                        }
                    }
                    Text(
                        text = "VS",
                        color = WhiteText,
                        modifier = Modifier.align(CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        game.teams[1].forEach { team ->
                            PlayerInfo2(player = team.player)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MatchTopDetails(game: Game) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_golden_heights),
            contentDescription = "map Icon",
            modifier = Modifier
                .size(80.dp)
                .padding(8.dp)
                .border(
                    width = 2.dp,
                    color = MapIconStroke,
                    shape = RoundedCornerShape(4.dp)
                )
        )
        Column(
            modifier = Modifier
                .padding(PaddingValues(vertical = 16.dp))
        ) {
            Text(
                text = game.map,
                color = WhiteText
            )
            Text(
                text = game.kind,
                color = GreyText
            )

        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .padding(PaddingValues(vertical = 16.dp))
        ) {
            Text(
                text = game.started_at,
                color = WhiteText
            )
        }
    }
}

@Composable
private fun PlayerInfo(player: Player) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .padding(PaddingValues(start = 8.dp))
    ) {
        Image(
            painter = painterResource(id = getCivIcon(player.civilization)),
            contentDescription = "map Icon",
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = player.name,
            color = getPlayerResultColor(player),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight(500)
        )
        Text(
            text = player.rating.toString(),
            color = GreyText,
            fontSize = 10.sp,
            textAlign = TextAlign.End,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
private fun PlayerInfo2(player: Player) {
    Box(
        contentAlignment = Alignment.CenterEnd
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(PaddingValues(end = 8.dp))
        ) {
            Text(
                text = player.rating.toString(),
                color = GreyText,
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = player.name,
                color = getPlayerResultColor(player),
                fontWeight = FontWeight(500)
            )
            Image(
                painter = painterResource(id = getCivIcon(player.civilization)),
                contentDescription = "map Icon",
                modifier = Modifier.size(20.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MatchPlayersDetailsPreview() {
    Column {
        PlayerInfo(player = samplePlayer)
        PlayerInfo(player = samplePlayer2)
    }
}

