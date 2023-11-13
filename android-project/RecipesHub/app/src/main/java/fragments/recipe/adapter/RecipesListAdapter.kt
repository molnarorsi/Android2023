package fragments.recipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeshub.databinding.RecipeListItemBinding
import repository.recipe.model.RecipeModel

class RecipesListAdapter(
    private var recipesList: List<RecipeModel>,
    private var context: Context
) :  RecyclerView.Adapter<RecipesListAdapter.RecipeItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemViewHolder {
        val binding = RecipeListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return RecipeItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return recipesList.size
    }

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        val currentRecipe = recipesList[position]

        holder.recipeTitleView.text = currentRecipe.name
        holder.recipeDescriptionView.text = currentRecipe.description
    }

    inner class RecipeItemViewHolder(binding: RecipeListItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val recipeTitleView: TextView = binding.recipeItemTitleView
                val recipeDescriptionView: TextView = binding.recipeItemDescriptionView
            }
}