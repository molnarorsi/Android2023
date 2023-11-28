package fragments.recipe.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import repository.recipe.RecipeRepository
import repository.recipe.model.RecipeModel

class RecipeDetailViewModel : ViewModel() {
    var recipe: MutableLiveData<RecipeModel> = MutableLiveData()

    fun fetchRecipeDetail(recipeId: Int) {
        //val recipeDatabase = RecipeDatabase.
        val recipe = RecipeRepository.getRecipe(recipeId)
        this.recipe.value = recipe
    }
}