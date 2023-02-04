package br.com.demo.infra.db.entities;
import br.com.demo.business.domain.relatorioProducaoDiaria.ProducaoDiariaPorPoco
import jakarta.persistence.*

@Entity
@Table(name = "RELATORIO_PRODUCAO_DIA_POR_POCO")
class RelatorioProducaoDiariaPorPocoEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alocacao_diaria_id")
    var relatorioProducaoDiariaEntity: RelatorioProducaoDiariaEntity?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unidade_controle_id")
    var pocoEntity: PocoEntity?,

    @Column(nullable = false)
    var volume: Double?
    ){
    fun toProducaoDiariaPorPoco(): ProducaoDiariaPorPoco{

        var producaoPorPoco = ProducaoDiariaPorPoco(pocoEntity!!.toPoco(),
                            this.relatorioProducaoDiariaEntity!!.data!!,
                                   this.volume!!)
        producaoPorPoco.codigo = this.id
        return producaoPorPoco
    }

}
