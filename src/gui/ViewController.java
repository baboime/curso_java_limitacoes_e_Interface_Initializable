package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alertas;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController implements Initializable {
	
	@FXML
	private TextField txtNumero1;
	
	@FXML
	private TextField txtNumero2;
	
	@FXML
	private Label labelResultado;
	
	@FXML
	private Button btSoma;
	
	@FXML
	public void onBtSoma() {
		try {
			Locale.setDefault(Locale.US);
			double numero1 = Double.parseDouble(txtNumero1.getText());
			double numero2 = Double.parseDouble(txtNumero2.getText());
			double soma = numero1 + numero2;
			labelResultado.setText(String.format("%.2f", soma));	
		}
		catch (NumberFormatException e) {
			Alertas.showAlert("Erro", "Parse erro", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtNumero1);
		Constraints.setTextFieldDouble(txtNumero2);
		Constraints.setTextFieldMaxLength(txtNumero1, 12);
		Constraints.setTextFieldMaxLength(txtNumero2, 12);
	}
}
