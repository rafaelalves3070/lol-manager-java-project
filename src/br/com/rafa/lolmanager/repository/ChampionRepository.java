
package br.com.rafa.lolmanager.repository;

import br.com.rafa.lolmanager.model.Champion;

import java.util.*;

public class ChampionRepository implements IChampionRepository {

    private static final Map<Long, Champion> database = new HashMap<>();
    private static Long currentId = 1L;

    @Override
    public Champion save(Champion champion) {

        champion.setId(currentId);

        database.put(currentId, champion);

        currentId++;

        return champion;
    }

    @Override
    public Champion update(Champion champion) {

        database.put(champion.getId(), champion);

        return champion;
    }

    @Override
    public Champion findById(Long id) {

        return database.get(id);
    }

    @Override
    public List<Champion> findAll() {

        return new ArrayList<>(database.values());
    }

    @Override
    public void delete(Long id) {

        database.remove(id);
    }

    @Override
    public boolean existsByName(String nome) {

        for (Champion c : database.values()) {

            if (c.getNome().equalsIgnoreCase(nome)) {
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean existsByNameAndDifferentId(String nome, Long id) {

        for (Champion c : database.values()) {

            if (c.getNome().equalsIgnoreCase(nome) && !c.getId().equals(id)) {
                return true;
            }

        }

        return false;
    }
}
