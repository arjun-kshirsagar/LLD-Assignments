package com.example.game;

public class DamageBoost extends CharacterDecorator {
    public int extraDamage;

    public DamageBoost(Character character, int extraDamage) {
        super(character);
        this.extraDamage = extraDamage;
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }

    @Override
    public int getDamage() {
        return character.getDamage() + extraDamage;
    }
    
}
