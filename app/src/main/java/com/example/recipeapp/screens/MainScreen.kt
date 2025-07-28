// Name: Lesego Sebako
// Student Number: ST10493865

package com.example.receipeapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.recipeapp.navigation.RecipeData
import kotlin.system.exitProcess


@Composable
fun MainScreen(navController: NavHostController) {

    //Using remember & mutable states for playlist details
    var recipeTitle by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    var ingredients by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    //Included padding for the app title and padding to move the app below the status bar
    Column(modifier = Modifier.padding(16.dp).padding(top = 70.dp)) {
        Text("Add Recipe ", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        //Used outlined text fields for playlist data
        OutlinedTextField(
            value = recipeTitle,
            onValueChange = { recipeTitle = it },
            label = { Text("Recipe Title") })
        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Category") })
        OutlinedTextField(
            value = rating,
            onValueChange = { rating = it },
            label = { Text("Rating") })
        OutlinedTextField(
            value = ingredients,
            onValueChange = { ingredients = it },
            label = { Text("Ingredients") }
        )

        if (errorMessage.isNotBlank()) {
            Text(errorMessage, color = Color.Red)

        }
        //Executed spacers to manage spacing
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val ratingInt = rating.toIntOrNull()

            //Added error handling
            if (recipeTitle.isBlank() || category.isBlank() || ratingInt == null) {
                errorMessage = "Please fill in all the fields correctly."
            } else {
                RecipeData.RecipeTitle.add(recipeTitle)
                RecipeData.Category.add(recipeTitle)
                RecipeData.Rating.add(ratingInt)
                RecipeData.Ingredients.add(ingredients)
                errorMessage = ""
                recipeTitle = ""
                category = ""
                rating = ""
                ingredients = ""
            }
        }) {
            Text("Add to Recipe Book")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = { navController.navigate("list") }) {
            Text("View Recipe's")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {exitProcess(0)}) {
            Text("Exit App")
        }

    }
}
