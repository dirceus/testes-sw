package br.com.demo.infra.db.specifcations.instalacao

import br.com.demo.infra.db.entities.InstalacaoProducaoEntity
import br.com.demo.infra.db.entities.UnidadeNegocioEntity
import org.springframework.data.jpa.domain.Specification

class InstalacaoSpecification(
    var nome: String? = null, var codigoUn: Int? = null, var ativo : Boolean? = null)
{

    fun build() : Specification<InstalacaoProducaoEntity>{
        return this.contemNome(this.nome)
            .and(contemUnidadeNegocio(this.codigoUn))
            .and(contemStatus(this.ativo))
    }

    private fun contemNome(nome: String?): Specification<InstalacaoProducaoEntity> {
        return Specification<InstalacaoProducaoEntity> { root, _, builder ->
            if (!nome.isNullOrBlank()) {
                builder.like(builder.lower(root.get("nome")), "%${nome.lowercase()}%")
            } else {
                null
            }
        }
    }

    private fun contemUnidadeNegocio(codigoUn: Int?): Specification<InstalacaoProducaoEntity> {
        return Specification<InstalacaoProducaoEntity> {
                root, _, builder ->
            if(codigoUn != null) {
                builder.equal(
                    root.join<InstalacaoProducaoEntity, UnidadeNegocioEntity>("unidadeNegocio").get<Int>("id"), codigoUn
                )
            }else{
                null
            }
        }
    }

    private fun contemStatus(ativo: Boolean?): Specification<InstalacaoProducaoEntity> {
        return Specification<InstalacaoProducaoEntity> { root, _, builder ->
            if (ativo != null) {
                builder.equal(root.get<Boolean>("ativo"),ativo)
            } else {
                null
            }
        }
    }






}