package com.example.unitconvertorpractice

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
import com.example.unitconvertorpractice.ui.theme.UnitConvertorPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConvertorPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                 unitConvertor()
                    temp()
                }
            }
        }
    }
}

@Composable
fun temp(){
    var count by remember {
        mutableStateOf(0)
    }
    var direction by remember {
        mutableStateOf("East")
    }
    Column {
        Text("count ${count}")
        Text("direction ${direction}")
        Button(onClick = {
            count +=1;
            direction = "north"
        }

        ) {

        }
    }

}


@Composable
fun unitConvertor(){
    var inputValue by remember { mutableStateOf("")}
    var outputValue by remember { mutableStateOf(0.0) }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    var inputUnit by remember { mutableStateOf("meters")}
    var outputUnit by remember { mutableStateOf("meters") }

    fun conversion(){
        val input = inputValue.toDoubleOrNull()?:0.0;
        if(inputUnit =="meters" && outputUnit == "centimeters") outputValue = input*100;
        else if(inputUnit =="centimeters" && outputUnit == "meters") outputValue = input/100;
        else  outputValue = input;
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Text("Unit Convertor")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange ={
            inputValue = it
        } , label = {Text("Enter Value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
         Box {
             val context = LocalContext.current;
             Button(onClick = {
                 iExpanded = true
             }){
                 Text(inputUnit)
                 Icon(Icons.Default.ArrowDropDown, contentDescription = "" )
             }
             DropdownMenu(expanded = iExpanded, onDismissRequest = {
                 iExpanded = false
             }) {
                 DropdownMenuItem(text = { Text("meter")}, onClick = {
                     iExpanded = false
                     inputUnit ="meters"
                     conversion()
                 })
                 DropdownMenuItem(text = { Text("centimeter")}, onClick = {
                     iExpanded = false
                     inputUnit ="centimeters"
                     conversion()
                 })
             }
         }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                val context = LocalContext.current;
                Button(onClick = {
                    oExpanded = true
                }){
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "" )
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = {
                    oExpanded = false
                }) {
                    DropdownMenuItem(text = { Text("meter")}, onClick = {
                        oExpanded = false
                        outputUnit = "meters"
                        conversion()
                    })
                    DropdownMenuItem(text = { Text("centimeter")}, onClick = {
                        oExpanded = false
                        outputUnit = "centimeters"
                        conversion()
                    })
                }
            }
       }
        Text("Result: $outputValue $outputUnit" )
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
    UnitConvertorPracticeTheme {
//        unitConvertor()
    }
}