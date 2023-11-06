package fragments.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.recipeshub.R
import fragments.recipe.viewmodel.RecipeListViewModel

class RecipesFragment : Fragment() {
    private val TAG: String = "RecipeFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        context?.let {
//            val recipes = RecipeRepository.getRecipes(it)
//            for(recipe in recipes) {
//                Log.d(TAG, "Number of recipes = " + recipes.size)
//            }
//        }

        val viewModel =
            ViewModelProvider(this).get(RecipeListViewModel::class.java)
        context?.let {
            viewModel.fetchRecipeData(it)
        }

        viewModel.recipesList.observe(viewLifecycleOwner) { recipes ->
            for(recipe in recipes) {
                Log.d(TAG, "Recipe name: ${recipe.name}")
                Log.d(TAG, "Recipe description: ${recipe.description}")
                Log.d(TAG, "-------------------------------------------")
            }
        }
    }
}