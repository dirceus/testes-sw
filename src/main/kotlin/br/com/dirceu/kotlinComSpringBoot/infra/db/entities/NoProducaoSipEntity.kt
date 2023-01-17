package br.com.dirceu.kotlinComSpringBoot.infra.db.entities

import br.com.dirceu.kotlinComSpringBoot.business.domain.noSip.NoProducaoSip
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "NO_PRODUCAO_SIP")
class NoProducaoSipEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "no_sip_id")
    var noSip : NoSipEntity? = null

    @Column(nullable = false)
    var data: Date? = null

    @Column(nullable = false)
    var producao: Double? = null

    fun toNoProducaoSip() : NoProducaoSip {
        return NoProducaoSip(this.id,
            this.data!!,
            this.producao!!,
            this.noSip!!.toNoSip())
    }

    fun fromNoProducaoSip(noProducaoSip: NoProducaoSip){
        this.id = noProducaoSip.codigo
        var noSipEntity = NoSipEntity()
        noSipEntity.id = noProducaoSip.noSip.codigo
        this.noSip = noSipEntity
        this.data = noProducaoSip.data
        this.producao = noProducaoSip.producao
    }


}