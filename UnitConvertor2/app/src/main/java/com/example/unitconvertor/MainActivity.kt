package com.example.unitconvertor

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.unitconvertor.ui.theme.UnitConvertorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConvertorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   unitConvertor()
                }
            }
        }
    }
}

@Composable
fun unitConvertor(){
   Column {
      Text("Unit Convertor")
       val modifier = Modifier.fillMaxSize()

      OutlinedTextField(value = "", onValueChange = {})
       var context = LocalContext.current
       Row{
           Box(){
           Button(onClick = {Toast.makeText(
               context, "Thank you for clicking" ,Toast.LENGTH_LONG
           ).show()}) {
               Text("Click me")
           }
           }
           Box(){
               Button(onClick = {Toast.makeText(
                   context, "Thank you for clicking" ,Toast.LENGTH_LONG
               ).show()}) {
                   Text("Click me")
               }
           }

       }
   }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun unitConvertorPreview() {
   unitConvertor()
}