package bd.aliaserprointerface.domain.recipe

import bd.aliaserprointerface.domain.recipe.Recipe
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.query.Procedure
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.persistence.NamedStoredProcedureQuery

@Repository
interface RecipeRepository : JpaRepository<Recipe, Int?> {

    @Query("""
        select r from Recipe r
        where r.id >= :startIndex and r.id <= :endIndex
    """)
    fun getRecipesInRange(
        @Param("startIndex") startIndex: Int,
        @Param("endIndex") endIndex: Int
    ): List<Recipe>

    @Query("""
        select count(r) from Recipe r
    """)
    fun countTableRecords(): Int

    @Query("""
        select * from pg_size_pretty(pg_database_size('aliaser-pro'))
    """, nativeQuery = true)
    fun getDatabaseSize(): String
}