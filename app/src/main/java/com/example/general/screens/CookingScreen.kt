package com.example.general.screens

import androidx.annotation.DrawableRes
import com.example.general.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.LocalWindowInsets
import kotlin.math.max
import kotlin.math.min

val AppBarCollapseHeight = 56.dp
val AppBarExpandedHeight = 400.dp

@Composable
fun CookingScreen() {

    val scrollState = rememberLazyListState()
    Box {
        Content(scrollState = scrollState)
        ParallaxToolbar(scrollState)

    }
}


@Composable
fun Content(scrollState: LazyListState) {
    LazyColumn(
        contentPadding = PaddingValues(top = AppBarExpandedHeight),
        state = scrollState,

        ) {
        item {
            BasicInfo()
            Description()
            ServingCalculator()
            ShoppingListButton()
            SimilarFoodHeader()
            SimilarFoods()
            SimilarRecipeHeader()
            SimilarRecipes()
        }
    }
}

@Composable
fun SimilarRecipes() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        RecipeItem(
            name = "Cheesecake",
            category = "Dessert",
            exp = "Beginner",
            image = painterResource(id = R.drawable.cheesecake_foreground),
            baseColor = Color(0xFFcbe8e0),
            expColor = Color(0xFF8cd694)
        )
        RecipeItem(
            name = "Cupcake",
            category = "Dessert",
            exp = "Beginner",
            image = painterResource(id = R.drawable.cake_foreground),
            baseColor = Color(0xFFcbe8e0),
            expColor = Color(0xFF8cd694)
        )
        RecipeItem(
            name = "Ice cream",
            category = "Dessert",
            exp = "Intermediate",
            image = painterResource(id = R.drawable.icecream_foreground),
            baseColor = Color(0xFFcbe8e0),
            expColor = Color(0xFFFF8C00)
        )
        RecipeItem(
            name = "Soft Drink",
            category = "Drink",
            exp = "Hard",
            image = painterResource(id = R.drawable.softdrink_foreground),
            baseColor = Color(0xFFcbe8e0),
            expColor = Color(0xFFFF0000)
        )
    }
}

@Composable
fun RecipeItem(
    name: String, category: String, exp: String, image: Painter, baseColor: Color, expColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(0.3f)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
                    .clip(CircleShape)
                    .background(baseColor),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = image,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(0.6f)
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            Text(
                text = name,
                modifier = Modifier.weight(0.33f),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = category,
                modifier = Modifier.weight(0.33f),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )

            Row(
                modifier = Modifier
                    .weight(0.33f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(20))
                        .background(expColor)
                ) {
                }
                Text(
                    text = exp,
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(0.1f)
                .fillMaxHeight()
                .padding(top = 16.dp)
        ) {
            Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "")
        }
    }
}


@Composable
fun SimilarRecipeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Column {
            Text(text = "Similar Recipes", fontWeight = FontWeight.Bold)
            Text(text = "You can also read these...", color = DarkGray)
        }
        Button(
            onClick = { /*TODO*/ }, elevation = null, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent, contentColor = Pink
            )
        ) {
            Text(text = "Show more!")
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = ""
            )
        }
    }
}


@Composable
fun SimilarFoods() {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        FastFoodItem(
            image = painterResource(id = R.drawable.ic_pizza),
            name = "Pizza",
            description = "FastFood",
            price = "200$"
        )
        FastFoodItem(
            image = painterResource(id = R.drawable.doughnut_foreground),
            name = "Doughnut",
            description = "Dessert",
            price = "40$"
        )
        FastFoodItem(
            image = painterResource(id = R.drawable.hamburger_foreground),
            name = "Hamburger",
            description = "FastFood",
            price = "120$"
        )
        FastFoodItem(
            image = painterResource(id = R.drawable.ic_pizza),
            name = "Pizza",
            description = "FastFood",
            price = "200$"
        )
    }
}

@Composable
fun FastFoodItem(
    image: Painter, name: String, description: String, price: String
) {
    Box(
        modifier = Modifier
            .width(170.dp)
            .height(250.dp)
            .padding(8.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .clip(RoundedCornerShape(16.dp))
                .background(LightGray)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 75.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    fontWeight = FontWeight.Bold, fontSize = 16.sp, text = name
                )

                Text(
                    color = Color.Gray, modifier = Modifier.padding(top = 5.dp), text = description
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = price,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                        color = Pink
                    )

                    Button(
                        onClick = { },
                        contentPadding = PaddingValues(),
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .fillMaxHeight()
                            .width(38.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Pink, contentColor = Color.White
                        )
                    ) {
                        Icon(painterResource(id = R.drawable.ic_plus), contentDescription = "")
                    }
                }
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = image,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
            )
        }
    }
}


@Composable
fun SimilarFoodHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Column {
            Text(text = "Similar Foods", fontWeight = FontWeight.Bold)
            Text(text = "You may Like these...", color = DarkGray)
        }
        Button(
            onClick = { /*TODO*/ }, elevation = null, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent, contentColor = Pink
            )
        ) {
            Text(text = "Show more!")
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = ""
            )
        }
    }
}


@Composable
fun ShoppingListButton() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Button(
            onClick = { /*TODO*/ },
            elevation = null,
            shape = Shapes.small,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Pink, contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "Add to shopping List", modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ServingCalculator() {
    var value by remember {
        mutableIntStateOf(6)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(Shapes.small)
            .background(LightGray)
            .padding(horizontal = 16.dp)
    ) {
        Text("Serving", modifier = Modifier.weight(1f), fontWeight = FontWeight.Medium)
        CircularButton(iconRes = R.drawable.ic_minus, elevation = null, color = Pink) {
            value--
        }
        Text("$value", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Medium)
        CircularButton(iconRes = R.drawable.ic_plus, elevation = null, color = Pink) {
            value++
        }
    }
}

@Composable
fun Description() {
    Text(
        "This Desert is very tasty and not very hard to prepare. and please pay attention that you can replace strawberry with any another fruit you like",
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun BasicInfo() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        InfoColumn(iconRes = R.drawable.ic_clock, text = "60 min")
        InfoColumn(iconRes = R.drawable.ic_flame, text = "735 kcal")
        InfoColumn(iconRes = R.drawable.ic_star, text = "4.7")
    }
}

@Composable
fun InfoColumn(@DrawableRes iconRes: Int, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = "",
            tint = Pink,
            modifier = Modifier.height(36.dp)
        )

        Text(text = text, fontWeight = FontWeight.Bold)
    }
}


@Composable
fun ParallaxToolbar(scrollState: LazyListState) {

    val imageHeight = AppBarExpandedHeight - AppBarCollapseHeight

    val maxOffset =
        with(LocalDensity.current) { imageHeight.roundToPx() } - LocalWindowInsets.current.systemBars.layoutInsets.top

    val offset = min(scrollState.firstVisibleItemScrollOffset, maxOffset)

    val offsetProgress = max(0f, offset * 3f - 2f * maxOffset) / maxOffset

    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = Color.White,
        modifier = Modifier
            .height(
                AppBarExpandedHeight
            )
            .offset { IntOffset(x = 0, y = -offset) },
        elevation = if (offset == maxOffset) 4.dp else 0.dp
    ) {
        Column {

            Box(modifier = Modifier
                .height(imageHeight)
                .graphicsLayer {
                    alpha = 1f - offsetProgress
                }) {
                Image(
                    painter = painterResource(id = R.drawable.strawberry_pie),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    Pair(0.4f, Color.Transparent), Pair(1f, Color.White)
                                )
                            )
                        )
                )

                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "Desert",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(LightGray)
                            .padding(vertical = 6.dp, horizontal = 16.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppBarCollapseHeight),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "StrawBerry cake",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = (16 + 28 * offsetProgress).dp)
                        .scale(1f - 0.25f * offsetProgress)
                )
            }

        }

    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(AppBarCollapseHeight)
            .padding(horizontal = 16.dp)
    ) {
        CircularButton(iconRes = R.drawable.ic_arrow_back)
        CircularButton(iconRes = R.drawable.ic_favorite)
    }
}

@Composable
fun CircularButton(
    @DrawableRes iconRes: Int,
    color: Color = Color.Gray,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = color),
        elevation = elevation,
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(painter = painterResource(id = iconRes), contentDescription = "")
    }
}