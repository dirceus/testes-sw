package br.com.demo.business.domain.poco

import br.com.demo.business.commons.exceptions.BusinessException

enum class StatusPocoEnum(val codigo: String, val descricao: String) {

    NAO_OPERANDO("NO", "Não Operando"),
    OPERANDO("OP", "Em operação"),
    MANUTENCAO("MA","Em manutenção");

    companion object {
        fun fromCodigo(codigo: String?): StatusPocoEnum {
            if (!codigo.isNullOrBlank()) {
                when (codigo) {
                    "NO" -> {
                        return NAO_OPERANDO
                    }

                    "OP" -> {
                        return OPERANDO
                    }

                    "MA" -> {
                        return MANUTENCAO
                    }
                }
            }
            throw BusinessException("Status de Poco Inválido")
        }
    }

}
