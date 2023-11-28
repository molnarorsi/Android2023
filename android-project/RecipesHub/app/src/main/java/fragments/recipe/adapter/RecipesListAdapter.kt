package fragments.recipe.adapter

import android.content.Context
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

class RecipesListAdapter(
    private var recipesList: List<RecipeModel>,
    private val context: Context) :
    RecyclerView.Adapter<RecipesListAdapter.RecipeViewHolder>() {
    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recipeName: TextView
        val recipeDescription: TextView
        val recipePicture: ImageView
        val ratingsView: TextView

        init {
            // Define click listener for the ViewHolder's View
            recipeName = view.findViewById(R.id.recipeTitle)
            recipeDescription = view.findViewById(R.id.recipeDescription)
            recipePicture = view.findViewById(R.id.recipePhoto)
            ratingsView = view.findViewById(R.id.recipeScore)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecipeViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recipe_list_item, viewGroup, false)

        return RecipeViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: RecipeViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val currentRecipe = recipesList[position]
        viewHolder.recipeName.text = currentRecipe.name
        viewHolder.recipeDescription.text = currentRecipe.description

        val rating = String.format("%.2f", currentRecipe.userRating.score * 10).toDouble()

        Glide.with(context)
            .load(currentRecipe.thumbnailUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(viewHolder.recipePicture)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = recipesList.size
}