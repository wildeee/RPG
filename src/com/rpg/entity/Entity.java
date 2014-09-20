package com.rpg.entity;

public abstract class Entity {
    protected Integer handle;
    
    private static Integer handleCount = 0;

    public Entity() {
        this.handle = ++Entity.handleCount;
    }
    
    
}
