package com.android.composelisting

import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.composelisting.ui.theme.ComposeListingTheme

class MainActivity : ComponentActivity() {

    val itemsIndexedList = listOf("Afghanistan", "Albania","Algeria","Andorra",
        "Argentina",
        "Australia",
        "Bangladesh",
        "Brazil",
        "Croatia",
        "Denmark",
         "Egypt",
          "France",
        "Germany",
        "Iceland","India","Pakistan","Poland","Qatar","Russia")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state= rememberLazyListState()
            Column{

                TopAppBar(
                    title = { Text(text = "Compose Listing") },
                    /*navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.ArrowBack, "")
                        }
                    }*/
                )
                LazyColumn (state = state, verticalArrangement = Arrangement.SpaceEvenly){
                    itemsIndexed(itemsIndexedList) { index, item ->
                        Row ( modifier = Modifier.height(50.dp)
                            .padding(
                                start = 16.dp,
                                top = 0.dp,
                                end = 16.dp,
                                bottom = 0.dp)


                            .clickable {
                                Toast
                                    .makeText(
                                        this@MainActivity,
                                        "You Clicked " + item,
                                        Toast.LENGTH_LONG
                                    )
                                    .show()
                            }

                        ){

                            Text(item,Modifier.align(alignment = Alignment.CenterVertically))
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth().align(alignment = Alignment.CenterVertically),
                                painter = painterResource(R.drawable.arrow),
                                contentDescription = "Default person",
                                alignment = Alignment.TopEnd
                            )
                        }
                        Divider(color = Color.Black, thickness = 0.5.dp)

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeListingTheme {
        Greeting("Android")
    }
}