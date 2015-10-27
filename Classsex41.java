package edu.nvcc.csc200.javafx;

import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Classsex41 extends Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		String CorrectUsername = "Ntad1";
		String CorrectPassword = "Locker";

		primaryStage.setTitle("Log In");
		Label UsernameLbl = new Label("Username");
		Label PasswordLbl = new Label("Password");
		TextField UsernameTxtFld = new TextField();
		PasswordField PasswordTxtFld = new PasswordField();
		Button submitBtn = new Button("Submit");

		submitBtn.setOnAction(new EventHandler<ActionEvent>() {
			String inputUsername = "";
			String inputpw = "";
			String[] AccountType = { "Administrator", "Student", "Staff" };

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				inputUsername = UsernameTxtFld.getText();
				inputpw = PasswordTxtFld.getText();
				String inputAcctyp = "";
				boolean Loop = true;
				boolean AccountLoop = true;
				int i = 0;

				while(i < 1 && Loop == true){
					if (CorrectUsername.equals(inputUsername) && CorrectPassword.equals(inputpw)) {
						JOptionPane.showMessageDialog(null, "Welcome " + inputUsername + "!");
						Loop = false;
					} else {
						i++;
						JOptionPane.showMessageDialog(null, "Enter a valid username or password");
					}
				}
				if (Loop == false) {
					do {
						inputAcctyp = (String) JOptionPane.showInputDialog(null, "Select Type of Account",
								"Account type", JOptionPane.QUESTION_MESSAGE, null, AccountType, AccountType[0]);
						if (inputAcctyp.equals(AccountType[0])) {
							JOptionPane.showMessageDialog(null, "Welcome " + inputUsername + "!");
							AccountLoop = true;
						} else {
							JOptionPane.showInputDialog(null, "invalid Account");

						}
					} while (AccountLoop == false);
					System.exit(0);
				}
			}
		});
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10.0);
		grid.setHgap(10.0);
		grid.add(UsernameLbl, 0, 0);
		grid.add(PasswordLbl, 0, 1);
		grid.add(UsernameTxtFld, 1, 0);
		grid.add(PasswordTxtFld, 1, 1);
		grid.add(submitBtn, 1, 2);
		Scene scene = new Scene(grid, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}