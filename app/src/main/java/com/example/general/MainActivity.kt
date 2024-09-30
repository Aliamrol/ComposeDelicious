@file:OptIn(ExperimentalMotionApi::class)

package com.example.general

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.motion.widget.MotionLayout
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.general.screens.AppBarCollapseHeight
import com.example.general.screens.AppBarExpandedHeight
import com.example.general.screens.CookingScreen
import com.example.general.screens.CustomThemeManager
import com.google.accompanist.insets.LocalWindowInsets
import kotlinx.coroutines.launch
import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Punched
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Surface(color = Color.White) {
                CookingScreen()
            }

    }
}


@Composable
fun InstagramLogoCanvas() {
    val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(
            brush = Brush.linearGradient(colors = instaColors.asReversed()),
            cornerRadius = CornerRadius(60f, 60f),
            style = Stroke(width = 15f, cap = StrokeCap.Round),

            )
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors.asReversed()),
            radius = 45f,
            style = Stroke(width = 15f, cap = StrokeCap.Round),
            center = Offset(this.size.width * 0.50f, this.size.height * 0.50f)
        )

        drawCircle(
            brush = Brush.linearGradient(colors = instaColors.asReversed()),
            radius = 12f,
            center = Offset(this.size.width * 0.80f, this.size.height * 0.20f)
        )
    }
}


@Composable
fun CanvasDraw() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawLine(
            color = Color.Red,
            Offset(0f, 0f),
            Offset(200f, 200f),
            strokeWidth = 5f
        )
        drawArc(
            Color.Green,
            0f,
            90f,
            useCenter = true,
            size = Size(300f, 300f),
            topLeft = Offset(400f, 50f)
        )
        drawCircle(
            Color.Blue,
            center = Offset(200f, 200f),
            radius = 60f
        )
    }
}


@Composable
fun ScrollableContent() {
    LazyColumn(
        modifier = Modifier.padding(top = 8.dp)
    ) {
        items(25) {
            WalletItem(
                name = "Bitcoin$it", modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                    .clickable(
                        onClick = {
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


@Composable
fun MotionLayoutView(progress: Float, scrollableBody: @Composable () -> Unit) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier.fillMaxWidth()
    ) {
        val properties = motionProperties(id = "title_txt")
        Image(
            painter = painterResource(id = R.drawable.btc),
            contentDescription = "",
            modifier = Modifier.layoutId("my_image")
        )
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "",
            modifier = Modifier.layoutId("back_icon")
        )
        Text(
            text = "Ali Amrol",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = properties.value.color("text_color"),
            modifier = Modifier.layoutId("title_txt")
        )
        Icon(
            imageVector = Icons.Filled.Share,
            contentDescription = "",
            tint = properties.value.color("text_color"),
            modifier = Modifier.layoutId("share_icon")
        )

        Box(modifier = Modifier.layoutId("content")) {
            scrollableBody()
        }

    }
}

// example of animations
@Composable
fun AnimateColor() {
    var isNeedColorChange by remember {
        mutableStateOf(false)
    }
    val startColor = Color.Red
    val endColor = Color.Blue
    val backGroundColor by animateColorAsState(
        targetValue = if (isNeedColorChange) endColor else startColor, animationSpec = tween(
            durationMillis = 5000, delayMillis = 100
        )
    )
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .background(backGroundColor)
        )
        Button(onClick = { isNeedColorChange = !isNeedColorChange }) {
            Text("change Color")
        }

    }
}

// example of animations
@Composable
fun RotateAnimation() {
    var isRotate by remember {
        mutableStateOf(false)
    }
    val rotateAngle by animateFloatAsState(
        targetValue = if (isRotate) 360f else 0f, animationSpec = tween(
            durationMillis = 3000,
        ), label = ""
    )
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.btc),
            contentDescription = "",
            modifier = Modifier
                .rotate(rotateAngle)
                .size(150.dp)
        )
        Button(onClick = {
            isRotate = !isRotate
        }) {
            Text("Rotate")
        }
    }
}

// example of animations
@Composable
fun InfiniteAnimation() {
    val infiniteTransition = rememberInfiniteTransition()
    val size by infiniteTransition.animateFloat(
        initialValue = 100f, targetValue = 150f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800, delayMillis = 100),
            repeatMode = RepeatMode.Reverse
        )
    )
    Image(
        painter = painterResource(id = R.drawable.btc),
        contentDescription = "",
        modifier = Modifier.size(size.dp)
    )
}

// example of animations
@Composable
fun AnimateDp() {
    var sizeState by remember {
        mutableStateOf(50.dp)
    }
    val size by animateDpAsState(
        targetValue = sizeState, tween(durationMillis = 3000, delayMillis = 1)
    )
    Column {
        Image(
            painter = painterResource(id = R.drawable.btc),
            contentDescription = "",
            modifier = Modifier.size(size)
        )
        Row {
            Button(onClick = {
                sizeState += 50.dp
            }) {
                Text("Increase size")
            }
            Button(onClick = {
                sizeState -= 50.dp
            }) {
                Text("Deacrese size")
            }
        }
    }
}


// Lottie in jetpack compose
@Composable
fun Loader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    LottieAnimation(
        composition, iterations = LottieConstants.IterateForever
    )

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
                CircleImageView(painter = painterResource(id = R.drawable.btc), size = 32.dp)
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(0.475f)
            ) {
                Text(
                    name,
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    "BTC/USD", modifier = Modifier.padding(bottom = 8.dp), color = Color.Gray
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, end = 20.dp)
                    .weight(0.475f),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    "BTC 1000",
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
                Text(
                    "$60200",
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff299c0d)
                )
            }
        }
    }
}

@Composable
fun ScaffoldView() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(scaffoldState = scaffoldState, topBar = {
        TopAppBarView()
    }, bottomBar = {
        BottomAppBarView()
    }, floatingActionButtonPosition = FabPosition.Center, floatingActionButton = {
        FloatingActionButton(
            onClick = {
                scope.launch { scaffoldState.snackbarHostState }
            },
        ) {
            Text("HI")
        }
    }, drawerContent = {
        Text("Drawer Content")
    }, content = { innerPadding ->
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding), // Apply the padding provided by Scaffold
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text("Content")
            }
        }
    })
}

//AppBar
@Composable
fun TopAppBarView() {
    Column {
        TopAppBar(
            title = {
                Text("Small Top App Bar")
            },
            backgroundColor = CustomThemeManager.colors.buttonBackgroundColor,
            actions = { // actions in the right of screen
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Share, null)
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Menu, null)
                }
            },
            navigationIcon = {
                IconButton(onClick = {
                    openDialogState.value = true
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                }
            },
        )
    }
}

// BottomAppBar with BottomNavigationItem
@Composable
fun BottomAppBarView() {
    BottomAppBar(
        backgroundColor = CustomThemeManager.colors.buttonBackgroundColor,
    ) {
        // BottomNavigationItem
        BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, label = {
            Text("Home")
        }, icon = {
            Icon(Icons.Filled.Home, contentDescription = "")
        })
        BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, label = {
            Text("Setting")
        }, icon = {
            Icon(Icons.Filled.Settings, contentDescription = "")
        })

        BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, label = {
            Text("Back")
        }, icon = {
            Icon(Icons.Filled.ArrowBack, contentDescription = "")
        })

        BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, label = {
            Text("Menu")
        }, icon = {
            Icon(Icons.Filled.Menu, contentDescription = "")
        })
    }
}

// Slider
@Composable
fun SliderView() {
    var sliderPosition by remember {
        mutableFloatStateOf(0f)
    }
    Slider(value = sliderPosition, onValueChange = {
        println(it)
        sliderPosition = it
    })
    Text((sliderPosition * 100).roundToInt().toString())
}

// Switch
@Composable
fun SwitchView() {
    var checkState by remember {
        mutableStateOf(false)
    }
    Switch(checked = checkState, onCheckedChange = {
        checkState = it
    })
}

// RadioButtons
@Composable
fun RadioButtonView() {
    val radioOption = listOf("A", "B", "C", "D")
    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(radioOption[2])
    }
    Row() {
        radioOption.forEach { option ->
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .selectable( //برای selectable کردن کل فرزندها استفاده میشود
                        selected = (option == selectedOption), onClick = {
                            onOptionSelected(option)
                        })
            ) {
                RadioButton(selected = (option == selectedOption), onClick = {
                    onOptionSelected(option)
                })
                Text(option, modifier = Modifier.padding(start = 10.dp))

            }
        }
    }
}

val openDialogState = mutableStateOf(false) // access with other composable functions

@SuppressLint("RememberReturnType")
@Composable
fun ExitAlertDialog() {
    MaterialTheme { // هر چیزی که بنویسیم تم material رو میگیره
        var openDialog by remember {
            openDialogState
        }
        if (openDialog) {
            AlertDialog(onDismissRequest = {
                openDialogState.value = false
            }, title = {
                Text(text = "Title")
            }, text = {
                Text("This is a simple alert dialog. Do you want to proceed?")
            }, confirmButton = {
                TextButton(onClick = {
                    openDialogState.value = false
                    println("Confirm")
                }) {
                    Text("Confirm")
                }
            }, dismissButton = {
                TextButton(onClick = {
                    openDialog = false
                }) {
                    Text("Cancel")
                }
            })
        }

    }
}

// TextField
@Composable
fun myEditText(): TextFieldValue {
    var textState by remember {
        mutableStateOf(TextFieldValue("Ali Amrol")) // Ali Amrol -> Default value
    }
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        OutlinedTextField(
            modifier = Modifier.padding(bottom = 20.dp), value = textState, onValueChange = {
                textState = it
            }, textStyle = TextStyle(
                color = Color.Blue,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            "Your Text is : ${textState.text}",
            fontSize = 20.sp,
            modifier = Modifier
                .border(width = 4.dp, color = Color.Blue, shape = RectangleShape)
                .padding(10.dp)
        )
    }
    return textState
}

// CheckBox
@Composable
fun CheckBoxView() {
    var checkState by remember {
        mutableStateOf(true)
    }
    Checkbox(
        checked = checkState,
        onCheckedChange = {
            checkState = !checkState
        },
    )
}

@Composable
fun CircleImageView(painter: Painter, size: Dp) {
    Image(
        painter = painter,
        contentDescription = "",
        modifier = Modifier
            .clip(CircleShape)
            .size(size)
            .fillMaxSize()
    )
}

@Composable
fun ShapeGenerator(shape: Shape, color: Color, width: Dp, height: Dp, modifier: Modifier) {
    Column(modifier) {
        Box(
            modifier = Modifier
                .clip(shape)
                .size(width, height)
                .background(color)
        )
    }
}

@Composable
fun BoxCard(title: String, price: String, image: Painter) {
    Card(
        modifier = Modifier.padding(8.dp), elevation = 10.dp, shape = RoundedCornerShape(20.dp)
    ) {
        // Box
        // چیدن آیتم ها روی همدیگه
        Box(
            modifier = Modifier
                .height(180.dp)
                .width(150.dp)
        ) {
            Image(
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent, Color.Gray
                            )
                        )
                    )
            )
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier.padding(bottom = 10.dp, start = 100.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun CardView(title: String, price: String, image: Painter) {
    Card(
        modifier = Modifier.fillMaxWidth(0.5f), shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(4.dp)
        ) {
            Image(
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = price, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Red
                )

            }
        }
    }
}

@Composable
fun FoodItem(title: String, description: String, image: Painter, price: String) {
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = image,
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
            Text(
                text = "$price$",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Magenta,
                modifier = Modifier.padding(8.dp)
            )
        }
        Text(
            text = description,
            fontSize = 28.sp,
            modifier = Modifier.padding(top = 4.dp, start = 8.dp, bottom = 32.dp)
        )
    }
}}

