package BDDBanco;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/US001 - Manter conta bancaria.feature" })
public class US001_ManterContaBancariaTest {

	@AfterClass
	public static void listarContas() {
		Banco.getInstance().gravarContas();
	}

}
