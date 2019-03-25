package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroLocators {
	protected WebElement email_create;
	protected WebElement SubmitCreate;
	//teste teste
	
	//formulário cadastro
	@FindBy(id = "uniform-id_gender1")
	protected WebElement sexo;	
	protected WebElement customer_firstname;
	protected WebElement customer_lastname;
	protected WebElement passwd;
	protected WebElement days;
	protected WebElement months;
	protected WebElement years;
	protected WebElement firstname;
	protected WebElement lastname;
	protected WebElement company;
	protected WebElement address1;
	protected WebElement address2;
	protected WebElement city;
	protected WebElement id_state;
	protected WebElement postcode;
	protected WebElement id_country;
	protected WebElement other;
	protected WebElement phone;
	protected WebElement phone_mobile;
	protected WebElement alias;
	
	protected WebElement submitAccount;
	
	//Campos Endereço resumo validar
	@FindBy(css = ".address.item.box")
	protected WebElement enderecoPrincipal;
	
//	@FindBy(css = ".button.btn.btn-default.button-medium")
	protected WebElement processAddress;
	protected WebElement processCarrier;
	
	protected WebElement cgv;
	
}

