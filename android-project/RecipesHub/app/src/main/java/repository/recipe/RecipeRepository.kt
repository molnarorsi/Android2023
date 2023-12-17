package repository.recipe

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import repository.recipe.model.RecipeModel
import repository.recipe.model.RecipesDTO
import repository.recipe.model.toModelList
import java.io.IOException

object RecipeRepository {

    private val TAG: String? = RecipeRepository::class.simpleName
    private var myRecipes : List<RecipeModel>? = emptyList()

    fun getRecipes(context: Context): List<RecipeModel> {
        lateinit var jsonString: String

        try {
            jsonString = context.assets.open("recipes.json").bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val recipesResponse: RecipesDTO = Gson().fromJson(jsonString, object: TypeToken<RecipesDTO>() {}.type)

        return recipesResponse.results.toModelList()
    }

    fun getRecipeById(context: Context, recipeId: Int): RecipeModel {
        return getRecipes(context).first { it.id == recipeId }
    }

    fun insertMyRecipe(recipe: RecipeModel) {
        myRecipes = myRecipes?.plus(recipe)
    }

    fun deleteMyRecipe(recipe: RecipeModel) {
        
    }


    fun getMyRecipes() : List<RecipeModel>? = this.myRecipes

}