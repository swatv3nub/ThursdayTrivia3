package com.example.android.thursdaytriviathree

import android.app.StatusBarManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.thursdaytriviathree.data.RestaurantList
import com.example.android.thursdaytriviathree.model.Restaurant
import com.example.android.thursdaytriviathree.ui.theme.ThursdayTriviaThreeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThursdayTriviaThreeTheme {
                // A surface container using the 'background' color from the theme
                val statusBar = rememberSystemUiController()
                statusBar.setStatusBarColor(
                    color = Color(0xFFE9E9E9)
                )
                Surface(modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFE9E9E9)) {
                    RestaurantApp()
                }
            }
        }
    }
}




@Composable
fun RestaurantApp() {
    Column (modifier = Modifier.padding(horizontal = 12.dp)){
        val textState = remember { mutableStateOf(TextFieldValue("")) }
        Spacer(modifier = Modifier.height(10.dp))
        SearchView(textState)
        Spacer(modifier = Modifier.height(20.dp))
        RestaurantList(restaurantList = RestaurantList().getRestaurantList())
    }
}

@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        placeholder = { Text(text = "Restaurant name or a dish") },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp))
            .background(color = Color.Black),
        textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                tint = Color.DarkGray,
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun RestaurantList(restaurantList: List<Restaurant>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(restaurantList) { restaurant ->
            RestaurantCard(restaurant)
        }
    }
}

@Composable
fun RestaurantCard(restaurant: Restaurant, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(vertical = 10.dp), elevation = 4.dp, shape = RoundedCornerShape(15.dp)) {
        Column(modifier = Modifier) {
            Image(painter = painterResource(id = restaurant.image), contentDescription = LocalContext.current.getString(restaurant.restaurantName),
                Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop)
            Row(modifier = Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(3f)) {
                    Text(text = LocalContext.current.getString(restaurant.restaurantName),
                        modifier = Modifier.padding(all = 3.dp),
                        style = MaterialTheme.typography.h6, maxLines = 1)
                    Text(text = LocalContext.current.getString(restaurant.restaurantDetail),
                        modifier = Modifier.padding(horizontal = 5.dp),
                        maxLines = 1)
                }
                Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    RatingBox(restaurant = restaurant)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = LocalContext.current.getString(restaurant.resPrice), style = MaterialTheme.typography.subtitle2)
                }

            }
        }
    }
}

@Composable
fun RatingBox(restaurant: Restaurant){
    Box(modifier = Modifier.background(color = Color(0xFF1FA169), shape = RoundedCornerShape(5.dp))){
        Row(modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)) {
            Text(text = LocalContext.current.getString(restaurant.restaurantRating),
                textAlign = TextAlign.Center, color = Color.White)
            Icon(painter = painterResource(id = R.drawable.ic_baseline_star_24),
                contentDescription = LocalContext.current.getString(restaurant.restaurantName),
                tint = Color.Yellow, modifier = Modifier.align(Alignment.CenterVertically))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThursdayTriviaThreeTheme {
        RestaurantApp()
    }
}