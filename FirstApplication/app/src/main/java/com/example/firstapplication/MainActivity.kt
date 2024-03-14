package com.example.firstapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapplication.ui.theme.FirstApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstApplicationTheme {
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
    var inputValue by remember { mutableStateOf("")}
    var outputValue by remember { mutableStateOf(0.0)}
    var inputUnit by remember { mutableStateOf("meter")}
    var outputUnit by remember { mutableStateOf("meter")}
    var iExpanded by remember { mutableStateOf(false)}
    var oExpanded by remember { mutableStateOf(false)}

    fun conversion(){
     var value = inputValue.toDoubleOrNull()?:0.0
      if (inputUnit=="meter" && outputUnit=="centimeter") {
          outputValue = value*100;
      }else if(inputUnit =="centimeter" && outputUnit=="meter"){
          outputValue = value/100;
      }else{
          outputValue = value;
      }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit convertor")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange ={
            inputValue = it
        } , label = { Text("Enter Value")})
        Spacer(modifier = Modifier.height(16.dp))

        var context = LocalContext.current
        Row {
         Box {
             Button(onClick = {
               iExpanded = true
             }) {
                 Text(inputUnit)
                 Icon(Icons.Default.ArrowDropDown,contentDescription = "drop down menu" )
             }
             DropdownMenu(expanded =iExpanded, onDismissRequest = {
                 iExpanded = false
             }) {
                 DropdownMenuItem(text = { Text("meter") }, onClick = {
                     inputUnit = "meter"
                     conversion()
                     iExpanded = false
                 })
                 DropdownMenuItem(text = { Text("centimeters") }, onClick = {
                     inputUnit = "centimeter"
                     conversion()
                     iExpanded = false
                 })
             }
         }

            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = {
                    oExpanded = true;
                }) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown,contentDescription = "drop down menu" )
                }
                DropdownMenu(expanded =oExpanded, onDismissRequest = {
                    oExpanded = false
                }) {
                    DropdownMenuItem(text = { Text("meter") }, onClick = {
                        outputUnit = "meter"
                        conversion()
                        oExpanded = false
                    })
                    DropdownMenuItem(text = { Text("centimeters") }, onClick = {
                        outputUnit = "centimeter"
                        conversion()
                        oExpanded = false

                    })
                }
            }
        }
        Text("Result $outputValue $outputUnit")
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
fun unitConvertorPreview(){
//    unitConvertor();
}
