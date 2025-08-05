package cl.kibernumacademy.datatables.steps;
// Importa las anotaciones de Cucumber para los hooks y steps
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
// import io.cucumber.java.es.Dado;
// import io.cucumber.java.es.Cuando;
// import io.cucumber.java.es.Entonces;
// Importa DataTable para manejar tablas en los steps
import io.cucumber.datatable.DataTable;
// Importa WebDriver y Chrome para automatización con Selenium
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cl.kibernumacademy.datatables.pages.FormularioDatosPage;
// WebDriverManager para gestionar el driver de Chrome
import io.github.bonigarcia.wdm.WebDriverManager;

// Manejo de tiempo para esperas
import java.time.Duration;
// Manejo de mapas para los datos del DataTable
import java.util.Map;

public class FormularioDatosSteps {
    // Driver de Selenium para controlar el navegador
    private WebDriver driver;
    // Page Object para interactuar con el formulario
    private FormularioDatosPage formularioPage;

    // Hook que se ejecuta antes de cada escenario
    @Before
    public void setUp() {
        // Limpia la caché y configura el driver de Chrome
        WebDriverManager.chromedriver().clearDriverCache().setup();
        // Opciones para Chrome (permite orígenes remotos)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Inicializa el driver de Chrome con las opciones
        driver = new ChromeDriver(options);
        // Maximiza la ventana del navegador
        driver.manage().window().maximize();
        // Espera implícita: espera hasta 10 segundos por cada elemento
        // Se usa aquí porque todos los elementos del formulario aparecen rápido y no dependen de condiciones específicas
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Inicializa el Page Object del formulario
        formularioPage = new FormularioDatosPage(driver);
    }

    // Hook que se ejecuta después de cada escenario
    @After
    public void tearDown() {
        // Cierra el navegador si está abierto
        if (driver != null) {
            driver.quit();
        }
    }

    // Step: Accede a la página del formulario de datos
    @Given("que el usuario accede al formulario de datos")
    public void queElUsuarioAccedeAlFormularioDeDatos() {
        formularioPage.abrir(); // Abre la URL del formulario
    }

    // Step: Completa los datos del formulario usando una tabla DataTable
    @When("completa los siguientes datos:")
    public void completaLosSiguientesDatos(DataTable dataTable) {
        // Convierte la tabla en un mapa clave-valor
        Map<String, String> datos = dataTable.asMap(String.class, String.class);
        // Recorre cada campo y valor de la tabla
        for (Map.Entry<String, String> entry : datos.entrySet()) {
            // Imprime en consola el campo y valor
            System.out.println("Campo: " + entry.getKey() + "-  Valor: " + entry.getValue());
            // Según el campo, llama al método correspondiente del Page Object
            switch (entry.getKey()) {
                case "nombre":
                    formularioPage.ingresarNombre(entry.getValue()); // Ingresa el nombre
                    break;
                case "apellido":
                    formularioPage.ingresarApellido(entry.getValue()); // Ingresa el apellido
                    break;
                case "email":
                    formularioPage.ingresarEmail(entry.getValue()); // Ingresa el email
                    break;
                case "edad":
                    formularioPage.ingresarEdad(entry.getValue()); // Ingresa la edad
                    break;
            }
        }
        // Envía el formulario
        formularioPage.enviarFormulario();
    }

    // Step: Imprime los datos mostrados tras enviar el formulario
    @Then("los datos ingresados deben mostrarse correctamente")
    public void losDatosIngresadosDebenMostrarseCorrectamente() {
        // Imprime en consola los valores mostrados en la tabla de la web
        System.out.println("Nombre mostrado: " + formularioPage.obtenerNombreMostrado());
        System.out.println("Apellido mostrado: " + formularioPage.obtenerApellidoMostrado());
        System.out.println("Email mostrado: " + formularioPage.obtenerEmailMostrado());
        System.out.println("Edad mostrada: " + formularioPage.obtenerEdadMostrada());
        // Aquí puedes agregar validaciones lógicas si lo deseas
    }
}