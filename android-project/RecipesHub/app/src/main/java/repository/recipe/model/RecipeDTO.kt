package repository.recipe.model

import com.google.gson.annotations.SerializedName
import repository.userratings.model.UserRatingDTO
import repository.userratings.model.toModel


data class RecipeDTO(
    val id: Int,
    val name: String,
    val description: String? = "",
    val thumbnail_url: String?,
    val user_ratings: UserRatingsDTO,
    val total_time_tier: TotalTimeDTO,
    val instructions: List<InstructionsDTO>

)

fun RecipeDTO.toModel() = RecipeModel (
    id=this.id,
    name=this.name,
    description=this.description,
    thumbnailUrl =this.thumbnail_url,
    userRatings = this.user_ratings.toModel(),
    totalTime = this.total_time_tier.toModel(),
    instructions = this.instructions.toModelList()
)


fun List<RecipeDTO>.toModelList(): List<RecipeModel> =
    this.map { it.toModel() }