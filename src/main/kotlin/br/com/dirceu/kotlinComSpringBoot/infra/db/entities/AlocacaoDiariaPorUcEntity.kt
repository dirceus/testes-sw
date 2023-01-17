package br.com.dirceu.kotlinComSpringBoot.infra.db.entities;
import br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria.AlocacaoDiaria
import br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria.AlocacaoDiariaPorUC
import jakarta.persistence.*

@Entity
@Table(name = "ALOCACAO_DIARIA_POR_UC")
class AlocacaoDiariaPorUcEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alocacao_diaria_id")
    var alocacaoDiariaEntity: AlocacaoDiariaEntity = AlocacaoDiariaEntity()

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unidade_controle_id")
    var unidadeControleEntity: UnidadeControleEntity? = null

    @Column(nullable = false)
    var volume: Double? = null

    fun toAlocacaoDiariaPorUc(): AlocacaoDiariaPorUC{
        val uc = this.unidadeControleEntity!!.toUnidadeControle()
        return AlocacaoDiariaPorUC(this.id,
                                   this.alocacaoDiariaEntity.data!!,
                                   this.volume!!,
                                   uc)
    }

    fun fromAlocacaoDiariaPorUc(it: AlocacaoDiariaPorUC, alocacaoDiaria: AlocacaoDiaria) {
        this.id = it.codigo
        val alocacaoDiariaEntity = AlocacaoDiariaEntity()
        alocacaoDiariaEntity.id = alocacaoDiaria.codigo
        this.alocacaoDiariaEntity = alocacaoDiariaEntity
        val unidadeControleEntity = UnidadeControleEntity()
        unidadeControleEntity.id = it.uc.codigo
        this.unidadeControleEntity = unidadeControleEntity
        this.volume = it.producao

    }


}
