package br.com.demo.business.features.boletimMedicaoDiaria

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.boletimMedicaoDiaria.BoletimMedicaoDiaria
import br.com.demo.business.domain.boletimMedicaoDiaria.BoletimMedicaoDiariaDTO
import br.com.demo.business.domain.boletimMedicaoDiaria.BoletimMedicaoDiariaRepository
import br.com.demo.business.domain.instalacao.InstalacaoProducaoRepository

class CadastrarBoletimMedicaoDiaria (private val boletimMedicaoDiariaRepository: BoletimMedicaoDiariaRepository,
                                     private val instalacaoRepository: InstalacaoProducaoRepository
) : FunciolidadeExecutavel<BoletimMedicaoDiariaDTO, Unit> {
    override fun executar(request: BoletimMedicaoDiariaDTO) {
        //verifica se a instalacao é valida
        val instalacao = instalacaoRepository.obter(request.codInstalacao)
            ?: throw BusinessException("Código da instalação é inválido")

        if (!instalacao.ativo) {
            throw BusinessException("Instalação está inativa")
        }

        boletimMedicaoDiariaRepository.obterBoletimMedicao(request.codInstalacao, request.data)
            ?: throw BusinessException("Já existe boletim da instalação ${instalacao.nome} para a data ${request.data}")

        val boletimMedicaoDiaria = BoletimMedicaoDiaria(instalacao, request.data, request.producao)
        boletimMedicaoDiariaRepository.salvar(boletimMedicaoDiaria)
    }
}