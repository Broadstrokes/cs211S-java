import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.math.BigDecimal;
import java.util.Arrays;

public class CreateAccountGUIView   {

	private TextField userIdField, accountIdField, initialDepositField;
	private Text headlineText, accountTypeLabel, userIdLabel, accountIdLabel, initialDepositLabel, messageDisplayText, isOverdrawnText;
	private ComboBox<AccountType> accountTypeComboBox;
	private Button createAccount, clearInputsBtn, checkOverdrawnBtn;
	private VBox primaryBox;
	
	private final static Font font = Font.font("Verdana", 20);
	
	public CreateAccountGUIView() {
		primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(20);
		primaryBox.setStyle("-fx-background-color: lightcyan");

		// Message displayed after successful account creation
		headlineText = new Text("Chase Manhattan Bank");
		headlineText.setFont(Font.font ("Verdana", 30));
		VBox messageBox0 = new VBox(headlineText);
		messageBox0.setAlignment(Pos.CENTER);
		messageBox0.setSpacing(10);
		primaryBox.getChildren().add(messageBox0);


		// Account type selection
		accountTypeLabel = new Text("Select an account type: ");
		ObservableList<AccountType> accountTypeOptions = FXCollections.observableArrayList(
				Arrays.asList(AccountType.values()).subList(0, 3)
		);
		accountTypeComboBox = new ComboBox<>(accountTypeOptions);
		accountTypeComboBox.setValue(AccountType.CHECKING);
		VBox accountTypeBox = new VBox(accountTypeLabel, accountTypeComboBox);
		accountTypeBox.setAlignment(Pos.CENTER);
		accountTypeBox.setSpacing(10);
		primaryBox.getChildren().add(accountTypeBox);

		// User Id
		userIdLabel = new Text("Enter a new User ID: ");
		userIdLabel.setFont(font);
		userIdField = new TextField();
		VBox userIdBox = new VBox(userIdLabel, userIdField);
		userIdBox.setAlignment(Pos.CENTER);
		userIdBox.setSpacing(10);
		primaryBox.getChildren().add(userIdBox);

		// Account Id
		accountIdLabel = new Text("Enter an account ID: ");
		accountIdLabel.setFont(font);
		accountIdField = new TextField();
		VBox accountIdBox = new VBox(accountIdLabel, accountIdField);
		accountIdBox.setAlignment(Pos.CENTER);
		accountIdBox.setSpacing(10);
		primaryBox.getChildren().add(accountIdBox);

		// Initial Deposit
		initialDepositLabel = new Text("Enter the initial deposit amount: ");
		initialDepositLabel.setFont(font);
		initialDepositField = new TextField();
		VBox initialDepositBox = new VBox(initialDepositLabel, initialDepositField);
		initialDepositBox.setAlignment(Pos.CENTER);
		initialDepositBox.setSpacing(10);
		primaryBox.getChildren().add(initialDepositBox);

		// Button to create an account
		createAccount = new Button("Create Account");
		createAccount.setStyle("-fx-font-weight: 400; -fx-font-size: 1.2em; -fx-text-fill: white; -fx-background-color: #007bff" );
		// Button to clear inputs
		clearInputsBtn = new Button("Clear inputs");
		clearInputsBtn.setStyle("-fx-font-weight: 400; -fx-font-size: 1.2em; -fx-text-fill: white; -fx-background-color: #ffc107" );
		HBox buttonBox1 = new HBox(createAccount, clearInputsBtn);
		buttonBox1.setAlignment(Pos.CENTER);
		buttonBox1.setSpacing(10);
		primaryBox.getChildren().add(buttonBox1);


		// Message displayed after successful account creation
		messageDisplayText = new Text();
		messageDisplayText.setFont(font);
		VBox messageBox = new VBox(messageDisplayText);
		messageBox.setAlignment(Pos.CENTER);
		messageBox.setSpacing(10);
		primaryBox.getChildren().add(messageBox);

		// Button to check if account is overdrawn
		checkOverdrawnBtn = new Button("Check if account is overdrawn?");
		HBox buttonBox3 = new HBox(checkOverdrawnBtn);
		buttonBox3.setAlignment(Pos.CENTER);
		buttonBox3.setSpacing(10);
		checkOverdrawnBtn.setDisable(true);
		primaryBox.getChildren().add(buttonBox3);

		// Message indicating whether account is overdrawn
		isOverdrawnText = new Text();
		isOverdrawnText.setFont(font);
		VBox messageBox2 = new VBox(isOverdrawnText);
		messageBox2.setAlignment(Pos.CENTER);
		messageBox2.setSpacing(10);
		primaryBox.getChildren().add(messageBox2);

	}

	public Parent getParent() { return primaryBox; }


	/*
		GET USER INPUT
	 */


	public String getUserId() { return userIdField.getText(); }
	public String getAccountId() { return accountIdField.getText(); }
	public String getInitialDeposit() { return initialDepositField.getText(); }
	public AccountType getAccountTypeField() { return accountTypeComboBox.getValue(); }


	/*
		CLICK HANDLERS
	 */


	public void createAccountAction(EventHandler<ActionEvent> handler) {
		createAccount.setOnAction(handler);
	}

	public void clearInputsAction(EventHandler<ActionEvent> handler) {
		clearInputsBtn.setOnAction(handler);
	}

	public void checkIsOverdrawnAction(EventHandler<ActionEvent> handler) {
		checkOverdrawnBtn.setOnAction(handler);
	}


	/*
		MODIFY VIEW STATE
	 */


	public void displayAccountData(AccountType accountType, String userId, String accountId, BigDecimal balance) {
		messageDisplayText.setText(
				"Account type: " + accountType + "\n" +
						"User ID: " + userId + "\n" +
						"Account ID: " + accountId + "\n" +
						"Balance: " + balance
		);
	}

	public void displayOverdrawnStatus(boolean isOverdrawn) {
		isOverdrawnText.setText("Is the account overdrawn? : " + isOverdrawn);
	}

	public void enableCheckOverdrawnBtn() { checkOverdrawnBtn.setDisable(false); }

	public void displayOverdrawnMessage(boolean showMessage) { isOverdrawnText.setVisible(showMessage); }

	public void clearInputs() {
		userIdField.clear();
		accountIdField.clear();
		initialDepositField.clear();
	}

}
