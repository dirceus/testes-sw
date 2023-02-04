package br.com.demo.infra.db.entities

import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocio
import jakarta.persistence.*
import org.hibernate.Hibernate

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

    @Column(nullable = false)
    var ativo: Boolean? = null


    fun fromUnidadeNegocio(unidadeNegocio: UnidadeNegocio){
        this.id = unidadeNegocio.codigo
        this.nome = unidadeNegocio.nome
        this.descricao = unidadeNegocio.descricao
        this.ativo = unidadeNegocio.ativa
    }

    fun toUnidadeNegocio() : UnidadeNegocio {
        var un = UnidadeNegocio(this.nome!!, this.descricao, this.ativo!!)
        un.codigo = this.id
        return un
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
