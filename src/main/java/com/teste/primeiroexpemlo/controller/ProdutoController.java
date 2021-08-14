package com.teste.primeiroexpemlo.controller;

import java.util.List;
import java.util.Optional;

import com.teste.primeiroexpemlo.model.Produto;
import com.teste.primeiroexpemlo.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController estamos dizendo para o controlador que essa é um classe controller
 * @requestMapping faz com que o controller escute somente a api/produtos
 */

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> obterTodos(){
        return produtoService.obterTodos();
    }

    /*GetMapping("/{id}") vai consegui pegar e vai trazer com base no id passado no final da url */
    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Integer id){
        return produtoService.obterPorId(id);
    }
    
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoService.adicionar(produto);
    }

    //ouve somente o verbo delete
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        produtoService.deletar(id);
        return ("Produto com id " + id + "foi deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id){
        return produtoService.atualizar(id, produto);
    }
}
