import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Controller {

    @FXML
    private Pane drawinPane;

    @FXML
    private RadioButton black;

    @FXML
    private ToggleGroup colorToggleGroup;

    @FXML
    private RadioButton red;

    @FXML
    private RadioButton green;

    @FXML
    private RadioButton blue;

    @FXML
    private RadioButton small;

    @FXML
    private ToggleGroup sizeToggleGroup;

    @FXML
    private RadioButton medium;

    @FXML
    private RadioButton large;

    @FXML
    private Button undo;

    @FXML
    private Button clear;

    private enum PenSize {
      SMALL(2),
      MEDIUM(4),
      LARGE(6);

      private final int radius;

      PenSize(int radius) {this.radius = radius;}

      public int getRadius() {return radius;}
    }

    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;

    public void initialize() {
      black.setUserData(Color.BLACK);
      red.setUserData(Color.RED);
      green.setUserData(Color.GREEN);
      blue.setUserData(Color.BLUE);
      small.setUserData(PenSize.SMALL);
      medium.setUserData(PenSize.MEDIUM);
      large.setUserData(PenSize.LARGE);
    }

    @FXML
    void onMouseDragged(MouseEvent event) {
      Circle circle = new Circle(event.getX(), event.getY(), radius.getRadius(), brushColor);
      drawinPane.getChildren().add(circle);
    }

    @FXML
    void clearButtonClicked(MouseEvent event) {
      drawinPane.getChildren().clear();
    }

    @FXML
    void colorButtonClicked(MouseEvent event) {
      brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void sizeButtonClicked(MouseEvent event) {
      radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void undoButtonClicked(MouseEvent event) {
      int size = drawinPane.getChildren().size();
      if (size > 0)
        drawinPane.getChildren().remove(size - 1);
    }


}
