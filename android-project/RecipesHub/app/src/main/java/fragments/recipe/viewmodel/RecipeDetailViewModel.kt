package fragments.recipe.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import repository.recipe.RecipeRepository
import repository.recipe.model.RecipeModel

class RecipeDetailViewModel: ViewModel() {

    private val repository = RecipeRepository
    var recipe: MutableLiveData<RecipeModel> = MutableLiveData()

    fun fetchRecipeDetail(context: Context, recipeId: Int) {
        recipe.value = repository.getRecipeById(context, recipeId)
    }

}