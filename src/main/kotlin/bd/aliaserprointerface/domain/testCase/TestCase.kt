package bd.aliaserprointerface.domain.testCase

import bd.aliaserprointerface.domain.testCase.TestCaseStatus.READY
import javax.persistence.*

@Entity
class TestCase(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val leftId: Int,
    val leftAlias: String,
    @Column(length = 5000)
    val leftDescription: String,
    val rightId: Int,
    val rightAlias: String,
    @Column(length = 5000)
    val rightDescription: String,
    var status: Int = READY.ordinal
)