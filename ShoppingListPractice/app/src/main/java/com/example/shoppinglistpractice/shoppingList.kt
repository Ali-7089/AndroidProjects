package com.example.shoppinglistpractice

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class ShoppingItem(
    val id: Int,
    var name: String,
    var quantity: Int,
    val isEditing: Boolean = false
) {}

@Composable
fun shoppingItems() {
    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var isVisibledailog by remember { mutableStateOf(false) }
    var nameValue by remember { mutableStateOf("") }
    var quantityValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = { isVisibledailog = true },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Add items")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(sItems) {
                item ->
                if(item.isEditing){
                 editTheShoppinfItem(item = item, editComplete ={
                    editedName , editedQuantity ->
                        sItems = sItems.map { it.copy(isEditing = false)}
                        val editedItem = sItems.find { item.id==it.id }
                        editedItem?.let {
                            it.name = editedName
                            it.quantity = editedQuantity
                        }
                 })
                }else{
                 renderItem(item = item, editClick = {
                     sItems = sItems.map { it.copy(isEditing = it.id==item.id)}
                 },
                     deleteClick = {
                        sItems = sItems - item
                     } )
                }
            }
        }

        if (isVisibledailog) {
            AlertDialog(onDismissRequest = { isVisibledailog = false },
                confirmButton = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(onClick = {
                            if (nameValue.isNotBlank()) {
                                val item = ShoppingItem(
                                    sItems.size + 1,
                                    nameValue, quantityValue.toInt()
                                )
                                sItems = sItems + item
                                isVisibledailog = false
                                nameValue = ""
                                quantityValue = ""
                            }

                        }) {
                            Text("Add")

                        }
                        Button(onClick = { isVisibledailog = false }) {
                            Text("Text")
                        }
                    }
                },
                title = { Text("Add shopping Item") },
                text = {
                    Column {
                        OutlinedTextField(value = nameValue, onValueChange = { nameValue = it },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            label = { Text("Enter the item name") }
                        )
                        OutlinedTextField(value = quantityValue,
                            onValueChange = { quantityValue = it },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            label = { Text("Enter the quantity") }
                        )
                    }
                }

            )
        }
    }
}

@Composable
fun editTheShoppinfItem(item:ShoppingItem, editComplete:(String , Int)->Unit){
    var editedName by remember { mutableStateOf(item.name)}
    var editedQuantity by remember { mutableStateOf(item.quantity.toString())}
    var isEdited by remember { mutableStateOf(item.isEditing)}

   
     Column(
         modifier = Modifier
             .fillMaxWidth()
             .padding(10.dp),
         horizontalAlignment = Alignment.CenterHorizontally
     ){
     OutlinedTextField(
         value = editedName,
         onValueChange = { editedName = it },
         singleLine = true,
         modifier = Modifier
             .wrapContentSize()
             .padding(8.dp)
         )
         OutlinedTextField(
             value = editedName,
             onValueChange = { editedName = it },
             singleLine = true,
             modifier = Modifier
                 .wrapContentSize()
                 .padding(8.dp)
         )

         Button(onClick = {
             isEdited = false
             editComplete(editedName , editedQuantity.toIntOrNull()?:1)
         }) {
             Text("save")
         }
     }
}




@Composable
fun renderItem(item : ShoppingItem , editClick:()->Unit,deleteClick:()->Unit){
    Column(
        modifier= Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(
                border = BorderStroke(2.dp, Color.DarkGray),
                shape = RoundedCornerShape(10.dp)
            )
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ){
          Text(item.id.toString())
          Text(item.name)
          Row(
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(10.dp),
              horizontalArrangement = Arrangement.SpaceBetween
          ){
              Button(onClick = { editClick }) {
                  Icon(Icons.Default.Edit, contentDescription = null)
              }
              Button(onClick = { deleteClick }) {
                  Icon(Icons.Default.Delete, contentDescription = null)
              }
          }
        }
    }
}