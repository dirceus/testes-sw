package br.com.demo.business.commons

import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

interface FunciolidadeExecutavel<in Request, out Response> {
    fun executar(request: Request): Response
}

interface ExecutorFuncionalidade {
    operator fun <RequestDto, ResponseDto, Request, Response> invoke(
        funcionalidade: FunciolidadeExecutavel<Request, Response>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Request,
        responseConverter: (Response) -> ResponseDto
    ): CompletionStage<ResponseDto>

    operator fun <RequestDto, Request> invoke(
        funcionalidade: FunciolidadeExecutavel<Request, Unit>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Request
    ) =
        invoke(funcionalidade, requestDto, requestConverter) {}

    operator fun invoke(funcionalidade: FunciolidadeExecutavel<Unit, Unit>) =
        invoke(funcionalidade, Unit) { }

    operator fun <ResponseDto, Response> invoke(
        funcionalidade: FunciolidadeExecutavel<Unit, Response>,
        responseConverter: (Response) -> ResponseDto
    ) =
        invoke(funcionalidade, Unit, { }, responseConverter)
}

@Service
class ExecutorFuncionalidadeImp : ExecutorFuncionalidade {

    override operator fun <RequestDto, ResponseDto, Request, Response> invoke(
        funcionalidade: FunciolidadeExecutavel<Request, Response>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Request,
        responseConverter: (Response) -> ResponseDto
    ): CompletionStage<ResponseDto> =
        CompletableFuture
            .supplyAsync { requestConverter(requestDto) }
            .thenApplyAsync { funcionalidade.executar(it) }
            .thenApplyAsync { responseConverter(it) }
}

