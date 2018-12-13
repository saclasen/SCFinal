package pkgCore;
import pkgApp.controller.RetirementController;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	
	//Build the contructor, getters and setters for the attributes above.
	
	public Retirement( int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired, double dRequiredIncome, double dMonthlySSI) {
		this.setdAnnualReturnRetired(dAnnualReturnRetired);
		this.setdAnnualReturnWorking(dAnnualReturnWorking);
		this.setdMonthlySSI(dMonthlySSI);
		this.setdRequiredIncome(dRequiredIncome);
		this.setiYearsRetired(iYearsRetired);
		this.setiYearsToWork(iYearsToWork);
	}
	
	public int getiYearsToWork() {
		return iYearsToWork;
	}

	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}

	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}

	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}

	public int getiYearsRetired() {
		return iYearsRetired;
	}

	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}

	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}

	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}

	public double getdRequiredIncome() {
		return dRequiredIncome;
	}

	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}

	public double getdMonthlySSI() {
		return dMonthlySSI;
	}

	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}

	public double AmountToSave()
	{
		//Determine the amount to save each month based on TotalAmountSaved, YearsToWork
		//and Annual return while working
		double rate = (getdAnnualReturnWorking()/100)/12;
		double nper = getiYearsToWork()*12;
		double fv = this.TotalAmountSaved();
		double pv = 0;
		double saveUpMonthly = rate*(-fv+ pv*Math.pow((1+rate),nper))/((1+rate*0)*(1-Math.pow(1+rate,nper)));
		return saveUpMonthly;
		
	}
	
	public double TotalAmountSaved()
	{
		//	Determine amount to be saved based on Monthly SSI, Required Income, Annual return during retirement
		//		and number of years retired.
		double nper = getiYearsRetired()*12;
		double pmt =  getdRequiredIncome() - getdMonthlySSI();
		double rate = (getdAnnualReturnRetired()/100)/12;
		double allSavedUp = pmt*((1-Math.pow(1 + rate, -nper))/rate);
		return allSavedUp;
	}
}
