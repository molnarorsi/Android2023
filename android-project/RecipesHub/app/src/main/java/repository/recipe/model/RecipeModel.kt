package repository.recipe.model

import repository.userratings.model.UserRatingModel

data class RecipeModel(
    val id: Int,
    val name: String,
    val description: String? = "Default description",
    val instruction: List<InstructionsModel>,
    val thumbnailUrl: String? = "",
    val userRating: UserRatingModel,
    val yields: String,
    val keywords: String? = "",
    val originalVideoUrl: String? = ""
)

