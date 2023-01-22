package br.com.demo.infra.db.entities

import br.com.demo.business.domain.poco.HistoricoStatusPoco
import br.com.demo.business.domain.poco.StatusPocoEnum
import jakarta.persistence.*
import java.time.LocalDate

class PocoHistorioStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(nullable = false)
    var status: String? = null

    @Column(nullable = false, name = "data_inicio")
    var dataInicio: LocalDate? = null

    @Column(name = "data_fimo")
    var dataFim: LocalDate? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "poco_id")
    var poco: PocoEntity? = null


    fun toPocoHistoricoStatus(): HistoricoStatusPoco{
        var historico =
            HistoricoStatusPoco(StatusPocoEnum.valueOf(this.status!!),
                this.dataInicio!!,
                this.dataFim)
        historico.codigo = this.id
        return historico
    }



}