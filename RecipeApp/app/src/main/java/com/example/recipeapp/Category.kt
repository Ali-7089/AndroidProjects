package com.example.recipeapp

data class Category(
    var idCategory : String,
    var nameOfCategory : String,
    var strCategoryThumb:String,
    var descriptionCategory:String
){
}

data class CategoriesResponse(
    var categories: List<Category>
)

