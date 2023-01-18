package br.com.dirceu.kotlinComSpringBoot.infra.db.entities;
import br.com.dirceu.kotlinComSpringBoot.business.domain.relatorioProducaoDiaria.RelatorioProducaoDiariaPorPocaPetroleo
import jakarta.persistence.*

@Entity
@Table(name = "ALOCACAO_DIARIA_POR_UC")
class RelatorioProducaoDiariaPorPocaPetroleoEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alocacao_diaria_id")
    var relatorioProducaoDiariaEntity: RelatorioProducaoDiariaEntity?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unidade_controle_id")
    var pocaPetroleoEntity: PocaPetroleoEntity?,

    @Column(nullable = false)
    var volume: Double?
    ){
    fun toAlocacaoDiariaPorUc(): RelatorioProducaoDiariaPorPocaPetroleo{
        val uc = this.pocaPetroleoEntity!!.toUnidadeControle()
        return RelatorioProducaoDiariaPorPocaPetroleo(this.id,
                                   this.relatorioProducaoDiariaEntity!!.data!!,
                                   this.volume!!,
                                   uc)
    }

}
