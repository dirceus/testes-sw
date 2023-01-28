package br.com.demo.infra.db.entities

import br.com.demo.business.domain.poco.Poco
import br.com.demo.business.domain.poco.StatusPocoEnum
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "POCO",
    uniqueConstraints = [UniqueConstraint(name="InstalacaoAndNome", columnNames = ["instalacao_id","nome"])])
class PocoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(nullable = false)
    var nome: String? = null

    @Column
    var descricao: String? = null

    @Column(nullable = false, name = "data_criacao")
    var dataCriacao: LocalDate? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "unidade_negocio_id")
    var unidadeNegocio: UnidadeNegocioEntity? = null

   @Column
   var status : String? = null

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "poco")
    var pocoHistorioStatus: List<PocoHistorioStatusEntity>? = null

    fun toPoco(instalacaoEntity: InstalacaoProducaoEntity? = null) : Poco{

        var poco = Poco(this.nome!!,
                        this.descricao,
                        this.unidadeNegocio!!.toUnidadeNegocio(),
                        this.dataCriacao!!
        )

        poco.codigo = this.id
        poco.status = StatusPocoEnum.valueOf(this.status!!)
        poco.historicoStatus = pocoHistorioStatus!!.map{it.toPocoHistoricoStatus()}
            .toMutableList()
        poco.instalacaoPoco = instalacaoEntity?.toInstalacaoProducao()
        return poco
    }

    fun fromPoco(poco : Poco){
        this.id = poco.codigo
        this.nome = poco.nome
        this.descricao = poco.descricao
        this.status = poco.status.codigo
        this.dataCriacao = poco.dataCriacao
        this.pocoHistorioStatus = poco.historicoStatus.map {
            var historico = PocoHistorioStatusEntity()
            historico.poco= this
            historico.id=it.codigo
            historico.status=it.status.codigo
            historico.dataFim=it.dataInicio
            historico.dataFim=it.dataFim
            historico
        }

    }

}