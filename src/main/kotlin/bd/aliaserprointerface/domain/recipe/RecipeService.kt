package bd.aliaserprointerface.domain.recipe

import bd.aliaserprointerface.Generator
import org.springframework.stereotype.Service

@Service
class RecipeService(val recipeRepository: RecipeRepository) {

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
                vege = isVege
            )
        )

    fun createRecipe(recipe: Recipe) = recipeRepository.save(recipe)

    fun replaceWithAliases(recipes: List<Recipe>): List<Recipe> = recipeRepository.saveAll(recipes)

    fun updateAlias(id: Int, alias: String) {
        val recipe = recipeRepository.getOne(id)
        recipeRepository.save(recipe.copy(description = "#$alias"))
    }

    fun countTableRecords() = recipeRepository.countTableRecords()

    fun getDatabaseSize() = recipeRepository.getDatabaseSize()
}