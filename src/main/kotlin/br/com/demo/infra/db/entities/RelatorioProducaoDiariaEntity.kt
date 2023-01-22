package br.com.demo.infra.db.entities

import br.com.demo.business.domain.relatorioProducaoDiaria.RelatorioProducaoDiaria
import br.com.demo.business.domain.relatorioProducaoDiaria.StatusRelatorioDiarioEnum
import jakarta.persistence.*
import java.time.LocalDate

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
    var data: LocalDate? = null

    @Column(nullable = false, name= "status_cod")
    var status: String? = null

    @Column(nullable = true)
    var totalVolume: Double? = null

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "relatorioProducaoDiariaEntity")
    var producaoPorPoco: List<RelatorioProducaoDiariaPorPocoEntity>? = null

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "relatorioProducaoDiariaEntity")
    var erros: List<RelatorioProducaoDiariaErrosEntity>? = null


    fun toRelatorioProducaoDiaria() : RelatorioProducaoDiaria{

        val relatorio =  RelatorioProducaoDiaria(
            this.unidadeNegocio!!.toUnidadeNegocio(),
            this.data!!)

        val producaoDiariaPorPoco = this.producaoPorPoco!!.map { it.toProducaoDiariaPorPoco() }.toMutableList()
        val listErros = this.erros!!.map { it.descricao }.toMutableList()

        relatorio.codigo = this.id
        relatorio.status = StatusRelatorioDiarioEnum.valueOf(this.status!!)
        relatorio.totalVolume = this.totalVolume!!
        relatorio.producaoDiariaPorPoco = producaoDiariaPorPoco
        relatorio.erros = listErros

        return relatorio
    }

    fun fromRelatorioProducaoDiaria(relatorioProducaoDiaria: RelatorioProducaoDiaria){
        this.id = relatorioProducaoDiaria.codigo
        val unidadeNegocioEntity = UnidadeNegocioEntity()
        unidadeNegocioEntity.fromUnidadeNegocio(relatorioProducaoDiaria.unidadeNegocio)
        this.unidadeNegocio = unidadeNegocioEntity
        this.data = relatorioProducaoDiaria.data
        this.status = relatorioProducaoDiaria.status.codigo
        this.totalVolume = relatorioProducaoDiaria.producaoDiariaPorPoco.sumOf { it.producao }
        this.erros = relatorioProducaoDiaria.erros.map {
            RelatorioProducaoDiariaErrosEntity(null,this, it)
        }
        this.producaoPorPoco = relatorioProducaoDiaria.producaoDiariaPorPoco.map {
            val pocoEntity = PocoEntity()
            pocoEntity.id = it.poco.codigo

            val prodPorPocoEntity = RelatorioProducaoDiariaPorPocoEntity(null,
                this,
                pocoEntity,it.producao)
            prodPorPocoEntity
        }
    }


}