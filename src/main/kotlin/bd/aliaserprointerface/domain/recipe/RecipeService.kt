package bd.aliaserprointerface.domain.recipe

import bd.aliaserprointerface.Generator
import bd.aliaserprointerface.api.AliaserServiceApi
import org.springframework.stereotype.Service

@Service
class RecipeService(
    val recipeRepository: RecipeRepository,
    val aliaserService: AliaserServiceApi
) {
//    @Value("\${my-security.password}")
//    lateinit var password: String

    fun getAllRecipes(): List<Recipe> = recipeRepository.findAll()

    fun getRecipesInRange(startIndex: Int, endIndex: Int): List<Recipe> =
        recipeRepository.getRecipesInRange(startIndex, endIndex)

    fun generateRecipesOfQuantity(quantity: Int): List<Recipe> {
        val generator = Generator()
        val recipes: List<Recipe> = generator.getRecipes(quantity).map {
            Recipe(it)
        }
        return recipeRepository.saveAll(recipes)
    }

    fun createRecipe(name: String, description: String, isVege: Boolean) =
        recipeRepository.save(
            Recipe(
                name = name,
                description = description,
                isVege = isVege
            )
        )

    fun createRecipe(recipe: Recipe) = recipeRepository.save(recipe)

    fun updateRecipe(id: Int, alias: String) =
        recipeRepository.save(recipeRepository.getOne(id).copy(description = alias))

    fun countTableRecords() = recipeRepository.countTableRecords()

    fun getDatabaseSize() = recipeRepository.getDatabaseSize()

    fun checkPassword(password: String) = password == "maslo123"
}