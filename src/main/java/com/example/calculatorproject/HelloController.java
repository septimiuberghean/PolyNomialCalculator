package com.example.calculatorproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;

import java.util.*;
import java.net.URL;

public class HelloController implements Initializable {
    @FXML
    private TextField firstPolynomialTextField;
    @FXML
    private TextField secondPolynomialTextField;
    @FXML
    private TextField resultTextField;
    @FXML
    private Button addButton;
    @FXML
    private Button minusButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button divideButton;
    @FXML
    private Button integrateButton;
    @FXML
    private Button deriveButton;
    @FXML
    private ImageView bmoImageView;
    @FXML
    private ImageView sodaImageView;
    @FXML
    private ImageView cryImageView;
    @FXML
    private ImageView stressImageView;
    @FXML
    private ImageView danceImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ViewManager.initializeImages(bmoImageView, sodaImageView, cryImageView, stressImageView, danceImageView);
    }

    public void addButtonOnAction(ActionEvent actionEvent) {
        Map<Integer, Integer> firstPolynomial = PolynomialParser.parsePolynomial(firstPolynomialTextField.getText());
        Map<Integer, Integer> secondPolynomial = PolynomialParser.parsePolynomial(secondPolynomialTextField.getText());
        Map<Integer, Integer> resultPolynomial = PolynomialOperations.add(firstPolynomial, secondPolynomial);
        String result = PolynomialParser.constructPolynomialString(resultPolynomial);
        resultTextField.setText(result.isEmpty() ? "0" : result);
    }

    public void minusButtonOnAction(ActionEvent actionEvent) {
        Map<Integer, Integer> firstPolynomial = PolynomialParser.parsePolynomial(firstPolynomialTextField.getText());
        Map<Integer, Integer> secondPolynomial = PolynomialParser.parsePolynomial(secondPolynomialTextField.getText());
        Map<Integer, Integer> resultPolynomial = PolynomialOperations.subtract(firstPolynomial, secondPolynomial);
        String result = PolynomialParser.constructPolynomialString(resultPolynomial);
        resultTextField.setText(result.isEmpty() ? "0" : result);
    }

    public void integrateButtonOnAction(ActionEvent actionEvent) {
        Map<Integer, Integer> firstPolynomial = PolynomialParser.parsePolynomial(firstPolynomialTextField.getText());
        Map<Integer, Double> resultPolynomial = PolynomialOperations.integrate(firstPolynomial);
        String result = PolynomialParser.constructPolynomialString(resultPolynomial);
        resultTextField.setText(result.isEmpty() ? "0" : result);
    }

    public void deriveButtonOnAction(ActionEvent actionEvent) {
        Map<Integer, Integer> firstPolynomial = PolynomialParser.parsePolynomial(firstPolynomialTextField.getText());
        Map<Integer, Integer> resultPolynomial = PolynomialOperations.derive(firstPolynomial);
        String result = PolynomialParser.constructPolynomialString(resultPolynomial);
        resultTextField.setText(result.isEmpty() ? "0" : result);
    }

    public void multiplyButtonOnAction(ActionEvent actionEvent) {
        Map<Integer, Integer> firstPolynomial = PolynomialParser.parsePolynomial(firstPolynomialTextField.getText());
        Map<Integer, Integer> secondPolynomial = PolynomialParser.parsePolynomial(secondPolynomialTextField.getText());
        Map<Integer, Integer> resultPolynomial = PolynomialOperations.multiply(firstPolynomial, secondPolynomial);
        String result = PolynomialParser.constructPolynomialString(resultPolynomial);
        resultTextField.setText(result.isEmpty() ? "0" : result);
    }

    public void divideButtonOnAction(ActionEvent actionEvent) {
        Map<Integer, Integer> firstPolynomial = PolynomialParser.parsePolynomial(firstPolynomialTextField.getText());
        Map<Integer, Integer> secondPolynomial = PolynomialParser.parsePolynomial(secondPolynomialTextField.getText());
        if (secondPolynomial.isEmpty()) {
            resultTextField.setText("impossible");
            return;
        }
        Map<Integer, Integer> quotient = PolynomialOperations.divide(firstPolynomial, secondPolynomial);
        String result = PolynomialParser.constructPolynomialString(quotient);
        resultTextField.setText(result.isEmpty() ? "0" : result);
    }

}