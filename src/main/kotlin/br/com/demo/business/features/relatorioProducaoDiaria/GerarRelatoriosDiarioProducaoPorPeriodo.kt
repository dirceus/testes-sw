package br.com.demo.business.features.relatorioProducaoDiaria

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.boletimMedicaoDiaria.BoletimMedicaoDiariaRepository
import br.com.demo.business.domain.instalacao.InstalacaoProducaoRepository
import br.com.demo.business.domain.relatorioProducaoDiaria.RelatorioExecucaoDTO
import br.com.demo.business.domain.relatorioProducaoDiaria.RelatorioProducaoDiaria
import br.com.demo.business.domain.relatorioProducaoDiaria.RelatorioProducaoDiariaRepository
import br.com.demo.business.domain.relatorioProducaoDiaria.RequisicaoProcessarRelatoriosDTO
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository
import org.springframework.stereotype.Service
import java.time.temporal.ChronoUnit

@Service
class GerarRelatoriosDiarioProducaoPorPeriodo (
    private val relatorioProducaoDiariaRepository: RelatorioProducaoDiariaRepository,
    private val instalacaoProducaoRepository: InstalacaoProducaoRepository,
    private val unidadeNegocioRepository: UnidadeNegocioRepository,
    private val boletimMedicaoDiariaRepository: BoletimMedicaoDiariaRepository,
) : FunciolidadeExecutavel<RequisicaoProcessarRelatoriosDTO, RelatorioExecucaoDTO> {

    override fun executar(request: RequisicaoProcessarRelatoriosDTO): RelatorioExecucaoDTO {

        //Validar e obter un
        val unidadeNegocio = unidadeNegocioRepository.obterPorCodigo(request.codUn)
            ?: throw BusinessException("O codigo ${request.codUn} da Unidade de Negócio é inválido")

        //variaveis para o processamento
        val dataFinal = request.dataTermino?: request.dataInicio
        if(dataFinal.isBefore(request.dataInicio)){
            throw BusinessException("Data inicial não pode ser posterior a data final")
        }
        //periodo máximo para processamento: 31 dias
        if(ChronoUnit.DAYS.between(request.dataInicio, dataFinal) > 31){
            throw BusinessException("A quantidade de dias para processamento não pode ser superior a 31 dias")
        }


        val qtddInstalacoes = instalacaoProducaoRepository.quantidadeInstalacoesAtivas(request.codUn)

        var dataParaProcessar = request.dataInicio
        val relatorioExecucao = RelatorioExecucaoDTO()

        do {
            val boletins = boletimMedicaoDiariaRepository.obterBoletinsMedicao(request.codUn,dataParaProcessar)
            var relatorioProducaoDiaria = RelatorioProducaoDiaria(unidadeNegocio,dataParaProcessar)
            if(qtddInstalacoes == boletins.size){
                relatorioProducaoDiaria.processarDados(boletins)
            }else{
                relatorioProducaoDiaria.processarComFalha("Faltam boletins diário para data")
            }
            relatorioProducaoDiariaRepository.salvar(relatorioProducaoDiaria)
            relatorioExecucao.addResultaado(dataParaProcessar,relatorioProducaoDiaria.status)
            dataParaProcessar.plusDays(1)
        } while (dataFinal.isAfter(dataParaProcessar))

        return relatorioExecucao

    }

}