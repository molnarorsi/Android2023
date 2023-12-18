package repository.recipe

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import database.RecipeDAO
import database.RecipeEntity
import org.json.JSONObject
import repository.recipe.model.RecipeModel
import repository.recipe.model.RecipesDTO
import repository.recipe.model.toModelList
import java.io.IOException

object RecipeRepository {

    private val TAG: String? = RecipeRepository::class.simpleName
    private var myRecipes : List<RecipeModel>? = emptyList()

    //JSON
    fun getRecipes(context: Context): List<RecipeModel> {
        lateinit var jsonString: String

        try {
            jsonString = context.assets.open("all_recipes.json").bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val recipesResponse: RecipesDTO = Gson().fromJson(jsonString, object: TypeToken<RecipesDTO>() {}.type)

        return recipesResponse.results.toModelList()
    }

    //LIST
    fun getRecipeById(context: Context, recipeId: Int): RecipeModel {
        return getRecipes(context).first { it.id == recipeId }
    }

    fun insertMyRecipe(recipe: RecipeModel) {
        myRecipes = myRecipes?.plus(recipe)
    }

    fun getMyRecipes() : List<RecipeModel>? = this.myRecipes

    //DATABASE
//    suspend fun insertRecipe(recipe: RecipeEntity) {
//        val result = RecipeDAO.insertRecipe(recipe)
//        Log.d("xyz", "insertRecipe: $result")
//    }
//
//    suspend fun deleteRecipe(recipe: RecipeEntity) {
//        val result = RecipeDAO.deleteRecipe(recipe)
//        Log.d("xyz", "deleteRecipe: $result")
//    }
//
//    suspend fun getAllRecipes(): List<RecipeModel> {
//        return RecipeDAO.getAllRecipes().map {
//            val jsonObject = JSONObject(it.json)
//            jsonObject.apply { put("id", it.internalId) }
//            Gson().fromJson(jsonObject.toString(), RecipeDTO::class.java).toModel()
//        }
//    }

}