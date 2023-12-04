package fragments.recipe.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import repository.recipe.RecipeRepository
import repository.recipe.model.RecipeModel

class RecipeDetailViewModel : ViewModel() {
    private val repository = RecipeRepository

    var recipe: MutableLiveData<RecipeModel> = MutableLiveData()

    fun fetchRecipeData(recipeId: Int) {
        val recipe = repository.getRecipe(recipeId)
        this.recipe.value = recipe
    }
}