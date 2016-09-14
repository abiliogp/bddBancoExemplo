package BDDBanco;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/US002 - Depositar valor na conta bancaria.feature" })
public class US002_DepositarUmValorNaContaBancariaTest {

	@AfterClass
	public static void listarContas() {
		Banco.getInstance().gravarContas();
	}

}
