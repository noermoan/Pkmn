package ru.mirea.pkmn;

public enum PokemonStage {
    BASIC("BASIC"),
    STAGE1("STAGE1"),
    STAGE2("STAGE2"),
    VSTAR("VSTAR"),
    VMAX("VMAX");

    private String pokSt;

    PokemonStage(String pokSt) {
        this.pokSt = pokSt;
    }

    public void setPokSt(String pokSt) {
        this.pokSt = pokSt;
    }
    public String getPokSt() {
        return pokSt;
    }

    @Override
    public String toString() {
        return "Стадия покемона: " + pokSt;
    }


}
