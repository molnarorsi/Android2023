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
    private val TAG: String? = RecipeRepository::class.java.canonicalName

    fun getRecipes(context: Context): List<RecipeModel> {
        lateinit var jsonString: String
        try {
            jsonString =
                context.assets.open("all_recipes.json")
                    .bufferedReader()
                    .use{
                        it.readText()
                    }
        } catch (ioException: IOException) {
            Log.e(TAG, "Error occured while reading JSON file: $ioException")
        }

        val recipesResponse: RecipesDTO =
            Gson().fromJson(jsonString, object : TypeToken<RecipesDTO>() {}.type)
        return recipesResponse.results.toModelList()
    }
}