package repository.recipe.model

data class RecipeModel(
    val id: Int,
    val name: String,
    val description: String? = "Default description",
    val thumbnailUrl: String
)
