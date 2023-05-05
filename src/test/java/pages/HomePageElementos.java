package pages;

import org.openqa.selenium.By;

public class HomePageElementos {
	/**
	 * Armazenar elementos da homePage 
	 *
	 * 
	 * @author Guilherme
	 */
	
	private static By buscarCEP = By.xpath("//input[@name='relaxation']");
	private static By texto = By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]");
	private static By msgErro = By.xpath("//*[@id='mensagem-resultado']");
	private static By btncookie = By.xpath("//*[@id='btnCookie']");
	public By getBuscarCEP() {
		return buscarCEP;
	}

	public By getTexto() {
		return texto;
	}

	public By getMsgErro() {
		return msgErro;
	}

	public By getBtncookie() {
		return btncookie;
	}
	
	

}
