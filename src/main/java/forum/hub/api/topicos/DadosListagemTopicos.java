package forum.hub.api.topicos;

import java.time.LocalDateTime;

public record DadosListagemTopicos(
        String titulo,
        String mensagem,
        String autor,
        Curso curso,
        LocalDateTime dataCriacao,
        Status status
) {
    public DadosListagemTopicos(Topicos topicos){
        this(
                topicos.getTitulo(),
                topicos.getMensagem(),
                topicos.getAutor(),
                topicos.getCurso(),
                topicos.getDataCriacao(),
                topicos.getStatus()

        );
    }
}
