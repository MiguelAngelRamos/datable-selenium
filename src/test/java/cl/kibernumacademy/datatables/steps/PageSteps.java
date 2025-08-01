package cl.kibernumacademy.datatables.steps;

import org.openqa.selenium.WebDriver;

import cl.kibernumacademy.datatables.pages.FormularioPagoPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PageSteps {
  private WebDriver driver;
  private String resultado;
  private FormularioPagoPage formularioPagoPage;

  @Before
  public void setUp() {

  }

  @Given("que el usuario accede al formulario de pago")
  public void que_el_usuario_accede_al_formulario_de_pago() {
     // Navegar a la página del formulario de pago
    formularioPagoPage.navigateTo();
  }

  // (\\d+|-\\d+) sirve para capturar un numero positivo (\\d+), negativo (-\\d+)
  // (Tarjeta|Efectivo|Transferencia)? = Permite capturar cualquiera de estos 3 medios de pago o ninguno ( el ? lo hace opcional)
  @When("^ingresa el monto (\\d+|-\\d+) y selecciona el medio (Tarjeta|Efectivo|Transferencia)?$")
  public void ingresa_el_monto_y_selecciona_el_medio(double monto, String medio) {
    // Ingresar el monto
    formularioPagoPage.ingresarMonto(monto);
    // Seleccionar el medio de pago
    formularioPagoPage.seleccionarMedioPago(medio);
  }


}
