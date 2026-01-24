package forum.hub.api.domain.topicos;

import java.time.LocalDateTime;

public record DadosListagemTopicos(
        Long id,
        String titulo,
        String mensagem,
        String autor,
        Curso curso,
        LocalDateTime dataCriacao,
        Status status
) {
    public DadosListagemTopicos(Topicos topicos){
        this(
                topicos.getId(),
                topicos.getTitulo(),
                topicos.getMensagem(),
                topicos.getAutor(),
                topicos.getCurso(),
                topicos.getDataCriacao(),
                topicos.getStatus()

        );
    }
}
