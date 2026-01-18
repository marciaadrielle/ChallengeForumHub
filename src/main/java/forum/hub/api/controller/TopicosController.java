package forum.hub.api.controller;


import forum.hub.api.topicos.*;
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
    public Page<DadosListagemTopico> listar(
            @RequestParam(required = false) Curso curso,
            @PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        Page<Topicos> page;
        if (curso != null){
            page = repository.findByCurso(curso, paginacao);
        } else{
            page = repository.findAll(paginacao);
        }
        return page.map(DadosListagemTopico::new);
    }

}
