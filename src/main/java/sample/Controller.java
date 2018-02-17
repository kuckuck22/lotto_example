package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Controller {

    @FXML
    private GridPane gridPaneMain;

    @FXML
    private HBox playBox;

    @FXML
    private HBox targetBox;

    @FXML
    private Label resultLabel;

    @FXML
    public void playButtonPressed() {
        List<Integer> pickedNumber = new ArrayList<>();

        for (Node node : gridPaneMain.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) node;
                if (checkBox.isSelected()) {
                    pickedNumber.add(Integer.valueOf(checkBox.getText()));
                }
            }
        }

        if (pickedNumber.size() != 7) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ungültige Eingabe");
            alert.setHeaderText("Du musst genau 7 Zahlen wählen");
            alert.showAndWait();
        }

        playGame(pickedNumber);
    }

    private void playGame(List<Integer> pickedNumbers) {
        NumberGenerator numberGenerator =  new NumberGenerator();
        List<Integer> gameNumbers = numberGenerator.getSevenOfFortyNine();

        playBox.getChildren().clear();
        targetBox.getChildren().clear();

        Collections.sort(gameNumbers);
        for (Integer n : gameNumbers) {
            playBox.getChildren().add(createLabel(n, false));
            playBox.getChildren().add(new Label(" "));

        }

        Collections.sort(pickedNumbers);
        for (Integer n : pickedNumbers) {
            targetBox.getChildren().add(createLabel(n, gameNumbers.contains(n)));
            targetBox.getChildren().add(new Label(" "));
        }


        long correctPics = pickedNumbers
                .stream()
                .filter(gameNumbers::contains)
                .count();

        resultLabel.setText(String.format("Du hast %s Richtige.", correctPics));

    }

    private Label createLabel(int number, boolean hit) {
        Label label = new Label(String.valueOf(number));
        if (hit) {
            label.setTextFill(Color.web("#00dc32"));
        }
        return label;
    }


}
