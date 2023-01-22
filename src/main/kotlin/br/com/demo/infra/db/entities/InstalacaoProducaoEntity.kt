package br.com.demo.infra.db.entities

import br.com.demo.business.domain.instalacao.InstalacaoProducao
import jakarta.persistence.*

@Entity
@Table(name = "TANQUE_PRODUCAO",
    uniqueConstraints =
    [UniqueConstraint(name="unAndNome", columnNames = ["unidade_negocio_id","nome"])])
class InstalacaoProducaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "unidade_negocio_id")
    var unidadeNegocio: UnidadeNegocioEntity? = null

    @Column(nullable = false)
    var nome: String? = null

    @Column(nullable = false)
    var ativo: Boolean? = null


    fun toInstalacaoProducao(): InstalacaoProducao {
        return InstalacaoProducao(this.id, this.unidadeNegocio!!.toUnidadeNegocio(), this.nome!!, this.ativo!!)
    }

    fun fromInstalacaoProducao(instalacaoProducao: InstalacaoProducao) {
        this.id = instalacaoProducao.codigo
        this.nome = instalacaoProducao.nome
        var unidadeNegocioEntity = UnidadeNegocioEntity()
        unidadeNegocioEntity.fromUnidadeNegocio(instalacaoProducao.unidadeNegocio)
        this.unidadeNegocio = unidadeNegocioEntity
        this.ativo = instalacaoProducao.ativo
    }





}

