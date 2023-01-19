package br.com.dirceu.kotlinComSpringBoot.infra.db.entities

import br.com.dirceu.kotlinComSpringBoot.business.domain.PocaPetroleo.PocaPetroleo
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "POCA_PETROLEO",
    uniqueConstraints = [UniqueConstraint(name="unAndNome", columnNames = ["unidade_negocio_id","nome"])])
class PocaPetroleoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(nullable = false)
    var nome: String? = null

    @Column
    var descricao: String? = null

    @Column(nullable = false, name = "inicio_vigencia")
    var inicioVigencia: Date? = null

    @Column(nullable = true, name = "fim_vigencia")
    var fimVigencia: Date? = null

    @Column(nullable = false, name = "data_fim_retro")
    var dataFimRetroativa: Boolean = false

    @Column(nullable = true)
    var justificativa: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unidade_negocio_id")
    var unidadeNegocio: UnidadeNegocioEntity? = null

    fun toUnidadeControle() : PocaPetroleo{
        val un = this.unidadeNegocio!!.toUnidadeNegocio()
        return PocaPetroleo(this.id,
                                 this.nome!!,
                                 this.descricao,
                                 un,
                                 this.inicioVigencia!!,
                                 this.fimVigencia,
                                 this.justificativa,
                                 this.dataFimRetroativa)

    }

    fun fromUnidadeControle(uc : PocaPetroleo) : PocaPetroleoEntity{
        this.id = uc.codigo
        this.nome = uc.nome
        this.descricao = uc.descricao
        val unEntity = UnidadeNegocioEntity()
        unEntity.fromUnidadeNegocio(uc.unidadeNegocio)
        this.unidadeNegocio = unEntity
        this.inicioVigencia = uc.inicioVigencia
        this.fimVigencia = uc.fimVigencia
        this.dataFimRetroativa = uc.dataFimRetroativa
        return this
    }

}