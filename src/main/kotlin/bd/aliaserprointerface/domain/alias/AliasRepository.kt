package bd.aliaserprointerface.domain.alias

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AliasRepository : JpaRepository<Alias, Int?> {

    fun deleteAliasByAlias(alias: String)
}