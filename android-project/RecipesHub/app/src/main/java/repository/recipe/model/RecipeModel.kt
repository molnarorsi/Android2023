package repository.recipe.model

import repository.userratings.model.UserRatingModel

data class RecipeModel (
    val id: Int,
    val name: String,
    val description: String?,
    val thumbnailUrl: String?,
    val userRatings: UserRatingsModel,
    val totalTime: TotalTimeModel,
    val instructions: List<InstructionsModel>
)

