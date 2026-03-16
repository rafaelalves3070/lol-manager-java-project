
package br.com.rafa.lolmanager.model;

public class Champion {

    private Long id;
    private String nome;
    private ChampionClass classe;
    private int danoBase;
    private int vidaBase;
    private int dificuldade;

    public Champion(String nome, ChampionClass classe, int danoBase, int vidaBase, int dificuldade) {
        this.nome = nome;
        this.classe = classe;
        this.danoBase = danoBase;
        this.vidaBase = vidaBase;
        this.dificuldade = dificuldade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public ChampionClass getClasse() {
        return classe;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public int getVidaBase() {
        return vidaBase;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", classe=" + classe +
                ", danoBase=" + danoBase +
                ", vidaBase=" + vidaBase +
                ", dificuldade=" + dificuldade +
                '}';
    }
}
