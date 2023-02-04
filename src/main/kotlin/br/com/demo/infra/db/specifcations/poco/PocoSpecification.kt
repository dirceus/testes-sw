package br.com.demo.infra.db.specifcations.poco

import br.com.demo.business.domain.poco.StatusPocoEnum
import br.com.demo.infra.db.entities.InstalacaoProducaoEntity
import br.com.demo.infra.db.entities.PocoEntity
import br.com.demo.infra.db.entities.UnidadeNegocioEntity
import org.springframework.data.jpa.domain.Specification

class PocoSpecification(
    var nome: String? = null, var codigoUn: Int? = null, var codigoInstalacao : Int? = null, var status: StatusPocoEnum? = null)
{

    fun build() : Specification<PocoEntity>{
        return this.contemNome(this.nome)
            .and(contemUnidadeNegocio(this.codigoUn))
            .and(contemStatus(status))

    }

    private fun contemNome(nome: String?): Specification<PocoEntity> {
        return Specification<PocoEntity> { root, _, builder ->
            if (!nome.isNullOrBlank()) {
                builder.like(builder.lower(root.get("nome")), "%${nome.lowercase()}%")
            } else {
                null
            }
        }
    }

    private fun contemUnidadeNegocio(codigoUn: Int?): Specification<PocoEntity> {
        return Specification<PocoEntity> {
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

    private fun contemStatus(status: StatusPocoEnum?): Specification<PocoEntity> {
        return Specification<PocoEntity> { root, _, builder ->
            if (status != null) {
                builder.equal(root.get<String>("status"),status.codigo)
            } else {
                null
            }
        }
    }






}