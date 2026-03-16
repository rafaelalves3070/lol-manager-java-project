
package br.com.rafa.lolmanager.repository;

import br.com.rafa.lolmanager.model.Champion;

import java.util.List;

public interface IChampionRepository {

    Champion save(Champion champion);

    Champion update(Champion champion);

    Champion findById(Long id);

    List<Champion> findAll();

    void delete(Long id);

    boolean existsByName(String nome);

    boolean existsByNameAndDifferentId(String nome, Long id);

}
