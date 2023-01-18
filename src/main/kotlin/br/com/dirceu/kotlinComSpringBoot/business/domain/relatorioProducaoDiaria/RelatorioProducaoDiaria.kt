package br.com.dirceu.kotlinComSpringBoot.business.domain.relatorioProducaoDiaria

import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.tanqueProducao.InfoRateioProducaoDTO
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import java.util.*

data class RelatorioProducaoDiaria(
    val codigo: Int?,
    val unidadeNegocio : UnidadeNegocio,
    val data: Date,
    var totalVolume: Double? = null,
    var producaoPorPoca: MutableList<RelatorioProducaoDiariaPorPocaPetroleo> = mutableListOf(),
    var status: StatusRelatorioDiarioEnum = StatusRelatorioDiarioEnum.NAO_PROCESSADA,
    var erros: MutableList<String> = mutableListOf()
){

    fun processar(lista : List<InfoRateioProducaoDTO>) {
        for( dto in lista){
            if(dto.producaoDia.producao <= 0.00){
                erros.add("O Nó ${dto.producaoDia.tanqueProducao.nome} não possui produção válida para ser rateada entre as unidades de controle")
                continue
            }
            val ucsDestino = dto.pocasPetroleo
            val ucsDestinoVigentes = ucsDestino.filter { it.vigenteNaData(data) }
            if(ucsDestinoVigentes.isEmpty()){
                this.erros
                    .add("Não há ucs ativas vinculadas ao Nó ${dto.producaoDia.tanqueProducao.nome}")
            }
            val valorPorUC = dto.producaoDia.producao / ucsDestinoVigentes.size
            var volumeParaDistribuicao = dto.producaoDia.producao
            for(uc in ucsDestinoVigentes){
                val producaoUC = if(volumeParaDistribuicao < valorPorUC * 2) {
                    volumeParaDistribuicao
                }else{
                    valorPorUC
                }
                val alocacao = RelatorioProducaoDiariaPorPocaPetroleo(null, data, producaoUC, uc )
                volumeParaDistribuicao -= valorPorUC
                this.producaoPorPoca.add(alocacao)
            }
            if(volumeParaDistribuicao > 0.0){
                erros.add("A distribuição da produção do Nó ${dto.producaoDia.tanqueProducao.nome} não foi distribuído corretamente")
                continue
            }
        }
        this.status = if(erros.isEmpty()) {
            StatusRelatorioDiarioEnum.PROCESSADA_SUCESSO
        }else{
            StatusRelatorioDiarioEnum.PROCESSADA_FALHA
        }
    }

}

