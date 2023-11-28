package repository.recipe.model

import repository.userratings.model.UserRatingModel

data class RecipeModel(
    val id: Int,
    val name: String,
    val description: String? = "Default description",
    val thumbnailUrl: String? = "",
    val userRating: UserRatingModel
)
