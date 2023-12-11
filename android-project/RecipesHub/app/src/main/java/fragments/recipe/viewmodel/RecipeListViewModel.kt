package fragments.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import repository.recipe.RecipeRepository
import repository.recipe.model.RecipeModel

class RecipeListViewModel: ViewModel() {

    private val repository = RecipeRepository

    var recipeList: MutableLiveData<List<RecipeModel>> = MutableLiveData()

    fun fetchRecipeData(context: Context) {
        recipeList.value = repository.getRecipes(context)
    }

    fun fetchMyRecipeData() {
        recipeList.value = repository.getMyRecipes()
    }

}