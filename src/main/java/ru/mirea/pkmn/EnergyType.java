package ru.mirea.pkmn;

public enum EnergyType {
    FIRE("FIRE"),
    GRASS("GRASS"),
    WATER("WATER"),
    LIGHTNING("LIGHTNING"),
    PHYSIC("PHYSIC"),
    FIGHTING("FIGHTING"),
    DARKNESS("DARCNESS"),
    METALL("METALL"),
    FAIRY("FAIRY"),
    DRAGON("DRAGON"),
    COLORLESS("COLORLESS");

    String enty;

    EnergyType(String enty) {
        this.enty = enty;
    }

    EnergyType() {
    }

    public String getEnty() {
        return enty;
    }

    @Override
    public String toString() {
        return enty;
    }
}
