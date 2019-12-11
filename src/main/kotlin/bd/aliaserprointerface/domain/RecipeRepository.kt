package bd.aliaserprointerface.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

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
}