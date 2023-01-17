package br.com.dirceu.kotlinComSpringBoot.infra.db.entities

import br.com.dirceu.kotlinComSpringBoot.business.domain.noSip.NoSip
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeControle.UnidadeControle
import jakarta.persistence.*

@Entity
@Table(name = "NO_SIP",
    uniqueConstraints =
    [UniqueConstraint(name="unAndNome", columnNames = ["unidade_negocio_id","nome"])])
class NoSipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "unidade_negocio_id")
    var unidadeNegocio: UnidadeNegocioEntity? = null

    @Column(nullable = false)
    var nome: String? = null

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "UCS_VINCULADAS_NO_SIP",
        joinColumns = [JoinColumn(name = "no_sip_id")],
        inverseJoinColumns = [JoinColumn(name = "unidade_controle_id")]
    )
    var ucsVinculadas: List<UnidadeControleEntity> = arrayListOf()

    fun toNoSip(): NoSip {
        return NoSip(this.id, this.unidadeNegocio!!.toUnidadeNegocio(), this.nome!!)
    }

    fun fromNoSip(noSip: NoSip, ucsVinculadas: List<UnidadeControle>) {
        this.id = noSip.codigo
        this.nome = noSip.nome
        var unidadeNegocioEntity = UnidadeNegocioEntity()
        unidadeNegocioEntity.fromUnidadeNegocio(noSip.unidadeNegocio)
        this.unidadeNegocio = unidadeNegocioEntity
        var ucsViculadasEntity = ucsVinculadas.map {convertUnidadeControleToUnidadeControleEntity(it)}
        this.ucsVinculadas = ucsViculadasEntity
    }

    private fun convertUnidadeControleToUnidadeControleEntity(uc: UnidadeControle):UnidadeControleEntity {
        var entity = (UnidadeControleEntity())
        entity.fromUnidadeControle(uc)
        return entity
    }





}

