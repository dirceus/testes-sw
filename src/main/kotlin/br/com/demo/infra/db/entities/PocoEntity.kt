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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instalacao_id")
    var instalacaoProducao: InstalacaoProducaoEntity? = null

    @Column
    var descricao: String? = null

    @Column(nullable = false, name = "data_criacao")
    var dataCriacao: LocalDate? = null

   @Column
   var status : String? = null

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "poco")
    var pocoHistorioStatus: List<PocoHistorioStatusEntity>? = null

    fun toPoco() : Poco{
        val instalacaoProducao = this.instalacaoProducao!!.toInstalacaoProducao()
        var poco = Poco(this.nome!!,this.descricao,instalacaoProducao,this.dataCriacao!!)
        poco.codigo = this.id
        poco.status = StatusPocoEnum.valueOf(this.status!!)
        poco.historicoStatus = pocoHistorioStatus!!.map{it.toPocoHistoricoStatus()}
            .toMutableList()
        return poco
    }

    fun fromPoco(poco : Poco){
        this.id = poco.codigo
        this.nome = poco.nome
        this.descricao = poco.descricao
        val instalacaoEntity = InstalacaoProducaoEntity()
        instalacaoEntity.fromInstalacaoProducao(poco.instalacao)
        this.instalacaoProducao = instalacaoEntity
        this.status = poco.status.codigo
        this.dataCriacao = poco.dataCriacao
        this.pocoHistorioStatus = poco.historicoStatus.map {
            var historico = PocoHistorioStatusEntity()
            historico.poco= this
            historico.id=it.codigo
            historico.status=it.status.codigo
            historico.dataFim=it.dataInicio
            historico.dataFim=it.dataInicio
            historico
        }

    }

}