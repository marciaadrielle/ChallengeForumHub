package forum.hub.api.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastrotopicos(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        String autor,

        @NotNull
        Curso curso) {
}
