package pkgEmpty;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pkgCore.Retirement;


public class RetirementMethodsTest {
	@Test
	public void AmountToSaveTest() {
		Retirement Yours = new Retirement(40,7,20,2,10000,2642);
		assertTrue(Math.round(Yours.AmountToSave())==554);
	}
	
	@Test
	public void TotalAmountSavedTest() {
		Retirement Yours = new Retirement(40,7,20,2,10000,2642);
		assertTrue(Math.round(Yours.TotalAmountSaved())== Math.round(1454485.548));
	}
	
}
