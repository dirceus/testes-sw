package br.com.dirceu.kotlinComSpringBoot.infra.db.entities

import jakarta.persistence.*

@Entity
@Table(name = "ALOCACAO_DIARIA_RELATORIO")
class AlocacaoDiariaRelatorioErrosEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alocacao_diaria_id")
    val alocacaoDiariaEntity: AlocacaoDiariaEntity,

    @Column(nullable = false, name = "descricao_erro")
    val descricao: String

)