package br.com.demo.infra.db.entities

import jakarta.persistence.*

@Entity
@Table(name = "RELATORIO_PRODUCAO_DIA_ERROS")
class RelatorioProducaoDiariaErrosEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alocacao_diaria_id")
    val relatorioProducaoDiariaEntity: RelatorioProducaoDiariaEntity,

    @Column(nullable = false, name = "descricao_erro")
    val descricao: String

)