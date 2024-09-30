package com.example.general

import com.example.general.MainActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.general.databinding.ActivityMapBinding
import org.osmdroid.config.Configuration.getInstance
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.views.MapView

class MapActivity : ComponentActivity() {
    private lateinit var binding: ActivityMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        val view = binding.root

//        getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))

        setContentView(view)

//        binding.map.setTileSource(TileSourceFactory.MAPNIK)

        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Column {
                    WalletItem(
                        name = "Bitcoin",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                            .clickable(
                                onClick = {
                                    Toast
                                        .makeText(context, "Clicked!", Toast.LENGTH_LONG)
                                        .show()
                                },
                                interactionSource = remember {
                                    MutableInteractionSource()
                                },
                                indication = rememberRipple(
                                    bounded = true,
                                    color = Color.Blue
                                )
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun WalletItem(name: String, modifier: Modifier) {
    Card(
        modifier = modifier, elevation = 8.dp, shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            // can use modifier.weight() -> چند درصد از ستون رو تشکیل بده
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(0.15f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                CircleImageView(painter = painterResource(id = R.drawable.btc), size = 32.dp)
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(0.475f)
            ) {
                androidx.compose.material.Text(
                    name,
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                androidx.compose.material.Text(
                    "BTC/USD", modifier = Modifier.padding(bottom = 8.dp), color = Color.Gray
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, end = 20.dp)
                    .weight(0.475f),
                horizontalAlignment = Alignment.End
            ) {
                androidx.compose.material.Text(
                    "BTC 1000",
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
                androidx.compose.material.Text(
                    "$60200",
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff299c0d)
                )
            }
        }
    }
}