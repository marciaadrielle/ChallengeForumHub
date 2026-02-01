package forum.hub.api.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopicos(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        String autor,

        @NotNull
        Curso curso) {
}
