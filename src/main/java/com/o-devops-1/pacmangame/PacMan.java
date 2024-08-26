package com.o-devops-1.pacmangame;

public class PacMan {
    private static PacMan instance;
    private double x;
    private double y;
    private double speed;
    private boolean isMovingUp;
    private boolean isMovingDown;
    private boolean isMovingLeft;
    private boolean isMovingRight;

    private PacMan() {
        x = 200;
        y = 200;
        speed = 2;
    }

    public static PacMan getInstance() {
        if (instance == null) {
            instance = new PacMan();
        }
        return instance;
    }

    public void update() {
        if (isMovingUp) {
            y -= speed;
        } else if (isMovingDown) {
            y += speed;
        } else if (isMovingLeft) {
            x -= speed;
        } else if (isMovingRight) {
            x += speed;
        }
    }

    public void moveUp() {
        isMovingUp = true;
        isMovingDown = false;
        isMovingLeft = false;
        isMovingRight = false;
    }

    public void moveDown() {
        isMovingUp = false;
        isMovingDown = true;
        isMovingLeft = false;
        isMovingRight = false;
    }

    public void moveLeft() {
        isMovingUp = false;
        isMovingDown = false;
        isMovingLeft = true;
        isMovingRight = false;
    }

    public void moveRight() {
        isMovingUp = false;
        isMovingDown = false;
        isMovingLeft = false;
        isMovingRight = true;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean checkCollision(Ghost ghost) {
        // check collisions with ghost
        return false;
    }

    public boolean checkCollision(Circle pellet) {
        // check collision with pellet
        return false;
    }

    public void reset() {
        x = 200;
        y = 200;
        isMovingUp = false;
        isMovingDown = false;
        isMovingLeft = false;
        isMovingRight = false;
    }}
