package bd.aliaserprointerface.api

import bd.aliaserprointerface.domain.RecipeService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class RecipeController(val recipeService: RecipeService) {
    companion object {
        private const val RECIPES_BASE_PATH = "/recipes"
        private const val GENERATOR_BASE_PATH = "/generator"
        private const val QUANTITY = "quantity"

        private const val GENERATE_RECIPES_OF_QUANTITY_PATH =
            "$RECIPES_BASE_PATH$GENERATOR_BASE_PATH/{$QUANTITY}"
    }

    @GetMapping(RECIPES_BASE_PATH)
    fun getRecipesInRange(@RequestParam startIndex: Int, @RequestParam endIndex: Int) =
        recipeService.getRecipesInRange(startIndex, endIndex)

    @PostMapping(GENERATE_RECIPES_OF_QUANTITY_PATH)
    fun generateRecipes(@PathVariable(value = QUANTITY) quantity: Int) =
        recipeService.generateRecipesOfQuantity(quantity)

//    @GetMapping("/recipe")
//    fun getAliasForRecipe() {
//        recipeService.example(1)
//    }
}