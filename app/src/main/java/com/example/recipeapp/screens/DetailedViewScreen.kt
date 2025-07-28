package com.example.recipeapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipeapp.navigation.RecipeData

@Composable
fun DetailedViewScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp).padding(top = 70.dp)) {
        Text("Music Library", style = MaterialTheme.typography.titleLarge)

        for (i in RecipeData.RecipeTitle.indices) {
            Text("${RecipeData.RecipeTitle[i]} (${RecipeData.RecipeTitle[i]}): ${RecipeData.Rating[i]} - ${RecipeData.Ingredients[i]}")
        }

        Spacer(modifier = Modifier.height(16.dp))


        for (i in RecipeData.RecipeTitle.indices) {
            if (RecipeData.Rating[i] >= 2) {
                Text("${RecipeData.RecipeTitle[i]}: ${RecipeData.Rating[i]}")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("main") }) {
            Text("Back to Main")
        }
    }
}