package bd.aliaserprointerface.domain

import bd.aliaserprointerface.Generator
import bd.aliaserprointerface.api.AliaserServiceApi
import org.springframework.stereotype.Service

@Service
class RecipeService(
    val recipeRepository: RecipeRepository,
    val aliaserService: AliaserServiceApi
) {

    fun getAllRecipes(): List<Recipe> = recipeRepository.findAll()

    fun getRecipesInRange(startIndex: Int, endIndex: Int): List<Recipe> =
        recipeRepository.getRecipesInRange(startIndex, endIndex)

    fun generateRecipesOfQuantity(quantity: Int): List<Recipe> {
        val generator = Generator()
        val recipes: List<Recipe> = generator.getRecipes(quantity).map { Recipe(it) }
        return recipeRepository.saveAll(recipes)
    }

    fun createRecipe(name: String, description: String, isVege: Boolean) =
        recipeRepository.save(Recipe(name = name, description = description, isVege = isVege))

//    fun example(id: Int) {
//        //val recipe = recipeRepository.findById(1)
//        //aliaserService.getRecipe("192.168.1.88:8080/AliaserPRO/SendRecord?id=$id&text=ala ma kota")
//    }
}