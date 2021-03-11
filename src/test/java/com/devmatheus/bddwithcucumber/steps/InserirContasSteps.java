package com.devmatheus.bddwithcucumber.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;


public class InserirContasSteps {

	private WebDriver driver;
	
	@Dado("^que estou acessando a aplica��o$")
	public void queEstouAcessandoAAplica��o() throws Throwable {
		driver = new FirefoxDriver();
		driver.get("https://seubarriga.wcaquino.me/login");
	}

	@Quando("^informo o usu�rio \"([^\"]*)\"$")
	public void informoOUsu�rio(String arg1) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@Quando("^a senha \"([^\"]*)\"$")
	public void aSenha(String arg1) throws Throwable {
		driver.findElement(By.id("senha")).sendKeys(arg1);
	}

	@Quando("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable {
		driver.findElement(By.tagName("button")).click();		
	}

	@Ent�o("^visualizo a p�gina inicial$")
	public void visualizoAP�ginaInicial() throws Throwable {
	    String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	    Assert.assertEquals("Bem vindo, ivan.assis!", texto);
	}

	@Quando("^seleciono Contas$")
	public void selecionoContas() throws Throwable {
		driver.findElement(By.linkText("Contas")).click();		
	}

	@Quando("^seleciono Adicionar$")
	public void selecionoAdicionar() throws Throwable {
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informoAConta(String arg1) throws Throwable {
		driver.findElement(By.xpath("//*[@id='nome']")).sendKeys(arg1);
	}

	@Quando("^seleciono Salvar$")
	public void selecionoSalvar() throws Throwable {
		driver.findElement(By.tagName("button")).click();		
	}

	@Ent�o("^a conta � inserida com sucesso$")
	public void aConta�InseridaComSucesso() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Conta adicionada com sucesso!", texto);	
	}

	@Ent�o("^sou notificar que o nome da conta � obrigat�rio$")
	public void souNotificarQueONomeDaConta�Obrigat�rio() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		Assert.assertEquals("Informe o nome da conta", texto);	   
	}
	
	@Ent�o("^sou notificado que j� existe uma conta com esse nome$")
	public void souNotificadoQueJ�ExisteUmaContaComEsseNome() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		Assert.assertEquals("J� existe uma conta com esse nome!", texto);		
	}
	
	@Ent�o("^recebo a mensagem \"([^\"]*)\"$")
	public void receboAMensagem(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//div[stars-with(@class, 'alert alert-']")).getText();
		Assert.assertEquals(arg1, texto);		
	}

	
	@Before // cucumber.api
	public void inicia() {
		System.out.println("Come�ando driver.");
	}
	
	@After // cucumber.api
	public void fecharBrowser() {
		driver.quit();
		System.out.println("Terminando driver.");
	}
}