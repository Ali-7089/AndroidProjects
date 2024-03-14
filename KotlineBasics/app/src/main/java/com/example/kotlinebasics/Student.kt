package com.example.kotlinebasics

class Student(val name:String , val age:Int=0) {
    init {
        greet(name);
    }
    fun greet(name :String){
       print("good morning $name");
    }
}