package forum.hub.api.controller;


import forum.hub.api.topicos.DadosCadastrotopicos;
import forum.hub.api.topicos.DadosListagemTopico;
import forum.hub.api.topicos.Topicos;
import forum.hub.api.topicos.TopicosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Page<DadosListagemTopico> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        return repository.findAll(paginacao)
                .map(DadosListagemTopico::new);
    }

}
