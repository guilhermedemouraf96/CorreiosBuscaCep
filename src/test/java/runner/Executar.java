package runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import drivers.DriversFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Importar Cucumber class e Cucumber Options do pacote Cucumber Java
 *
 *
 * @author Guilherme
 */


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "steps",
		tags = "@buscaCEP",
		dryRun = false,
		plugin = {"pretty", "html:target/report-cucumber.html"},
		monochrome = true

		)



public class Executar extends DriversFactory{
	
	/**
	 * Método para abrir navegador sendo com navegador aberto ou fechado(headless)
	 *
	 * @param headless
	 * @author Guilherme
	 */


	public void abrirNavegador(boolean headless) {
		try {
			String ambiente="https://www.correios.com.br/";
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(!headless) {
				options.addArguments("--headless");
			}
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			driver.get(ambiente);
			
		} catch (Exception e) {
			System.err.println("ERRO AO ABRIR O NAVEGADOR" + e.getMessage() + e.getCause());
			
		}
		
	}
	/**
	 * Método para fechar o navegador dado que seja concluido com sucesso
	 *
	 * 
	 * @author Guilherme
	 */

	
	public void fecharNavegador() {
    	driver.quit();
	
}
}
