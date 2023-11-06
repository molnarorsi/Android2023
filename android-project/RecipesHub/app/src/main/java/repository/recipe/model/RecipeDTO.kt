package repository.recipe.model

data class RecipeDTO(
    val id: Int,
    val name: String,
    val description: String? = "Default description"
)

fun RecipeDTO.toModel(): RecipeModel {
    return RecipeModel(
        name = this.name,
        description = this.description
    )
}

fun List<RecipeDTO>.toModelList(): List<RecipeModel> =
    this.map { it.toModel() }