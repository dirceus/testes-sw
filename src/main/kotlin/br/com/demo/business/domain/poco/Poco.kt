package br.com.demo.business.domain.poco

import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.instalacao.InstalacaoProducao
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocio
import java.time.LocalDate

data class Poco(
    val nome: String,
    var descricao: String? = null,
    var unidadeNegocio: UnidadeNegocio,
    val dataCriacao: LocalDate
){
    var codigo: Int? = null
    var status: StatusPocoEnum = StatusPocoEnum.NAO_OPERANDO
    var instalacaoPoco: InstalacaoProducao? = null
    var historicoStatus: MutableList<HistoricoStatusPoco> =
        mutableListOf(HistoricoStatusPoco(status = StatusPocoEnum.NAO_OPERANDO, dataInicio = this.dataCriacao,dataFim = null))

    fun alterarStatus(novoStatus: StatusPocoEnum, dataInicioNovoStatus: LocalDate){
        if(this.status == novoStatus){
            throw BusinessException("Poço já está no status ${novoStatus.descricao}")
        }
        val dataUltimoStatus = historicoStatus.maxOf{ it.dataInicio}
        if(dataInicioNovoStatus.isBefore(dataUltimoStatus) || dataInicioNovoStatus.isEqual(dataUltimoStatus)){
            throw BusinessException("Data início $dataInicioNovoStatus é anterior ou igual a data do último status $dataUltimoStatus")
        }

        this.status = novoStatus
        var ultimoStatus = this.historicoStatus.filter { it.dataFim == null }
        if(ultimoStatus.size != 1){
            throw BusinessException("Histório de status do poço  ${this.nome} está inconsistente")
        }
        dataInicioNovoStatus.also { ultimoStatus[0].dataFim = it }
        historicoStatus.add(HistoricoStatusPoco(novoStatus,dataInicioNovoStatus, null ))
    }

}