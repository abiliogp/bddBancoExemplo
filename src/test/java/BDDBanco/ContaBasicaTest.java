package BDDBanco;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/java/ContaBasica.feature"}
)
public class ContaBasicaTest {
	
	@AfterClass
	public static void listarContas() {
		Banco.getInstance().gravarContas();
	}

}
