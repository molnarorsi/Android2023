package repository.recipe.model

data class RecipeDTO(
    val id: Int,
    val name: String,
    val description: String? = "Default description",
    val thumbnail_url: String
)

fun RecipeDTO.toModel(): RecipeModel {
    return RecipeModel(
        id = this.id,
        name = this.name,
        description = this.description,
        thumbnailUrl = this.thumbnail_url
    )
}

fun List<RecipeDTO>.toModelList(): List<RecipeModel> =
    this.map { it.toModel() }