package fragments.recipe.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipeshub.R
import com.example.recipeshub.databinding.RecipeListItemBinding
import repository.recipe.model.RecipeModel

class RecipesListAdapter (
    private var recipeList : List<RecipeModel>,
    private val context: Context,
    private val onItemClickListener: (RecipeModel) -> Unit
):RecyclerView.Adapter<RecipesListAdapter.RecipeItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemViewHolder {
        val binding = RecipeListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return RecipeItemViewHolder(binding)
    }

    override fun getItemCount(): Int = recipeList.size

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        val currentRecipe = recipeList[position]

        holder.recipeTitleView.text = currentRecipe.name
        holder.recipeDescriptionView.text = currentRecipe.description

        Log.d("TAG", "onBindViewHolder: ${currentRecipe.thumbnailUrl}")

        Glide.with(context)
            .load(currentRecipe.thumbnailUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(holder.recipeImageView)

        val ratingsLabel = "Rating:"
        holder.recipeRatingView.text = ratingsLabel
            .plus(" ").plus(currentRecipe.userRatings.score)
    }

    fun setData(newLis: List<RecipeModel>) {
        recipeList = newLis
    }

    inner class RecipeItemViewHolder(binding: RecipeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val recipeTitleView: TextView = binding.recipeTitle
        val recipeDescriptionView: TextView = binding.recipeDescription
        val recipeImageView: ImageView = binding.recipePhoto
        val recipeRatingView: TextView = binding.recipeScore

        init {
            binding.root.setOnClickListener {
                val currentPosition = this.adapterPosition
                val currentRecipe = recipeList[currentPosition]

                onItemClickListener(currentRecipe)
            }
        }
    }
}