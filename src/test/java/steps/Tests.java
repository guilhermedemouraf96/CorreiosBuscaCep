package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metodos.Metodos;
import pages.HomePageElementos;
import runner.Executar;

public class Tests {

	Metodos metodo = new Metodos();
	HomePageElementos home = new HomePageElementos();
	Executar executa = new Executar();

	@Given("que esteja na pagina inicial")
	public void que_esteja_na_pagina_inicial() {
		executa.abrirNavegador(true);

	}

	@When("pesquisar um CEP válido")
	public void pesquisar_um_cep_válido() throws InterruptedException {
		metodo.aguardar(1000);
		metodo.cookies(home.getBtncookie(), 3);
		metodo.escrever(home.getBuscarCEP(), "01001000");
		metodo.evidenciar("CT1 - Digitando CEP");
		metodo.newTab(home.getBuscarCEP(), 1);

	}

	@Then("validar o endereço")
	public void validar_o_endereço() {
		metodo.validarTexto(home.getTexto(), "Praça da Sé - lado ímpar");
		metodo.evidenciar("CT - Validando endereço");
		executa.fecharNavegador();

	}

	@Given("pesquisar um CEP em branco")
	public void pesquisar_um_cep_em_branco() throws InterruptedException {
		metodo.aguardar(1000);
		metodo.cookies(home.getBtncookie(), 3);
		metodo.escrever(home.getBuscarCEP(), " ");
		metodo.evidenciar("CT2 - Campo CEP em branco");
		metodo.newTab(home.getBuscarCEP(), 1);

	}

	@Then("visualizo mensagem de erro")
	public void visualizo_mensagem_de_erro() {
		metodo.validarTexto(home.getMsgErro(), "Não há dados a serem exibidos");
		metodo.evidenciar("CT2 - Validando mensagem de erro");
		executa.fecharNavegador();
	}

}
