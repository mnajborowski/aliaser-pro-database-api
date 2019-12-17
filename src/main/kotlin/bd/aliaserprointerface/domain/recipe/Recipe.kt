package bd.aliaserprointerface.domain.recipe

import javax.persistence.*

@Entity
data class Recipe(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val name: String,
    val vege: Boolean,
    @Column(length = 5000)
    var description: String
) {

    constructor(recipe: bd.aliaserprointerface.Recipe): this(
        name = recipe.name,
        vege = recipe.vege,
        description = recipe.description
    )
}