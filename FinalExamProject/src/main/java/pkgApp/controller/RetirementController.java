package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtSaveEachMnth;
	@FXML
	private TextField txtAnnReturnWork;
	@FXML
	private TextField txtNeedToSave;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnReturnRet;
	@FXML
	private TextField txtReqIncome;
	@FXML
	private TextField txtSSI;
	
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		//Clear all the text inputs
		txtYearsToWork.clear();
		txtSaveEachMnth.clear();
		txtAnnReturnWork.clear();
		txtNeedToSave.clear();
		txtYearsRetired.clear();
		txtAnnReturnRet.clear();
		txtReqIncome.clear();
		txtSSI.clear();
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		//	TODO: Call AmountToSave and TotalAmountSaved and populate 
		Retirement Yours = new Retirement(Integer.parseInt(txtYearsToWork.getText()),Double.parseDouble(txtAnnReturnWork.getText()),Integer.parseInt(txtYearsRetired.getText()),Double.parseDouble(txtAnnReturnRet.getText()),Double.parseDouble(txtReqIncome.getText()),Double.parseDouble(txtSSI.getText()));
		txtSaveEachMnth.setText(Double.toString(Yours.AmountToSave()));
		txtNeedToSave.setText(Double.toString(Yours.TotalAmountSaved()));
	}
	
}
