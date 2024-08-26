package com.o-devops-1.pacmangame;

public class Ghost {
    private static Ghost instance;
    private double x;
    private double y;
    private double speed;

    private Ghost() {
        x = 300;
        y = 300;
        speed = 1;
    }

    public static Ghost getInstance() {
        if (instance == null) {
            instance = new Ghost();
        }
        return instance;
    }

    public void update() {
        // Simple AI to chase Pac-Man
        if (x < PacMan.getInstance().getX()) {
            x += speed;
        } else if (x > PacMan.getInstance().getX()) {
            x -= speed;
        }
        if (y < PacMan.getInstance().getY()) {
            y += speed;
        } else if (y > PacMan.getInstance().getY()) {
            y -= speed;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void reset() {
        x = 300;
        y = 300;
    }
}
