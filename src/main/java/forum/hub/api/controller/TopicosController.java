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
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicosController {

    @Autowired
    private TopicosRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastrotopicos dados, UriComponentsBuilder uriBuilder){
        var topico = new Topicos(dados);
        repository.save(topico);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopicos(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listar(
            @RequestParam(required = false) Curso curso,
            @PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        Page<Topicos> page;
        if (curso != null){
            page = repository.findByCurso(curso, paginacao);
        } else{
            page = repository.findAllByAtivoTrue(paginacao);
        }
        return ResponseEntity.ok(page.map(DadosListagemTopicos::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaTopicos dados){
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTopicos(topico));

    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopicos> detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopicos(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.excluir();
        return ResponseEntity.noContent().build();
    }



}
