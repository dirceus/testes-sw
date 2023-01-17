package br.com.dirceu.kotlinComSpringBoot.infra.db.entities

import br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria.AlocacaoDiaria
import br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria.AlocacaoDiariaPorUC
import br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria.StatusAlocacaoDiariaEnum
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "ALOCACAO_DIARIA")
class AlocacaoDiariaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unidade_negocio_id")
    var unidadeNegocio : UnidadeNegocioEntity? = null

    @Column(nullable = false)
    var data: Date? = null

    @Column(nullable = false, name= "status_cod")
    var status: String? = null

    @Column(nullable = true)
    var totalVolume: Double? = null

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "alocacaoDiariaEntity")
    var alocacoesPorUC: List<AlocacaoDiariaPorUcEntity>? = null

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "alocacaoDiariaEntity")
    var relatorioErros: List<AlocacaoDiariaRelatorioErrosEntity>? = null


    fun toAlocacaoDiaria() : AlocacaoDiaria{
        var alocacoesPorUC = mutableListOf<AlocacaoDiariaPorUC>()
        for (alocEntity in  this.alocacoesPorUC!!){
            alocacoesPorUC.add(alocEntity.toAlocacaoDiariaPorUc())
        }
        var relatorioErrosEntity = mutableListOf<String>()
        for (erro in this.relatorioErros!!){
            relatorioErrosEntity.add(erro.descricao)
        }

        return AlocacaoDiaria(this.id,
                              this.unidadeNegocio!!.toUnidadeNegocio(),
                              this.data!!,
                              this.totalVolume,
                              alocacoesPorUC,
                              StatusAlocacaoDiariaEnum.valueOf(this.status!!),
                              relatorioErrosEntity

        )
    }

    fun fromAlocacaoDiaria(alocacaoDiaria: AlocacaoDiaria){
        this.id = alocacaoDiaria.codigo
        val unidadeNegocioEntity = UnidadeNegocioEntity()
        unidadeNegocioEntity.fromUnidadeNegocio(alocacaoDiaria.unidadeNegocio)
        this.unidadeNegocio = unidadeNegocioEntity
        this.data = alocacaoDiaria.dataAlocacao
        this.status = alocacaoDiaria.status.codigo

        var alocacoesPorUcEntity = alocacaoDiaria.alocacoesPorUC.map {
            convertAlocacaoPorUCemEntity(it,alocacaoDiaria)
        }
        this.totalVolume = alocacaoDiaria.alocacoesPorUC.sumOf { it.producao }
        this.alocacoesPorUC = alocacoesPorUcEntity
        this.relatorioErros = alocacaoDiaria.relatorioErros.map {
            AlocacaoDiariaRelatorioErrosEntity(null,this, it)
        }

    }

    private fun convertAlocacaoPorUCemEntity(alocacaoPorUc: AlocacaoDiariaPorUC, alocacaoDiaria:AlocacaoDiaria) : AlocacaoDiariaPorUcEntity{
        var alocacaoPorUcEntity = AlocacaoDiariaPorUcEntity()
        alocacaoPorUcEntity.fromAlocacaoDiariaPorUc(alocacaoPorUc, alocacaoDiaria)
        return alocacaoPorUcEntity
    }

}