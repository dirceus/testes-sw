package br.com.demo.infra.db.entities

import br.com.demo.business.domain.boletimMedicaoDiaria.BoletimMedicaoDiaria
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "BOLETIM_MEDICAO_DIARIA",
    uniqueConstraints =
    [UniqueConstraint(name="instalcaoAndData", columnNames = ["instalacao_id","data"])])
class BoletimMedicaoDiariaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "instalacao_id")
    var instalacao : InstalacaoProducaoEntity? = null

    @Column(nullable = false)
    var data: LocalDate? = null

    @Column(nullable = false)
    var producao: Double? = null

    fun toBoletimMedicaoDiaria() : BoletimMedicaoDiaria {
        var boletim = BoletimMedicaoDiaria(
            this.instalacao!!.toInstalacaoProducao(),
            this.data!!,
            this.producao!!)
        boletim.codigo = this.id
        return boletim
    }

    fun fromBoletimMedicaoDiaria(boletim: BoletimMedicaoDiaria){
        this.id = boletim.codigo
        var instalacaoProducaoEntity = InstalacaoProducaoEntity()
        instalacaoProducaoEntity.id = boletim.instalacaoProducao.codigo
        this.instalacao = instalacaoProducaoEntity
        this.data = boletim.data
        this.producao = boletim.producao
    }


}