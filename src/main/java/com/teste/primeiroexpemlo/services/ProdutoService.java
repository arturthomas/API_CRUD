package com.teste.primeiroexpemlo.services;

//#region Importações
import java.util.List;
import java.util.Optional;

import com.teste.primeiroexpemlo.model.Produto;
import com.teste.primeiroexpemlo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  o @Service faz com que a classe seja uma classe de serviços
 */
//#endregion

@Service
public class ProdutoService {
    
    @Autowired //inverte o controle das dependencia, neste caso as dependencia estão na estancia do repository
    private ProdutoRepository produtoRepository;

    /**
     * Metodo para retornar uma lista de produtos.
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
        
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id.
     *
     * @param id do produto que será localizado.
     * @return retorna um produto caso seja encontrado.
     */
    /**
     * Optional é uma biblioteca do java e serve para não retornar erro caso nenhum item seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

     /**
     * Metodo para adicionar Produto na lista.
     * @param produto que será adicionado.
     * @return produto que será retornado
     */
    public Produto adicionar(Produto produto){
        //Aqui poderia ter alguma regra de negocio aqui para validar o produto.
        return produtoRepository.adicionar(produto);
    }
        /**
     * Metodo para deletar o produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        //aqui poderia ter alguma logia de validação.
        //exemplo de o usuario tem permisão para deletar
        produtoRepository.deletar(id);
    }
     /**
     * Metodo para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @return Retorna o produto após atualiar a lista.
     * @param id do produto.
     */

    public Produto atualizar(Integer id, Produto produto){
        //aqui poderia ter alguma validação do id
        produto.setId(id);
        return produtoRepository.atualizar(produto);

    }

}
