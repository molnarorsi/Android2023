package fragments.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import repository.recipe.RecipeRepository
import repository.recipe.model.RecipeModel

class RecipeListViewModel : ViewModel() {
    private val repository = RecipeRepository

    var recipesList: MutableLiveData<List<RecipeModel>> = MutableLiveData()

    fun fetchRecipeData(context: Context) {
        val recipes = repository.getRecipes(context)
        recipesList.value = recipes
    }
}