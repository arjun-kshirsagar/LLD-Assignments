package com.example.game;

public class SpeedBoost extends CharacterDecorator {
    private int extraSpeed;

    public SpeedBoost(Character character, int extraSpeed) {
        super(character);
        this.extraSpeed = extraSpeed;
    }

    @Override
    public void move() {
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public int getSpeed() {
        return character.getSpeed() + extraSpeed;
    }
    
}
