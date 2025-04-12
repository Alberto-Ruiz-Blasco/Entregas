package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField display; // Campo para mostrar el resultado

    private double firstNumber = 0;    // Primer número
    private String operation = "";    // Operación (suma, resta, etc.)
    private boolean isNewInput = true; // Controla el reinicio tras una operación

    @FXML
    private void handleNumber(javafx.event.ActionEvent event) {
        String number = ((javafx.scene.control.Button) event.getSource()).getText();
        if (isNewInput) {
            display.setText(number);
            isNewInput = false;
        } else {
            display.setText(display.getText() + number);
        }
    }

    @FXML
    private void handleOperation(javafx.event.ActionEvent event) {
        firstNumber = Double.parseDouble(display.getText());
        operation = ((javafx.scene.control.Button) event.getSource()).getText();
        isNewInput = true;
    }

    @FXML
    private void handleEqual() {
        double secondNumber = Double.parseDouble(display.getText());
        double result = 0;
        switch (operation) {
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "*" -> result = firstNumber * secondNumber;
            case "/" -> result = (secondNumber != 0) ? firstNumber / secondNumber : 0;
        }
        display.setText(String.valueOf(result));
        isNewInput = true;
    }

    @FXML
    private void handleClear() {
        display.setText("");
        firstNumber = 0;
        operation = "";
        isNewInput = true;
    }
}
