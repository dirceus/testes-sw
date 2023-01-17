package br.com.dirceu.kotlinComSpringBoot.infra.db.entities

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import jakarta.persistence.*
import org.hibernate.Hibernate
import java.util.*

@Entity
@Table(name = "UNIDADE_NEGOCIO")
class UnidadeNegocioEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    @Column(unique = true, nullable = false)
    var nome:String? = null

    @Column
    var descricao: String? = null

    @Column(nullable = false, name = "inicio_vigencia")
    var inicioVigencia: Date? = null

    @Column(nullable = true, name = "fim_vigencia")
    var fimVigencia: Date? = null

    @ManyToOne

    fun fromUnidadeNegocio(unidadeNegocio: UnidadeNegocio){
        this.id = unidadeNegocio.codigo
        this.nome = unidadeNegocio.nome
        this.descricao = unidadeNegocio.descricao
        this.inicioVigencia = unidadeNegocio.inicioVigencia
        this.fimVigencia = unidadeNegocio.fimVigencia
    }

    fun toUnidadeNegocio() : UnidadeNegocio {
        return UnidadeNegocio(this.id, this.nome!!, this.descricao, this.inicioVigencia!!, this.fimVigencia)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as UnidadeNegocioEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , nome = $nome)"
    }
}
