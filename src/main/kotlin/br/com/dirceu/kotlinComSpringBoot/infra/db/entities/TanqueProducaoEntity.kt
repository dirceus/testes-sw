package br.com.dirceu.kotlinComSpringBoot.infra.db.entities

import br.com.dirceu.kotlinComSpringBoot.business.domain.PocaPetroleo.PocaPetroleo
import br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao.TanqueProducao
import jakarta.persistence.*

@Entity
@Table(name = "TANQUE_PRODUCAO",
    uniqueConstraints =
    [UniqueConstraint(name="unAndNome", columnNames = ["unidade_negocio_id","nome"])])
class TanqueProducaoEntity {

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
        name = "POCAS_VINCULADAS_TANQUE",
        joinColumns = [JoinColumn(name = "tanque_id")],
        inverseJoinColumns = [JoinColumn(name = "poca_id")]
    )
    var pocasVinculadas: List<PocaPetroleoEntity> = arrayListOf()

    fun toTanqueProducao(): TanqueProducao {
        return TanqueProducao(this.id, this.unidadeNegocio!!.toUnidadeNegocio(), this.nome!!)
    }

    fun fromNoSip(tanqueProducao: TanqueProducao, ucsVinculadas: List<PocaPetroleo>) {
        this.id = tanqueProducao.codigo
        this.nome = tanqueProducao.nome
        var unidadeNegocioEntity = UnidadeNegocioEntity()
        unidadeNegocioEntity.fromUnidadeNegocio(tanqueProducao.unidadeNegocio)
        this.unidadeNegocio = unidadeNegocioEntity
        var ucsViculadasEntity = ucsVinculadas.map {convertUnidadeControleToUnidadeControleEntity(it)}
        this.pocasVinculadas = ucsViculadasEntity
    }

    private fun convertUnidadeControleToUnidadeControleEntity(uc: PocaPetroleo):PocaPetroleoEntity {
        var entity = (PocaPetroleoEntity())
        entity.fromUnidadeControle(uc)
        return entity
    }





}

