package com.marcelo.api_basica.Controller;

import com.marcelo.api_basica.Model.Produto;
import com.marcelo.api_basica.Repository.IProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping("/buscar/todos")
    public List<Produto> bustarTodos(){
        return produtoRepository.findAll();
    }
    @GetMapping("/buscar/{id}")
    public Produto buscarPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);


    }

    @DeleteMapping("/deletar/{id}")
    public String Deletar(@PathVariable("id") String id){
        var produto = produtoRepository.findById(id).orElse(null);

        if(produto != null){
            produtoRepository.delete(produto);
            return "produto deletado com sucesso";
        }
        return "produto nao encontrado";

    }
    @PutMapping("/atualizar/{id}")
    public Produto Atualizar(@PathVariable("id") String id,
                             @RequestBody Produto produto){
        var produtoId = produtoRepository.findById(id).orElse(null);
        if(produtoId != null && produtoId.equals(id)){
            produtoRepository.save(produto);
        }
        return produto;
    }

}




