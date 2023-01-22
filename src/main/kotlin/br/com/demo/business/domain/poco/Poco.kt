package br.com.demo.business.domain.poco

import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.instalacao.InstalacaoProducao
import java.time.LocalDate

data class Poco(
    val nome: String,
    var descricao: String? = null,
    val instalacao: InstalacaoProducao,
    val dataCriacao: LocalDate
){
    var codigo: Int? = null
    var status: StatusPocoEnum = StatusPocoEnum.NAO_OPERANDO
    var historicoStatus: MutableList<HistoricoStatusPoco> =
        mutableListOf(HistoricoStatusPoco(status = StatusPocoEnum.NAO_OPERANDO, dataInicio = this.dataCriacao,dataFim = null))

    fun alterarStatus(novoStatus: StatusPocoEnum, dataInicioNovoStatus: LocalDate){
        if(this.status == novoStatus){
            throw BusinessException("Poço já está no status ${novoStatus.descricao}")
        }
        if(dataInicioNovoStatus.isAfter(historicoStatus.maxOf{ it.dataInicio})){
            throw BusinessException("Data início {$dataInicioNovoStatus} é anterior a data do último status ${historicoStatus.maxOf{ it.dataInicio}}")
        }

        this.status = novoStatus
        var ultimoStatus = this.historicoStatus.filter { it.dataFim == null }
        if(ultimoStatus.size != 1){
            throw BusinessException("Histório de status está incopara o poco {${this.nome}}")
        }
        dataInicioNovoStatus.also { ultimoStatus[0].dataFim = it }
        historicoStatus.add(HistoricoStatusPoco(novoStatus,dataInicioNovoStatus, null ))
    }

}