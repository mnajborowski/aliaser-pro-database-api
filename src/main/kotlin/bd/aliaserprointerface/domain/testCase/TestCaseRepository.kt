package bd.aliaserprointerface.domain.testCase

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TestCaseRepository : JpaRepository<TestCase, Int?> {

    @Query("""
        select * from test_case
        where status = 0
        order by id
        limit 1;
    """, nativeQuery = true)
    fun getFirstReadyTestCase(): TestCase
}