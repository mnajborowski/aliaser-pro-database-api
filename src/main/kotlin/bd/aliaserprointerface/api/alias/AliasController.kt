package bd.aliaserprointerface.api.alias

import bd.aliaserprointerface.domain.alias.Alias
import bd.aliaserprointerface.domain.alias.AliasService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class AliasController(val aliasService: AliasService) {
    companion object {
        private const val ALIAS_BASE_PATH = "/alias"

        private const val ADD_ALIASES_PATH = "$ALIAS_BASE_PATH/all"
        private const val DELETE_ALIAS_PATH = "$ALIAS_BASE_PATH/delete"
    }

    private val log = LoggerFactory.getLogger(AliasController::class.java)

    @PostMapping(ALIAS_BASE_PATH)
    fun addAlias(@RequestBody alias: Alias) {
        log.info("HTTP method POST\t$ALIAS_BASE_PATH")
        aliasService.addAlias(alias)
    }

    @PostMapping(ADD_ALIASES_PATH)
    fun addAliases(@RequestBody aliases: List<Alias>) {
        log.info("HTTP method POST\t$ADD_ALIASES_PATH")
        aliasService.addAliases(aliases)
    }

    @PutMapping(DELETE_ALIAS_PATH)
    fun deleteAlias(@RequestParam(name = "alias") alias: String) {
        log.info("HTTP method POST\t$DELETE_ALIAS_PATH")
        aliasService.deleteAlias(alias)
    }
}