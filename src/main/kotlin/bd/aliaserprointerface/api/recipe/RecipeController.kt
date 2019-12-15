package bd.aliaserprointerface.api.recipe

import bd.aliaserprointerface.domain.recipe.Recipe
import bd.aliaserprointerface.domain.recipe.RecipeService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class RecipeController(val recipeService: RecipeService) {
    companion object {
        private const val RECIPES_BASE_PATH = "/recipe"
        private const val GENERATOR_BASE_PATH = "/generator"
        private const val QUANTITY = "quantity"
        private const val DATABASE_SIZE_PATH = "/dbsize"

        private const val GENERATE_RECIPES_OF_QUANTITY_PATH =
            "$RECIPES_BASE_PATH$GENERATOR_BASE_PATH/{$QUANTITY}"
        private const val GET_ALL_RECIPES_PATH =
            "$RECIPES_BASE_PATH/all"
        private const val CREATE_RECIPE_PATH =
            "$RECIPES_BASE_PATH/body"
        private const val COUNT_TABLE_RECORDS =
            "$RECIPES_BASE_PATH/count"
        private const val REPLACE_WITH_ALIASES_PATH =
            "$RECIPES_BASE_PATH/replace"
    }

    private val log = LoggerFactory.getLogger(RecipeController::class.java)

    @GetMapping(GET_ALL_RECIPES_PATH)
    fun getAllRecipes(): List<Recipe> {
        log.info("HTTP method GET\t$GET_ALL_RECIPES_PATH")
        return recipeService.getAllRecipes()
    }

    @GetMapping(RECIPES_BASE_PATH)
    fun getRecipesInRange(@RequestParam(required = true) startIndex: Int, @RequestParam(required = true) endIndex: Int): List<Recipe> {
        log.info("HTTP method GET\t$RECIPES_BASE_PATH?startIndex=$startIndex&endIndex=$endIndex")
        return recipeService.getRecipesInRange(startIndex, endIndex)
    }

    @PostMapping(GENERATE_RECIPES_OF_QUANTITY_PATH)
    fun generateRecipes(@PathVariable(value = QUANTITY) quantity: Int): List<Recipe> {
        log.info("HTTP method POST\t$GENERATE_RECIPES_OF_QUANTITY_PATH/$quantity")
        return recipeService.generateRecipesOfQuantity(quantity)
    }

    @PostMapping(RECIPES_BASE_PATH)
    fun createRecipe(
        @RequestParam(name = "name") name: String,
        @RequestParam(name = "description") description: String,
        @RequestParam(name = "isVege") isVege: Boolean
    ): Recipe {
        log.info("HTTP method POST\t$RECIPES_BASE_PATH?name=$name&description=$description&isVege=$isVege")
        return recipeService.createRecipe(name, description, isVege)
    }

    @PostMapping(CREATE_RECIPE_PATH)
    fun createRecipe(@RequestBody recipe: Recipe): Recipe {
        log.info("HTTP method POST\t$CREATE_RECIPE_PATH")
        log.info("${recipe.name}\t${recipe.description}\t${recipe.vege}")
        return recipeService.createRecipe(recipe)
    }

    @PostMapping(REPLACE_WITH_ALIASES_PATH)
    fun updateRecipe(@RequestBody recipes: List<Recipe>) {
        log.info("HTTP method POST\t$REPLACE_WITH_ALIASES_PATH")
        recipeService.updateRecipe(recipes)
    }

    @GetMapping(COUNT_TABLE_RECORDS)
    fun countTableRecords(): Int {
        log.info("HTTP method GET\t$COUNT_TABLE_RECORDS")
        return recipeService.countTableRecords()
    }

    @GetMapping(DATABASE_SIZE_PATH)
    fun getDatabaseSize(): String {
        log.info("HTTP method GET\t$DATABASE_SIZE_PATH")
        return recipeService.getDatabaseSize()
    }
}