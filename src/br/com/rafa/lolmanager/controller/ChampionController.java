
package br.com.rafa.lolmanager.controller;

import br.com.rafa.lolmanager.model.*;
import br.com.rafa.lolmanager.repository.*;
import br.com.rafa.lolmanager.service.*;

import java.util.List;

public class ChampionController {

    private IChampionRepository repository;
    private ChampionService service;

    public ChampionController(){

        this.repository = new ChampionRepository();
        this.service = new ChampionService(repository);

    }

    public Champion criarChampion(String nome, int classe, int danoBase, int vidaBase, int dificuldade){

        ChampionClass championClass = ChampionClass.fromValor(classe);

        Champion champion = new Champion(nome, championClass, danoBase, vidaBase, dificuldade);

        service.validateChampion(champion);

        return repository.save(champion);
    }

    public Champion updateChampion(Long id, String nome, int classe, int danoBase, int vidaBase, int dificuldade){

        ChampionClass championClass = ChampionClass.fromValor(classe);

        Champion champion = new Champion(nome, championClass, danoBase, vidaBase, dificuldade);

        champion.setId(id);

        service.validateUpdate(champion);

        return repository.update(champion);
    }

    public Champion getChampionById(Long id){

        return repository.findById(id);
    }

    public List<Champion> listChampions(){

        return repository.findAll();
    }

    public void deleteChampion(Long id){

        repository.delete(id);
    }

}
