package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.5f)
                .background(Color.Red)
        ){
           Row {
               Box(
                   modifier = Modifier
                       .background(Color(0xFFEADDFF))
                       .fillMaxHeight(1f)
                       .fillMaxWidth(0.5f),
               ) {
                  Column(
                      modifier = Modifier.fillMaxSize().padding(16.dp),
                      verticalArrangement = Arrangement.Center,
                      horizontalAlignment = Alignment.CenterHorizontally
                  ){
                      Text("Text composable",
                          modifier = Modifier.padding(0.dp,0.dp,0.dp,16.dp),
                          fontWeight = FontWeight.Bold
                      )
                      Text("Displays text and follows the recommended Material Design guidelines."
                          )
                  }
               }
               Box(
                   modifier = Modifier
                       .background(Color(0xFFD0BCFF))
                       .fillMaxHeight(1f)
                       .fillMaxWidth(1f),
               ) {
                 Column(
                     modifier = Modifier.fillMaxSize().padding(16.dp),
                     verticalArrangement = Arrangement.Center,
                     horizontalAlignment = Alignment.CenterHorizontally
                 ){
                     Text("Text composable",
                         modifier = Modifier.padding(0.dp,0.dp,0.dp,16.dp),
                         fontWeight = FontWeight.Bold)
                     Text("Creates a composable that lays out and draws a given Painter class object.",
                        )
                 }

               }
           }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(1f)
                .background(Color.Red)
        ){
            Row {
                Box(
                    modifier = Modifier
                        .background(Color(0xFFB69DF8))
                        .fillMaxHeight(1f)
                        .fillMaxWidth(0.5f),
                ) {
                   Column(
                       modifier = Modifier.fillMaxSize().padding(16.dp),
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally
                   ){
                       Text("Text composable",
                           modifier = Modifier.padding(0.dp,0.dp,0.dp,16.dp),
                           fontWeight = FontWeight.Bold)
                       Text("A layout composable that places its children in a horizontal sequence.",

                           )
                   }
                }
                Box(
                    modifier = Modifier
                        .background(Color(0xFFF6EDFF))
                        .fillMaxHeight(1f)
                        .fillMaxWidth(1f),
                ) {
                   Column (
                       modifier = Modifier.fillMaxSize().padding(16.dp),
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally
                   ){
                       Text("Text composable",
                           modifier = Modifier.padding(0.dp,0.dp,0.dp,16.dp),
                           fontWeight = FontWeight.Bold
                           )
                       Text("A layout composable that places its children in a vertical sequence.",
                         )
                   }

                }
            }
        }



    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Greeting("Android")
    }
}