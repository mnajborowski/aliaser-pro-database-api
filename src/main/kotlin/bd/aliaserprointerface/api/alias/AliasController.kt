package bd.aliaserprointerface.api.alias

import bd.aliaserprointerface.api.recipe.RecipeController
import bd.aliaserprointerface.domain.alias.Alias
import bd.aliaserprointerface.domain.alias.AliasService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AliasController(val aliasService: AliasService) {
    companion object {
        private const val ALIAS_BASE_PATH = "alias"

        private const val ADD_ALIASES_PATH =
            "$ALIAS_BASE_PATH/all"
    }

    private val log = LoggerFactory.getLogger(AliasController::class.java)

    @PostMapping(ALIAS_BASE_PATH)
    fun addAlias(@RequestBody alias: Alias): Alias {
        log.info("HTTP method POST\t$ALIAS_BASE_PATH")
        return aliasService.addAlias(alias)
    }

    @PostMapping(ADD_ALIASES_PATH)
    fun addAliases(@RequestBody aliases: List<Alias>): List<Alias> {
        log.info("HTTP method POST\t$ADD_ALIASES_PATH")
        return aliasService.addAliases(aliases)
    }
}