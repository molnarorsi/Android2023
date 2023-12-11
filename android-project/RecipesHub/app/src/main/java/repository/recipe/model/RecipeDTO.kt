package repository.recipe.model

import com.google.gson.annotations.SerializedName
import repository.userratings.model.UserRatingDTO
import repository.userratings.model.toModel


data class RecipeDTO(
    val id: Int,
    val name: String,
    val description: String? = "Default description",
    val instructions: List<InstructionsDTO>,
    val yields: String,
    val keywords: String?,

    @SerializedName("thumbnail_url")
    val thumbnailUrl: String? = "",

    @SerializedName("user_ratings")
    val userRatingDTO: UserRatingDTO,

    @SerializedName("original_video_url")
    val originalVideoUrl: String? = ""
)

fun RecipeDTO.toModel(): RecipeModel =
    RecipeModel (
        id = this.id,
        name = this.name,
        description = this.description,
        instruction = this.instructions.toModelList(),
        thumbnailUrl = this.thumbnailUrl,
        userRating = this.userRatingDTO.toModel(),
        yields = this.yields,
        keywords = this.keywords,
        originalVideoUrl = this.originalVideoUrl
    )

fun List<RecipeDTO>.toModelList(): List<RecipeModel> =
    this.map { it.toModel() }