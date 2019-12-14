package bd.aliaserprointerface.domain.testCase

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import bd.aliaserprointerface.domain.testCase.TestCaseStatus.*

@Entity
class TestCase(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val leftId: Int,
    val leftAlias: String,
    val leftDescription: String,
    val rightId: Int,
    val rightAlias: String,
    val rightDescription: String,
    var status: TestCaseStatus = READY
)