package fragments.recipe

import android.annotation.SuppressLint
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
    private lateinit var binding: FragmentRecipesBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_recipes, container, false)

        binding = FragmentRecipesBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun navigateToRecipeDetail(recipe: RecipeModel) {
        findNavController()
            .navigate(
                R.id.action_recipesFragment_to_recipeDetailFragment,
                bundleOf("recipeId" to recipe.id)
            )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: RecipeListViewModel = ViewModelProvider(this)[RecipeListViewModel::class.java]
        val recyclerView: RecyclerView = view.findViewById(R.id.recipesRecyclerView)
        var adapter: RecipesListAdapter = RecipesListAdapter(listOf(), requireContext(), {}, {})

        context?.let { viewModel.fetchRecipeData(it) }

        viewModel.recipeList.observe(viewLifecycleOwner) { recipes: List<RecipeModel> ->
            for(recipe in recipes) {
                Log.d(TAG, "Recipe name: ${recipe.name}")
                Log.d(TAG, "Recipe description: ${recipe.name}")
                Log.d(TAG, "Recipe instruction: ${recipe.instruction}")
                Log.d(TAG, "----------")
            }

            adapter = RecipesListAdapter(
                recipes,
                requireContext(),

                onItemClick = {
                        currentRecipe: RecipeModel -> navigateToRecipeDetail(currentRecipe)
                },

                onDetailsClick = {
                        currentRecipe: RecipeModel -> navigateToRecipeDetail(currentRecipe)
                }
            )

            // Attach adapter to recycler view
            recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            recyclerView.adapter = adapter
        }

        binding.searchButton.setOnClickListener {
            val searchTextView = binding.searchTextView
            val searchText = searchTextView.text.toString()

            val filteredRecipes = viewModel.recipeList.value?.filter { recipe ->
                recipe.name.contains(searchText, ignoreCase = true)
            }

            Log.d(TAG, "Filtered recipes: $filteredRecipes")

            if(filteredRecipes == null)  return@setOnClickListener

            adapter.recipeList = filteredRecipes
            adapter.notifyDataSetChanged()
        }

        binding.sortByRatingsButton.setOnClickListener {
            val sortedRecipes = viewModel.recipeList.value?.sortedByDescending { recipe ->
                recipe.userRating.score
            } ?: return@setOnClickListener

            adapter.recipeList = sortedRecipes
            adapter.notifyDataSetChanged()
        }
    }
}