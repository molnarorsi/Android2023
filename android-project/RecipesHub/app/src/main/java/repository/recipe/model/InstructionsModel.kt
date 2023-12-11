package repository.recipe.model

data class InstructionsModel (
    val id: Int,
    val displayText: String,
    val time: InstructionTime
)

data class InstructionTime (
    val startTime: Int,
    val endTime: Int
)
