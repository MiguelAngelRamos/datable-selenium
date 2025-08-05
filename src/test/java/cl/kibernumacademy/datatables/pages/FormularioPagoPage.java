package cl.kibernumacademy.datatables.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularioPagoPage {
  private WebDriver driver;
  private WebDriverWait wait;

  //*  Localizadores 
  // id: monto
  private By montoInput = By.id("monto");
  // id: medio
  private By medioSelect = By.id("medio");
  // id: resultado
  private By resultadoText = By.id("resultado");


  public FormularioPagoPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  }

  public void navigateTo() {
    driver.get("https://testing-qa.netlify.app/pages/banco.html");
  }

  // Ingresar el monto
  public void ingresarMonto(double monto) {
    WebElement montoElement = wait.until(ExpectedConditions.elementToBeClickable(montoInput));
    montoElement.clear();
    montoElement.sendKeys(String.valueOf(monto));
  }
  // Selecionar el medio de pago
  public void seleccionarMedioPago(String medio) {
    if(medio != null && !medio.isEmpty()) {
      WebElement medioElement = wait.until(ExpectedConditions.elementToBeClickable(medioSelect));
      medioElement.sendKeys(medio);
    }
  }
   // Obtener el resultado


  
}
