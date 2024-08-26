package com.o-devops-1.pacmangame;

import javafx.scene.media.AudioClip;

public class SoundManager {
    private static SoundManager instance;
    private AudioClip eatPelletSound;
    private AudioClip eatPowerPelletSound;
    private AudioClip collideWithGhostSound;

    private SoundManager() {
        eatPelletSound = new AudioClip("eat_pellet.wav");
        eatPowerPelletSound = new AudioClip("eat_power_pellet.wav");
        collideWithGhostSound = new AudioClip("collide_with_ghost.wav");
    }

    public static SoundManager getInstance() {
        if (instance == null) {
            instance = new SoundManager();
        }
        return instance; }

    public void playSoundEffect(String soundEffect) {
        switch (soundEffect) {
            case "eat_pellet.wav":
                eatPelletSound.play();
                break;
            case "eat_power_pellet.wav":
                eatPowerPelletSound.play();
                break;
            case "collide_with_ghost.wav":
                collideWithGhostSound.play();
                break;
        } }}
