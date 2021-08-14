package com.teste.primeiroexpemlo.repository;
//#region Importações
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.teste.primeiroexpemlo.model.Produto;
import com.teste.primeiroexpemlo.model.exception.ResourceNotFoundException;

import org.springframework.stereotype.Repository;
//#endregion

@Repository
public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Retonar uma lista de produtos. No caso a lista que foi criada a cima List< Produto>
     * @return Lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
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
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Metodo para adicionar Produto na lista.
     * @param produto que será adicionado.
     * @return produto que será retornado
     */
    public Produto adicionar(Produto produto){

        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;

    }

    /**
     * Metodo para deletar o produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @return Retorna o produto após atualiar a lista.
     */

    public Produto atualizar(Produto produto){
        //primeiro precisa encontrar para renover o produto para depois cadastrar um novo
        // Eu tenho que remover o produto antigo da lista.
        // Depois adicionar o novo produto.
        Optional<Produto> produtoEncontrar = obterPorId(produto.getId());//reaproveitando codigo do obter do metodo obter produto.
        if(produtoEncontrar.isEmpty()){
            throw new ResourceNotFoundException("Produto não encontrado.");
            //throw cria uma exeção e mostra uma mensagem caso não encontre o produto.
        }
        deletar(produto.getId());
        //reaproveitando o metodo deletar para deletar o id do produto encontrado.

        //Acionar o produto atualizado na lista.
        produtos.add(produto);
        //desssa formas só é utilizado o atributo add do metodo adicionar
        return produto; 
    }
}