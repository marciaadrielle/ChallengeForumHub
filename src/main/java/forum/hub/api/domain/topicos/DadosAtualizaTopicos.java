package forum.hub.api.domain.topicos;

import java.time.LocalDateTime;

public record DadosAtualizaTopicos(

        String titulo,
        String mensagem,
        Curso curso,
        LocalDateTime dataCriacao,
        Status status
) {
    public DadosAtualizaTopicos(Topicos topicos){
        this(
                topicos.getTitulo(),
                topicos.getMensagem(),
                topicos.getCurso(),
                topicos.getDataCriacao(),
                topicos.getStatus()

        );
}
}


