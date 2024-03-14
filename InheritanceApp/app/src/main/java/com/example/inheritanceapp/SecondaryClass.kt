package com.example.inheritanceapp

class SecondaryClass : BaseClass() {
    override fun greet(){
        super.greet();
        println("children")
    }
}