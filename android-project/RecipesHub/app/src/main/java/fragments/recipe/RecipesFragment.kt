package fragments.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeshub.R
import com.example.recipeshub.databinding.FragmentRecipesBinding
import fragments.recipe.adapter.RecipesListAdapter
import fragments.recipe.viewmodel.RecipeListViewModel
import repository.recipe.model.RecipeModel

class RecipesFragment : Fragment() {

    private val TAG: String? = RecipesFragment::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    private fun navigateToRecipeDetail(recipe: RecipeModel): Unit {
        findNavController()
            .navigate(
                R.id.action_recipesFragment_to_recipeDetailFragment,
                bundleOf("recipeId" to recipe.id)
            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: RecipeListViewModel = ViewModelProvider(this)[RecipeListViewModel::class.java]
        val recyclerView: RecyclerView = view.findViewById(R.id.recipesRecyclerView)

        context?.let { viewModel.fetchRecipesData(it) }

        viewModel.recipesList.observe(viewLifecycleOwner) { recipes: List<RecipeModel> ->
            for (recipe in recipes) {
                Log.d(TAG, "Recipe name: ${recipe.name}")
                Log.d(TAG, "Recipe description: ${recipe.name}")
                Log.d(TAG, "Recipe instruction: ${recipe.instruction}")
                Log.d(TAG, "----------")

                val adapter = RecipesListAdapter(
                    recipes,
                    requireContext(),

                    onItemClick = { currentRecipe: RecipeModel ->
                        navigateToRecipeDetail(currentRecipe)
                    },

                    onDetailsClick = { currentRecipe: RecipeModel ->
                        navigateToRecipeDetail(currentRecipe)
                    }
                )

                // Attach adapter to recycler view
                recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                recyclerView.adapter = adapter
            }
        }
    }

}