package forum.hub.api.domain.topicos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topicos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private String autor;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    private  Boolean ativo;

    public Topicos(DadosCadastrotopicos dados) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.dataCriacao = LocalDateTime.now();
        this.status = Status.ABERTO;
        this.curso =dados.curso();
    }


    public void atualizarInformacoes(@Valid DadosAtualizaTopicos dados) {

        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }

        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }

        if (dados.status() != null){
            this.status = dados.status();
        }

        if (dados.curso() != null) {
            this.curso = dados.curso();
        }


    }

    public void excluir() {
        this.ativo = false;
    }
}
