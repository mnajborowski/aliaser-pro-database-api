package bd.aliaserprointerface.domain.recipe

import javax.persistence.*

@Entity
data class Recipe(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val name: String,
    val isVege: Boolean,
    @Column(length = 5000)
    var description: String
) {

    constructor(recipe: bd.aliaserprointerface.Recipe): this(
        name = recipe.name,
        isVege = recipe.isVege,
        description = recipe.description
    )
}