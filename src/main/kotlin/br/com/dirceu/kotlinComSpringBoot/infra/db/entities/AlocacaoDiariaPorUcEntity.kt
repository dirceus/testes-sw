package br.com.dirceu.kotlinComSpringBoot.infra.db.entities;
import br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria.AlocacaoDiariaPorUC
import jakarta.persistence.*

@Entity
@Table(name = "ALOCACAO_DIARIA_POR_UC")
class AlocacaoDiariaPorUcEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alocacao_diaria_id")
    var alocacaoDiariaEntity: AlocacaoDiariaEntity?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unidade_controle_id")
    var unidadeControleEntity: UnidadeControleEntity? ,

    @Column(nullable = false)
    var volume: Double?
    ){
    fun toAlocacaoDiariaPorUc(): AlocacaoDiariaPorUC{
        val uc = this.unidadeControleEntity!!.toUnidadeControle()
        return AlocacaoDiariaPorUC(this.id,
                                   this.alocacaoDiariaEntity!!.data!!,
                                   this.volume!!,
                                   uc)
    }

}
