package metodos;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import drivers.DriversFactory;

public class Metodos extends DriversFactory {
	
	/**
	 * Metodo para escrever no browser 
	 * @param elemento
	 * @param texto
	 * @author Guilherme
	 */

	public void escrever(By elemento, String texto) {
		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			System.err.println("ERRO AO ESCREVER" + e.getMessage() + e.getCause());
		}

	}
	/**
	 * Metodo para clicar no browser 
	 * @param elemento
	 * 
	 * @author Guilherme
	 */

	public void clicar(By elemento) {
		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			System.err.println("ERRO AO CLICAR" + e.getMessage() + e.getCause());
		}
	}
	/**
	 * Metodo para validar um texto no browser 
	 * @param elemento
	 * @param texto
	 * @author Guilherme
	 */

	public void validarTexto(By elemento, String texto) {
		try {
			String textoValidar = driver.findElement(elemento).getText();
			assertTrue(textoValidar.contains(texto));
		} catch (Exception e) {
			System.err.println("ERRO AO NA VALIDAÇÃO" + e.getMessage() + e.getCause());
		}

	}
	/**
	 * Metodo para tirar um screenshoot do browser para evidenciar teste
	 * 
	 * @param nomeEvidencia
	 * @author Guilherme
	 */

	public void evidenciar(String nomeEvidencia) {
		try {
			TakesScreenshot srcShoot = ((TakesScreenshot) driver);
			File srcFile = srcShoot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./evidencias/" + nomeEvidencia + ".png");
			FileUtils.copyFile(srcFile, destFile);

		} catch (Exception e) {
			System.err.println("ERRO AO NA VALIDAÇÃO" + e.getMessage() + e.getCause());
		}

	}
	/**
	 * Metodo para continuar teste em outra guia do browser
	 * @param elemento
	 * @param qtds tabs
	 * @author Guilherme
	 */


	public void newTab(By elemento, int tabs) {
		WebElement botão = driver.findElement(elemento);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).moveToElement(botão).sendKeys(Keys.ENTER).perform();
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(tabs));

	}
	/**
	 * Metodo criado para interromper o teste por alguns milisegundos
	 * 
	 * @param temp
	 * @author Guilherme
	 */


	public void aguardar(int temp) throws InterruptedException {
		Thread.sleep(temp);
	}
	/**
	 * Metodo criado para validar pop-up de cookie do browser 
	 * @param elemento
	 * @param qtdClicks
	 * @author Guilherme
	 */
	public void cookies(By element, int qtdClicks) {
		try {
			WebElement cookie = driver.findElement(element);
			do {
				clicar(element);
				qtdClicks--;
			} while (cookie.isDisplayed() && qtdClicks > 0);
			{

			}
		} catch (Exception e) {
			System.err.println("ERRO AO NA VALIDAR COOKIE" + e.getMessage() + e.getCause());
		}

	}

}