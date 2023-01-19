package br.com.dirceu.kotlinComSpringBoot.infra.db.entities

import br.com.dirceu.kotlinComSpringBoot.business.domain.relatorioProducaoDiaria.RelatorioProducaoDiaria
import br.com.dirceu.kotlinComSpringBoot.business.domain.relatorioProducaoDiaria.RelatorioProducaoDiariaPorPocaPetroleo
import br.com.dirceu.kotlinComSpringBoot.business.domain.relatorioProducaoDiaria.StatusRelatorioDiarioEnum
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "RELATORIO_PRODUCAO_DIA")
class RelatorioProducaoDiariaEntity{

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

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "relatorioProducaoDiariaEntity")
    var producaoPorPocasPetroleo: List<RelatorioProducaoDiariaPorPocaPetroleoEntity>? = null

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "relatorioProducaoDiariaEntity")
    var erros: List<RelatorioProducaoDiariaErrosEntity>? = null


    fun toRelatorioProducaoDiaria() : RelatorioProducaoDiaria{
        var producaoPorPoca = mutableListOf<RelatorioProducaoDiariaPorPocaPetroleo>()
        for (prodPocaEntity in  this.producaoPorPocasPetroleo!!){
            producaoPorPoca.add(prodPocaEntity.toAlocacaoDiariaPorUc())
        }
        var errosEntity = mutableListOf<String>()
        for (erro in this.erros!!){
            errosEntity.add(erro.descricao)
        }

        return RelatorioProducaoDiaria(this.id,
                              this.unidadeNegocio!!.toUnidadeNegocio(),
                              this.data!!,
                              this.totalVolume,
                              producaoPorPoca,
                              StatusRelatorioDiarioEnum.valueOf(this.status!!),
                              errosEntity

        )
    }

    fun fromRelatorioProducaoDiaria(relatorioProducaoDiaria: RelatorioProducaoDiaria){
        this.id = relatorioProducaoDiaria.codigo
        val unidadeNegocioEntity = UnidadeNegocioEntity()
        unidadeNegocioEntity.fromUnidadeNegocio(relatorioProducaoDiaria.unidadeNegocio)
        this.unidadeNegocio = unidadeNegocioEntity
        this.data = relatorioProducaoDiaria.data
        this.status = relatorioProducaoDiaria.status.codigo
        this.totalVolume = relatorioProducaoDiaria.producaoPorPoca.sumOf { it.producao }
        this.erros = relatorioProducaoDiaria.erros.map {
            RelatorioProducaoDiariaErrosEntity(null,this, it)
        }
        this.producaoPorPocasPetroleo = relatorioProducaoDiaria.producaoPorPoca.map {
            RelatorioProducaoDiariaPorPocaPetroleoEntity(null, this, PocaPetroleoEntity().fromUnidadeControle(it.uc), it.producao)
        }
    }


}