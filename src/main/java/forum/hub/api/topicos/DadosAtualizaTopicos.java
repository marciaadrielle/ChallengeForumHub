package forum.hub.api.topicos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizaTopicos(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        Curso curso,
        LocalDateTime dataCriacao,
        Status status
) {
    public DadosAtualizaTopicos(Topicos topicos){
        this(
                topicos.getId(),
                topicos.getTitulo(),
                topicos.getMensagem(),
                topicos.getCurso(),
                topicos.getDataCriacao(),
                topicos.getStatus()

        );
}
}


