import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GraphicsManager {
    private Pane gamePane;
    private Circle pellet;
    private Circle powerPellet;

    public GraphicsManager(Pane gamePane) {
        this.gamePane = gamePane;
        createPellet(150, 150, 5, Color.WHITE);
        createPowerPellet(250, 250, 10, Color.RED);
    }

    private void createPellet(double x, double y, double radius, Color color) {
        pellet = new Circle(x, y, radius);
        pellet.setFill(color);
        gamePane.getChildren().add(pellet);
    }

    private void createPowerPellet(double x, double y, double radius, Color color) {
        powerPellet = new Circle(x, y, radius);
        powerPellet.setFill(color);
        gamePane.getChildren().add(powerPellet);
    }

    public Circle getPellet() {
        return pellet;
    }

    public Circle getPowerPellet() {
        return powerPellet;
    }

    public void removePellet() {
        gamePane.getChildren().remove(pellet);
        createPellet(150, 150, 5, Color.WHITE);
    }

    public void removePowerPellet() {
        gamePane.getChildren().remove(powerPellet);
        createPowerPellet(250, 250, 10, Color.RED);
    }

    public void updatePacManPosition(double x, double y) {
        // Update Pac-Man's position on the game pane
    }

    public void updateGhostPosition(double x, double y) {
        // Ghost's position this time
    }

    public void resetGame() {
        // reset the game graphics
        gamePane.getChildren().clear();
        createPellet(150, 150, 5, Color.WHITE);
        createPowerPellet(250, 250, 10, Color.RED);
    }}
