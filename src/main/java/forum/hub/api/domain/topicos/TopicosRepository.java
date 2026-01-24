package forum.hub.api.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicosRepository extends JpaRepository<Topicos, Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);
    Page<Topicos> findByCurso(Curso curso, Pageable pageable);

    Page<Topicos> findAllByAtivoTrue(Pageable paginacao);
}
