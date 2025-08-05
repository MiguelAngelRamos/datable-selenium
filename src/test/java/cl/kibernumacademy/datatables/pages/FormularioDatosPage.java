package cl.kibernumacademy.datatables.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDatosPage {
    private WebDriver driver;
    private String url = "https://testing-qa.netlify.app/pages/formulario-datos";
    
    public FormularioDatosPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrir() {
        driver.get(url);
    }

    public void ingresarNombre(String nombre) {
        driver.findElement(By.id("nombre")).clear();
        driver.findElement(By.id("nombre")).sendKeys(nombre);
    }

    public void ingresarApellido(String apellido) {
        driver.findElement(By.id("apellido")).clear();
        driver.findElement(By.id("apellido")).sendKeys(apellido);
    }

    public void ingresarEmail(String email) {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void ingresarEdad(String edad) {
        driver.findElement(By.id("edad")).clear();
        driver.findElement(By.id("edad")).sendKeys(edad);
        
    }

    public void enviarFormulario() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public String obtenerNombreMostrado() {
        return driver.findElement(By.id("tdNombre")).getText();
    }
    public String obtenerApellidoMostrado() {
        return driver.findElement(By.id("tdApellido")).getText();
    }
    public String obtenerEmailMostrado() {
        return driver.findElement(By.id("tdEmail")).getText();
    }
    public String obtenerEdadMostrada() {
        return driver.findElement(By.id("tdEdad")).getText();
    }
}
