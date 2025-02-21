package com.marcelo.api_basica.Controller;

import com.marcelo.api_basica.Model.Produto;
import com.marcelo.api_basica.Repository.IProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {


    private IProdutoRepository produtoRepository;

    public ProdutoController(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/criar")
    public Produto salvar(@RequestBody Produto produto){
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);

        return produto;
    }
}
