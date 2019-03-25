package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import locators.CadastroLocators;
import system.TestRule;
import system.Utils;

public class CadastroPage extends CadastroLocators{
	
	public CadastroPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	public void newEmail() {
		Random emailRandon = new Random();
		email_create.sendKeys("teste.test"+emailRandon.nextInt(100)+"@teste.com.br");
	}
		
	public void cadastroNovo() throws InterruptedException {
		SubmitCreate.click();
		
//		Thread.sleep(1000);
		Utils.waitElementClicavel(sexo);
		sexo.click();
		customer_firstname.sendKeys("Janio");
		customer_lastname.sendKeys("Marinho");
		passwd.sendKeys("123456789jgm");
		Select slcDia = new Select(days);
		slcDia.selectByValue("13");
		Select slcMes = new Select(months);
		slcMes.selectByValue("5");
		Select slcAno = new Select(years);
		slcAno.selectByValue("1984");
		company.sendKeys("Casa");
		address1.sendKeys("AUDUBON TRL");
		address2.sendKeys("Ap 352626");
		city.sendKeys("LAKE WORTH");
		Select slcid_state = new Select(id_state);
		slcid_state.selectByVisibleText("Florida");
		postcode.sendKeys("33449");
		Select slcid_country = new Select(id_country);
		slcid_country.selectByVisibleText("United States");
		other.sendKeys("Usuario Teste Janio");
		phone.sendKeys("551159382360");
		phone_mobile.sendKeys("551122225895");
		alias.clear();
		alias.sendKeys("Endereço Alternativo");
		
		submitAccount.click();
		
		Thread.sleep(1000);
	}
	
	public boolean validarEndereco() {
		String strEndereco = enderecoPrincipal.findElement(By.cssSelector("li[class='address_address1 address_address2']")).getText();
		System.out.println("Nome endereco "+strEndereco);
		if(strEndereco.contains("AUDUBON TRL Ap 352626")) {
			return true;
		}else {
			return false;
		}	
	}
	
	public void btnCheckoutFinalizacao() {
		processAddress.click();
	}
	
	public void checkBoxTermo() {
		cgv.click();
	}
	
	public void btnProsseguir() {
		processCarrier.click();
	}
}

