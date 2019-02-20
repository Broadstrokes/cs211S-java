import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.math.BigDecimal;

public class CreateAccountGUIController extends Application {
	
	private Account accountModel;
	private CreateAccountGUIView accountView;
	
	public CreateAccountGUIController() {
		accountView = new CreateAccountGUIView();
		accountView.createAccountAction(this::createAccount);
		accountView.checkIsOverdrawnAction(this::checkIfAccountIsOverdrawn);
	}

	private void createAccount(ActionEvent event) {
		String errorMessage = "";

		// get info from the view & instantiate checking account
		try {
			String userId = accountView.getUserId();

			if (userId.isEmpty()) {
				errorMessage = "User Id is a required field and cannot be empty";
				throw new IllegalArgumentException();
			}

			String accountId = accountView.getAccountId();

			if (accountId.isEmpty()) {
				errorMessage = "Account Id is a required field and cannot be empty";
				throw new IllegalArgumentException();
			}

			try {
				String initialDepositInput = accountView.getInitialDeposit();
				if (initialDepositInput.isEmpty()) {
					errorMessage = "Initial deposit is a required field and cannot be empty";
					throw new IllegalArgumentException();
				}
				BigDecimal initialDeposit = new BigDecimal(initialDepositInput);

				AccountType accountType = accountView.getAccountTypeField();

				if (accountType == AccountType.CHECKING) {
					accountModel = new CheckingAccount(userId, accountId, initialDeposit);
				} else if (accountType == AccountType.SAVINGS) {
					accountModel = new SavingsAccount(userId, accountId, initialDeposit);
				} else if (accountType == AccountType.BROKERAGE) {
					accountModel = new BrokerageAccount(userId, accountId, initialDeposit);
				}
			} catch (NumberFormatException ex) {
				errorMessage = "Deposit amount must be numeric";
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException ex) {
			Alert error = new Alert(Alert.AlertType.ERROR);
			error.setTitle("Error");
			error.setHeaderText(null);
			error.setContentText(errorMessage);
			error.showAndWait();
		}


		// get data from model & display data in view
		accountView.displayAccountData(
			accountModel.getAccountType(),
			accountModel.getUserId(),
			accountModel.getAccountId(),
			accountModel.getBalance()
		);

		accountView.enableCheckOverdrawnBtn();
	}

	private void checkIfAccountIsOverdrawn(ActionEvent event) {
		boolean isOverdrawn = accountModel.isOverdrawn();
		accountView.displayOverdrawnStatus(isOverdrawn);
	}

	@Override
	public void start(Stage primaryStage) {
		CreateAccountGUIController controller = new CreateAccountGUIController();

		Scene scene = new Scene(controller.accountView.getParent(), 400, 700);
		primaryStage.setTitle("Create a new Bank Account");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
