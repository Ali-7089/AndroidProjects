package com.example.recipeapppractice

data class Category(
    var idCategory:String,
    var strCategory : String,
    var strCategoryThumb: String,
    var strCategoryDescription: String
){
}

data class categoriesResponse(var categories: List<Category> )