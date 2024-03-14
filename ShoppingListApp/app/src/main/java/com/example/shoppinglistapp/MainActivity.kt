package com.example.shoppinglistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppinglistapp.ui.theme.ShoppingListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListAppTheme {
                // A surface container using the 'background' color from the theme
                var listOfItems by remember { mutableStateOf(listOf<shoppingItem>()) }
                var isVisibleDailoge by remember { mutableStateOf(false) }
                var nameInput by remember { mutableStateOf("") }
                var quantityInput by remember { mutableStateOf("") }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Button(
                            onClick = { isVisibleDailoge = true },
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text("Add Item")
                        }
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            items(listOfItems) {
                               item->
                                 if(item.isEditable==true){
                                     Text("hello")
                                     editShopItem(item = item, editComplete = {
                                       editedName , editedQuantity->
                                 listOfItems = listOfItems.map{ it.copy(isEditable = false) }
                                 var editedItem = listOfItems.find { it.id == item.id }
                                    editedItem?.let {
                                        it.name = editedName
                                        it.quantity = editedQuantity
                                    }
                                     })
                                 }
                                else{

                                    showShoppingItem(
                                        item = item,
                                        editClick = {
                                            listOfItems = listOfItems.map{ it.copy(isEditable = it.id.toString()==item.id.toString()) }
                                        },
                                        deleteClick = {
                                            listOfItems = listOfItems - item
                                        }
                                        )
                                 }

                            }
                        }
                        if (isVisibleDailoge == true) {
                            AlertDialog(onDismissRequest = { isVisibleDailoge = false },
                                confirmButton ={
                                  Row(
                                      modifier = Modifier
                                          .fillMaxWidth()
                                          .padding(16.dp),
                                      horizontalArrangement = Arrangement.SpaceBetween
                                  ) {
                                      Button(onClick = {
                                         var item =  shoppingItem(
                                             id =listOfItems.size +1,
                                             name = nameInput,
                                             quantity = quantityInput.toInt(),
                                         )
                                          listOfItems = listOfItems + item
                                          isVisibleDailoge = false
                                          nameInput = ""
                                          quantityInput = ""
                                      }) {
                                          Text("Add")
                                      }
                                      Button(onClick = {
                                          isVisibleDailoge = false
                                      }) {
                                          Text("Cancel")
                                      }
                                  }
                                },
                                title = { Text("Add items for Shopping") },
                                text = {
                                    Column(
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        OutlinedTextField(value = nameInput,
                                            onValueChange = { nameInput = it },
                                            singleLine = true,
                                            label = { Text("Enter name of item") }
                                        )
                                        Spacer(modifier = Modifier.height(16.dp))
                                        OutlinedTextField(value = quantityInput, onValueChange = {
                                            quantityInput = it
                                        }, singleLine = true,
                                            label = { Text("Enter quantity of item") }
                                        )
                                    }
                                }
                            )

                        }
                    }
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
fun GreetingPreview() {
    ShoppingListAppTheme {
        Greeting("Android")
    }
}

data class shoppingItem(
    val id: Int,
    var name: String,
    var quantity: Int,
    val isEditable: Boolean = false
) {
}
@Composable
fun editShopItem(item: shoppingItem, editComplete:(String, Int)->Unit){
    var editName by remember { mutableStateOf(item.name)};
    var editQuantity:String by remember { mutableStateOf(item.quantity.toString())};
    var isEditing by remember { mutableStateOf(item.isEditable)};
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Edit Item")
        OutlinedTextField(value = editName, onValueChange ={editName = it})
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value =editQuantity , onValueChange ={editQuantity=it})
        Button(onClick = {
            isEditing = false
            editComplete(editName,editQuantity.toIntOrNull()?:1)
        }) {
            Text("save")
        }
    }
}

@Composable
fun showShoppingItem(item: shoppingItem , editClick:()->Unit , deleteClick:()->Unit){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color.Gray),
                shape = RoundedCornerShape(5.dp)
            )
            .padding(20.dp)
    ){
       Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
       ){
           Text(item.id.toString())
           Spacer(modifier = Modifier.width(10.dp))
           Text(item.name)
           Spacer(modifier = Modifier.width(20.dp))
           Text("Qty: ${item.quantity}")

           IconButton(onClick = editClick  ) {
               Icon(Icons.Default.Edit, contentDescription = null)
           }
           IconButton(onClick =  deleteClick ) {
               Icon(Icons.Default.Delete, contentDescription = null)
           }
       }

    }
    Spacer(modifier = Modifier.width(20.dp))
}
