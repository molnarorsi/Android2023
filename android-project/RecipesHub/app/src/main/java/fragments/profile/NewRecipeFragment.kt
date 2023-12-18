package fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.recipeshub.R
import com.example.recipeshub.databinding.FragmentNewRecipeBinding
import repository.recipe.RecipeRepository
import repository.recipe.model.InstructionTime
import repository.recipe.model.InstructionsModel
import repository.recipe.model.RecipeModel
import repository.userratings.model.UserRatingModel

class NewRecipeFragment : Fragment() {

    private lateinit var binding: FragmentNewRecipeBinding
    private val TAG: String? = NewRecipeFragment::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewRecipeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.createNewRecipeButton.setOnClickListener {
            Toast.makeText(context, "Creating new recipe...", Toast.LENGTH_SHORT).show()

            val newRecipe : RecipeModel = RecipeModel(
                id = 0,
                name = binding.newName.text.toString(),
                description = binding.newDescription.text.toString(),
                instruction = listOf(
                    InstructionsModel(
                        id=0,
                        displayText=binding.newInstruction1.text.toString(),
                        time = InstructionTime(startTime = 0, endTime = 0))
                ),
                thumbnailUrl = binding.newPictureURL.text.toString(),
                userRating = UserRatingModel(countPositive = 10, countNegative = 0, score = 10.0f),
                yields = "4",
                keywords = "new, recipe",
                originalVideoUrl = binding.newVideoURL.text.toString()
            )

            RecipeRepository.insertMyRecipe(newRecipe)

            navigateToProfile()
        }
    }

    private fun navigateToProfile() {
        findNavController()
            .navigate(R.id.action_newRecipeFragment_to_profileFragment)
    }

}