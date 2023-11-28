package repository.recipe.model

import com.google.gson.annotations.SerializedName
import repository.userratings.model.UserRatingDTO
import repository.userratings.model.toModel


data class RecipeDTO(
    val id: Int,
    val name: String,
    val description: String? = "Default description",

    @SerializedName("thumbnail_url")
    val thumbnailUrl: String? = "",

    @SerializedName("user_ratings")
    val userRatingDTO: UserRatingDTO
)

fun RecipeDTO.toModel(): RecipeModel {
    return RecipeModel(
        id = this.id,
        name = this.name,
        description = this.description,
        thumbnailUrl = this.thumbnailUrl,
        userRating = this.userRatingDTO.toModel()
    )
}

fun List<RecipeDTO>.toModelList(): List<RecipeModel> =
    this.map { it.toModel() }