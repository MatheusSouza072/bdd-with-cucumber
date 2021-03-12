package com.devmatheus.bddwithcucumber.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Ent�o;
import io.cucumber.java.pt.Quando;



public class InserirContasSteps {

	private WebDriver driver;
	
	@Dado("^que desejo adicionar uma conta$")
	public void queDesejoAdicionarUmaConta() throws Throwable {
		driver = new FirefoxDriver();
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("ivan.assis@teste");
		driver.findElement(By.id("senha")).sendKeys("teste");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("Contas")).click();
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("^adiciono a conta \"([^\"]*)\"$")
	public void adicionoAConta(String arg1) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(arg1);
		driver.findElement(By.tagName("button")).click();		
	}

	@Ent�o("^recebo a mensagem \"([^\"]*)\"$")
	public void receboAMensagem(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
		Assert.assertEquals(arg1, texto);		
	}

	// Desta forma as imagens ter�o o nome do cen�rio
		// order -> permite que a screenshot seja a primeira executada
		// value -> define em quais testes ele n�o deve ser executado
		@After(order = 1, value = "@funcionais") 
		public void sreenshot(Scenario cenario) {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("target/screenshots/"+cenario.getId()+".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@After(order = 0, value = "@funcionais") 
		public void fecharBrowser() {
			driver.quit();
			System.out.println("Terminando driver.");
		}
	
/* Testes refentes ao tipo descri��o do cen�rio imperativo
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
		driver.findElement(By.id("nome")).sendKeys(arg1);
	}
	@Quando("^seleciono salvar$")
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
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
		Assert.assertEquals(arg1, texto);		
	}
	
	// Desta forma as imagens ter�o o nome do cen�rio
	// order -> permite que a screenshot seja a primeira executada
	// value -> define em quais testes ele n�o deve ser executado
	@After(order = 1, value = {"@funcionais"}) 
	public void sreenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/"+cenario.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(order = 0, value = {"@funcionais"}) 
	public void fecharBrowser() {
		driver.quit();
		System.out.println("Terminando driver.");
	}
*/	
	// Desta forma abaixo cada imagem salvo iria sobrepor a outra	
	/*	@After
		public void sreenshot() {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("target/screenshots/nome.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} */
}