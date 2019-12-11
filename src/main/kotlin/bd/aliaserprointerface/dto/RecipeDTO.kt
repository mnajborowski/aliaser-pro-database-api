package bd.aliaserprointerface.dto

import bd.aliaserprointerface.domain.Recipe

data class RecipeDTO(
    val id: Int?,
    val name: String,
    val isVege: Boolean,
    val description: String
) {
    constructor(recipe: Recipe): this(
        id = recipe.id,
        name = recipe.name,
        isVege = recipe.isVege,
        description = recipe.description
    )

    fun toRecipe(): Recipe = Recipe(
        this.id,
        this.name,
        this.isVege,
        this.description
    )
}