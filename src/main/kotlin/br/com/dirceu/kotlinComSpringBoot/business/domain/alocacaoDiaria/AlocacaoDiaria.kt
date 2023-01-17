package br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.commons.dto.noSip.NoProducaoParaProcessamentoDTO
import java.util.*

data class AlocacaoDiaria(
    val codigo: Int?,
    val unidadeNegocio : UnidadeNegocio,
    val dataAlocacao: Date,
    var totalVolume: Double? = null,
    var alocacoesPorUC: MutableList<AlocacaoDiariaPorUC> = mutableListOf(),
    var status: StatusAlocacaoDiariaEnum = StatusAlocacaoDiariaEnum.NAO_PROCESSADA,
    var relatorioErros: MutableList<String> = mutableListOf()
){

    fun processar(lista : List<NoProducaoParaProcessamentoDTO>) {
        for( dto in lista){
            if(dto.noProducaoSip.producao <= 0.00){
                relatorioErros.add("O Nó ${dto.noProducaoSip.noSip.nome} não possui produção válida para ser rateada entre as unidades de controle")
                continue
            }
            val ucsDestino = dto.ucsDestino
            val ucsDestinoVigentes = ucsDestino.filter { it.vigenteNaData(dataAlocacao) }
            if(ucsDestinoVigentes.isEmpty()){
                this.relatorioErros
                    .add("Não há ucs ativas vinculadas ao Nó ${dto.noProducaoSip.noSip.nome}")
            }
            val valorPorUC = dto.noProducaoSip.producao / ucsDestinoVigentes.size
            var volumeParaDistribuicao = dto.noProducaoSip.producao
            for(uc in ucsDestinoVigentes){
                val producaoUC = if(volumeParaDistribuicao < valorPorUC * 2) {
                    volumeParaDistribuicao
                }else{
                    valorPorUC
                }
                val alocacao = AlocacaoDiariaPorUC(null, dataAlocacao, producaoUC, uc )
                volumeParaDistribuicao -= valorPorUC
                this.alocacoesPorUC.add(alocacao)
            }
            if(volumeParaDistribuicao > 0.0){
                relatorioErros.add("A distribuição da produção do Nó ${dto.noProducaoSip.noSip.nome} não foi distribuído corretamente")
                continue
            }
        }
        this.status = if(relatorioErros.isEmpty()) {
            StatusAlocacaoDiariaEnum.PROCESSADA_SUCESSO
        }else{
            StatusAlocacaoDiariaEnum.PROCESSADA_FALHA
        }
    }

}

