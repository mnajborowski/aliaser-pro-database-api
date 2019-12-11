package bd.aliaserprointerface.domain

import bd.aliaserprointerface.api.AliaserServiceApi
import org.springframework.stereotype.Service

@Service
class RecipeService(
    val recipeRepository: RecipeRepository,
    val aliaserService: AliaserServiceApi
) {

    fun getRecipesInRange(startIndex: Int, endIndex: Int): List<Recipe> =
        recipeRepository.getRecipesInRange(startIndex, endIndex)

    fun generateRecipesOfQuantity(quantity: Int): List<Recipe> {
        val recipes: MutableList<Recipe> = mutableListOf()
        repeat(quantity) {
            recipes.add(Recipe(bd.aliaserprointerface.Recipe()))
        }
        return recipeRepository.saveAll(recipes)
    }

//    fun example(id: Int) {
//        //val recipe = recipeRepository.findById(1)
//        //aliaserService.getRecipe("192.168.1.88:8080/AliaserPRO/SendRecord?id=$id&text=ala ma kota")
//    }
}