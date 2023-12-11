package repository.recipe.model

import com.google.gson.annotations.SerializedName

data class InstructionsDTO (
    val id: Int,

    val appliance: String?,

    @SerializedName("start_time")
    val startTime: Int,

    @SerializedName("end_time")
    val endTime: Int,

    val temperature: String?,

    val position: Int,

    @SerializedName("display_text")
    val displayText: String,
)

fun InstructionsDTO.toModel(): InstructionsModel =
    InstructionsModel (
        id = this.id,
        displayText = this.displayText,
        time = InstructionTime(
            startTime = this.startTime,
            endTime = this.endTime
        )
    )

fun List<InstructionsDTO>.toModelList(): List<InstructionsModel> =
    this.map { it.toModel() }