package com.example.recipeapppractice

import retrofit2.http.GET

interface ApiService{
    @GET()
   suspend fun getCategories():categoriesResponse{

    }
}