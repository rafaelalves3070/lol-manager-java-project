
package br.com.rafa.lolmanager.model;

public enum ChampionClass {

    MAGO(1),
    LUTADOR(2),
    ATIRADOR(3),
    TANK(4),
    SUPORTE(5);

    private int valor;

    ChampionClass(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }

    public static ChampionClass fromValor(int valor){

        for(ChampionClass c : ChampionClass.values()){
            if(c.valor == valor){
                return c;
            }
        }

        throw new RuntimeException("Classe inválida");
    }

}
