package bd.aliaserprointerface.domain

import bd.aliaserprointerface.dto.RecipeDTO
import java.io.File
import java.io.FileNotFoundException
import java.util.*
import javax.persistence.*

@Entity
class Recipe(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val name: String,
    val isVege: Boolean,
    @Column(length = 5000)
    val description: String
) {

    constructor(recipe: bd.aliaserprointerface.Recipe): this(
        name = recipe.name,
        isVege = recipe.isVege,
        description = recipe.description
    )

    constructor(recipeDTO: RecipeDTO): this(
        id = recipeDTO.id,
        name = recipeDTO.name,
        isVege = recipeDTO.isVege,
        description = recipeDTO.description
    )

    fun toRecipeDTO(): RecipeDTO = RecipeDTO(
        this.id,
        this.name,
        this.isVege,
        this.description
    )
}