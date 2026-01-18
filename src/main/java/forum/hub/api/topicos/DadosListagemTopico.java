package forum.hub.api.topicos;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        String autor,
        Curso curso,
        LocalDateTime dataCriacao,
        Status status
) {
    public DadosListagemTopico(Topicos topicos){
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
