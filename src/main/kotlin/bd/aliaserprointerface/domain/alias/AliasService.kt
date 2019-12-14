package bd.aliaserprointerface.domain.alias

import org.springframework.stereotype.Service

@Service
class AliasService(val aliasRepository: AliasRepository) {
    fun addAlias(alias: Alias) = aliasRepository.save(alias)

    fun addAliases(aliases: List<Alias>) = aliasRepository.saveAll(aliases)
}