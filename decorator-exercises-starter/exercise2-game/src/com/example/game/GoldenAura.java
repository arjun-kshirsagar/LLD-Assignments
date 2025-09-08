package com.example.game;

public class GoldenAura extends CharacterDecorator {
    private int extraSpeed;
    private int extraDamage;

    public GoldenAura(Character character) {
        super(character);
        this.extraSpeed = 5;  // default speed boost
        this.extraDamage = 10; // default damage boost
    }

    private void displayAura() {
        System.out.println("A golden aura surrounds the character!");
    }

    @Override
    public void move() {
        displayAura();
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        displayAura();
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }

    @Override
    public int getSpeed() {
        return character.getSpeed() + extraSpeed;
    }

    @Override
    public int getDamage() {
        return character.getDamage() + extraDamage;
    }

    @Override
    public String getSprite() {
        return "golden.png";
    }
    
}
