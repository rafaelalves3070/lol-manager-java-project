
package br.com.rafa.lolmanager.service;

import br.com.rafa.lolmanager.model.Champion;
import br.com.rafa.lolmanager.model.ChampionClass;
import br.com.rafa.lolmanager.repository.IChampionRepository;

public class ChampionService {

    private IChampionRepository repository;

    public ChampionService(IChampionRepository repository) {
        this.repository = repository;
    }

    public void validateChampion(Champion champion) {

        if(champion == null)
            throw new RuntimeException("Campeão não pode ser nulo");

        if(champion.getNome() == null || champion.getNome().isEmpty())
            throw new RuntimeException("Nome obrigatório");

        if(champion.getDanoBase() < 0)
            throw new RuntimeException("Dano base inválido");

        if(champion.getVidaBase() < 0)
            throw new RuntimeException("Vida base inválida");

        if(champion.getDificuldade() < 1 || champion.getDificuldade() > 5)
            throw new RuntimeException("Dificuldade deve ser entre 1 e 5");

        if(champion.getClasse() == ChampionClass.MAGO && champion.getDanoBase() <= 50)
            throw new RuntimeException("Mago deve ter dano > 50");

        if(champion.getClasse() == ChampionClass.TANK && champion.getVidaBase() <= 500)
            throw new RuntimeException("Tank deve ter vida > 500");

        if(repository.existsByName(champion.getNome()))
            throw new RuntimeException("Nome já existe");
    }

    public void validateUpdate(Champion champion){

        if(repository.existsByNameAndDifferentId(champion.getNome(), champion.getId()))
            throw new RuntimeException("Outro campeão já possui esse nome");
    }

}
