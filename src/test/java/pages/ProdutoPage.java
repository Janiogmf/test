package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.ProdutoLocators;
import system.TestRule;

public class ProdutoPage extends ProdutoLocators {
	public ProdutoPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	public void selecionarProduto() throws InterruptedException {
		Thread.sleep(2000);		
		List<WebElement> li_homefeatured = homefeatured.findElements(By.cssSelector("li"));        
		Random numRandom = new Random();
		int numEscolhaProd = numRandom.nextInt(li_homefeatured.size());
		System.out.println(numEscolhaProd);
		for (int i=0;i<li_homefeatured.size();i++) {
			if (i == numEscolhaProd){
				String strlist = li_homefeatured.get(i).findElement(By.cssSelector("a[class='product_img_link']")).getAttribute("href");
				Actions hover = new Actions(TestRule.getDriver());
				hover.moveToElement(li_homefeatured.get(i)).build().perform();
				TestRule.getDriver().get(strlist);
				break;
			}
		}
	} 
}

