package forum.hub.api.controller;


import forum.hub.api.topicos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
public class TopicosController {

    @Autowired
    private TopicosRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarTopico(@RequestBody @Valid DadosCadastrotopicos dados){
        repository.save(new Topicos(dados));
    }



    @GetMapping
    public Page<DadosListagemTopicos> listar(
            @RequestParam(required = false) Curso curso,
            @PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        Page<Topicos> page;
        if (curso != null){
            page = repository.findByCurso(curso, paginacao);
        } else{
            page = repository.findAllByAtivoTrue(paginacao);
        }
        return page.map(DadosListagemTopicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaTopicos dados){
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopicos> detalhar(@PathVariable Long id) {
        return repository.findById(id)
                .map(t -> ResponseEntity.ok(new DadosDetalhamentoTopicos(t)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.excluir();
    }



}
