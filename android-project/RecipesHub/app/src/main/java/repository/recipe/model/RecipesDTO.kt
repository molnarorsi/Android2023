package repository.recipe.model

data class RecipesDTO(
    val count: Int,
    val results: List<RecipeDTO>
)
