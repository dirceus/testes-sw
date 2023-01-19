package br.com.dirceu.kotlinComSpringBoot.infra.db.entities

import br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao.ProducaoDia
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "PRODUCAO_TANQUE_DIA")
class ProducaoDiaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "no_sip_id")
    var tanqueProducao : TanqueProducaoEntity? = null

    @Column(nullable = false)
    var data: Date? = null

    @Column(nullable = false)
    var producao: Double? = null

    fun toProducaoDia() : ProducaoDia {
        return ProducaoDia(this.id,
            this.data!!,
            this.producao!!,
            this.tanqueProducao!!.toTanqueProducao())
    }

    fun fromProducaoDia(producaoDia: ProducaoDia){
        this.id = producaoDia.codigo
        var tanqueProducaoEntity = TanqueProducaoEntity()
        tanqueProducaoEntity.id = producaoDia.tanqueProducao.codigo
        this.tanqueProducao = tanqueProducaoEntity
        this.data = producaoDia.data
        this.producao = producaoDia.producao
    }


}