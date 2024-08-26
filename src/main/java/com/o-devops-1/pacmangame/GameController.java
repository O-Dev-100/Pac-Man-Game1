package com.o-devops-1.pacmangame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class GameController {
    @FXML
    private Button startButton;

    @FXML
    private Label scoreLabel;

    @FXML
    private Pane gamePane;

    private PacMan pacMan;
    private Ghost ghost;
    private ScoreManager scoreManager;
    private GraphicsManager graphicsManager;
    private SoundManager soundManager;

    public GameController() {
        pacMan = PacMan.getInstance();
        ghost = Ghost.getInstance();
        scoreManager = ScoreManager.getInstance();
        graphicsManager = GraphicsManager.getInstance();
        soundManager = SoundManager.getInstance();
    }

    @FXML
    public void startNewGame(ActionEvent event) {
        startButton.setDisable(true);
        scoreLabel.setText("Score: 0");
        scoreManager.resetScore();
        pacMan.reset();
        ghost.reset();
        graphicsManager.resetGame();
        startGameLoop();
    }

    private void startGameLoop() {
        new Thread(() -> {
            while (true) {
                Platform.runLater(() -> {
                    updateGame();
                });
                try {
                    Thread.sleep(16); // 60 FPS
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();}

    private void updateGame() {
        pacMan.update();
        ghost.update();
        checkCollisions();
        graphicsManager.updatePacManPosition(pacMan.getX(), pacMan.getY());
        graphicsManager.updateGhostPosition(ghost.getX(), ghost.getY());
    }

    private void checkCollisions() {
        if (pacMan.checkCollision(ghost)) {
            soundManager.playSoundEffect("collide_with_ghost.wav");
            startButton.setDisable(false);
        } else if (pacMan.checkCollision(graphicsManager.getPellet())) {
            soundManager.playSoundEffect("eat_pellet.wav");
            scoreManager.incrementScore(10);
            scoreLabel.setText("Score: " + scoreManager.getScore());
            graphicsManager.removePellet();
        } else if (pacMan.checkCollision(graphicsManager.getPowerPellet())) {
            soundManager.playSoundEffect("eat_power_pellet.wav");
            scoreManager.incrementScore(50);
            scoreLabel.setText("Score: " + scoreManager.getScore());
            graphicsManager.removePowerPellet();
        }}}
