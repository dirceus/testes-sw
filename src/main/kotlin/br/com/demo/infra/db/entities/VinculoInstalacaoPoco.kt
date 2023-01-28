package br.com.demo.infra.db.entities

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "VINCULO_INSTALACAO_POCO")
class VinculoInstalacaoPoco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instalacao_id")
    var instalacaoProducao: InstalacaoProducaoEntity? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "poco_id")
    var poco: PocoEntity? = null

    @Column(nullable = false, name = "data_inicio")
    var dataInicio: LocalDate? = null

    @Column(name = "data_fim")
    var dataFim: LocalDate? = null

}