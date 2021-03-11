package com.devmatheus.bddwithcucumber.runner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
//		features = "src/test/resources/features/aprender_cucumber.feature",
		features = "src/test/resources/features/inserir_conta.feature",
		glue = "com.devmatheus.bddwithcucumber.steps",
		tags = {"~@ignore"}, // permite executar cen�rios ou feature desejada, basta adicionar o identificador "@esse", "~@ignore" / {"@tipo1", "@tipo2"} / {"@tipo1, @tipo2"} / 
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true, // junto com o plugin n�o exibe mais caracteres especiais, mais agrad�vel
		snippets = SnippetType.CAMELCASE,  /* o m�todo segue o padr�o da linguagem java. Exemplo "abrirBrowser". Primeira letra de cada palavra em mai�sculo */
		dryRun = false,  // Validar se o mapeamento est� correto, �til na montagem do cen�rio, se estiver ok voltar para exc. normal
		strict = false // Exibe erro ao identificar passos a mais no script
	)

public class Runner {
	
	@BeforeClass  // Ser� executado antes de qualquer execu��o
	public static void reset() {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("ivan.assis@teste");
		driver.findElement(By.id("senha")).sendKeys("teste");
		driver.findElement(By.tagName("button")).click();	
		driver.findElement(By.linkText("reset")).click();
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Dados resetados com sucesso!", texto);		
		
		driver.quit();		
	}
}	