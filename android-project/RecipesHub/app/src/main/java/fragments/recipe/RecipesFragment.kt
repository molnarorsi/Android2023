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

class RecipesFragment : Fragment() {
    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val TAG = "RecipesFragment"
        const val BUNDLE_EXTRA_SELECTED_RECIPE_ID = "selected_recipe_id"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val recipeViewModel = ViewModelProvider(this).get(RecipeListViewModel::class.java)
        context?.let {
            recipeViewModel.fetchRecipeData(it)
        }
        recipeViewModel.recipesList.observe(viewLifecycleOwner) { recipes ->
            for (recipe in recipes) {
                Log.d(TAG, "Recipe= ${recipe.name}")
                Log.d(TAG, "Recipe= ${recipe.description}")

            }

            val recipeAdapter = context?.let { RecipesListAdapter(recipes, it) }
            val recyclerView: RecyclerView = binding.RecyclerView
            recyclerView.adapter = recipeAdapter

        }

        return rootView
    }

    private fun initRecyclerView() {
        recipesAdapter = RecipesListAdapter(ArrayList(), requireContext(),
            onItemClickListener =
            {
                recipe ->
                    navigateToRecipeDetail(recipe)
            })

        binding.RecyclerView.adapter = recipesAdapter
        binding.RecyclerView.layoutManager = LinearLayoutManager(context)
        binding.RecyclerView.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateTo(){
        findNavController().navigate(R.id.action_recipesFragment_to_recipeDetailFragment,bundleOf())
    }

}