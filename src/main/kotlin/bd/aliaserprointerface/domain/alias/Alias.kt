package bd.aliaserprointerface.domain.alias

import javax.persistence.*

@Entity
class Alias(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(length = 5000)
    var content: String,
    var alias: String
)