package com.example.countervm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

//Model
class CounterViewModel: ViewModel(){
   private var _count = mutableStateOf(0);//mutable varible which no body can change the value on UI

    //variable which will only access on UI
   var count :MutableState<Int> = _count;

    fun increment(){
       _count.value++;
    }
    fun decrement(){
       _count.value--;
    }

}