package fragments.profile.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import repository.recipe.RecipeRepository
import repository.recipe.model.RecipeModel
import android.content.Context

class ProfileViewModel(private val repository: RecipeRepository) : ViewModel() {
    //live data members
    var myRecipeList: MutableLiveData<List<RecipeModel>> =
        MutableLiveData()

    var insertResult: MutableLiveData<Boolean> =
        MutableLiveData()

    var deleteResult: MutableLiveData<Boolean> =
        MutableLiveData()

    fun fetchMyRecipesData(context: Context) {
        val recipes = repository.getMyRecipes(context)
        myRecipeList.value = recipes
    }
}