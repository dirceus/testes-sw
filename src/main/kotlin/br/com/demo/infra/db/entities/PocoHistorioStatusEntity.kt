package br.com.demo.infra.db.entities

import br.com.demo.business.domain.poco.HistoricoStatusPoco
import br.com.demo.business.domain.poco.StatusPocoEnum
import jakarta.persistence.*
import java.time.LocalDate
@Entity
@Table(name="POCO_HISTORICO_STATUS")
class PocoHistorioStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(nullable = false)
    var status: String? = null

    @Column(nullable = false, name = "data_inicio")
    var dataInicio: LocalDate? = null

    @Column(name = "data_fim")
    var dataFim: LocalDate? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "poco_id")
    var poco: PocoEntity? = null


    fun toPocoHistoricoStatus(): HistoricoStatusPoco{
        val historico =
            HistoricoStatusPoco(StatusPocoEnum.fromCodigo(this.status),
                this.dataInicio!!,
                this.dataFim)
        historico.codigo = this.id
        return historico
    }



}