package br.com.raphaelfleury.ageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.raphaelfleury.ageapp.ui.theme.AgeAppTheme
import br.com.raphaelfleury.ageapp.ui.theme.GreyText
import br.com.raphaelfleury.ageapp.ui.theme.MapIconStroke
import br.com.raphaelfleury.ageapp.ui.theme.MatchCardBackground
import br.com.raphaelfleury.ageapp.ui.theme.WhiteText
import br.com.raphaelfleury.ageapp.ui.theme.WinPlayer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgeAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    val viewModel: AgeViewModel = hiltViewModel()
//                    val ageInfo = produceState<Resource<AgeResponse>>(initialValue = Resource.Loading()) {
//                        value = viewModel.getAgeInfo("76561197995328378")
//                    }.value
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = "Partidas Recentes")
                        MatchCard()
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MatchCard() {
    Box {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MatchCardBackground)
            ) {
                MatchTopDetails()
                MatchPlayersDetails()
            }
        }
    }
}

@Composable
fun MatchTopDetails() {
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
                text = "Golden Heights",
                color = WhiteText
            )
            Text(
                text = "RM 2v2 39m",
                color = GreyText
            )

        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .padding(PaddingValues(vertical = 16.dp))
        ) {
            Text(
                text = "about 2 hours ago",
                color = WhiteText
            )
        }
    }
}

@Composable
fun MatchPlayersDetails() {
    Column{
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_ottomans),
                contentDescription = "map Icon",
                modifier = Modifier.scale(0.7f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Aníbal",
                color = WinPlayer,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(500)
            )
        }

        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_byzantines),
                contentDescription = "map Icon",
                modifier = Modifier.scale(0.7f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Amilcar Barca",
                color = WinPlayer,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(500)
            )
        }
    }
}