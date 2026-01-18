package forum.hub.api.controller;


import forum.hub.api.topicos.DadosCadastrotopicos;
import forum.hub.api.topicos.Topicos;
import forum.hub.api.topicos.TopicosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
