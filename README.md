# Actividad: Automatización de Pruebas con Selenium y Cucumber

## Objetivo
Automatizar la validación de un formulario de pago y el llenado de un formulario de datos personales usando Selenium WebDriver y Cucumber en Java. Los alumnos deberán crear pruebas automatizadas que verifiquen el correcto funcionamiento de la web https://testing-qa.netlify.app/pages/banco.html.

## Instrucciones

### 1. Clona o descarga este repositorio
Asegúrate de tener el proyecto en tu máquina local.

### 2. Revisa la web objetivo
La web a automatizar es: [https://testing-qa.netlify.app/pages/banco.html](https://testing-qa.netlify.app/pages/banco.html)

- El primer formulario permite ingresar un monto y seleccionar un medio de pago.
- El segundo formulario permite ingresar datos personales (nombre, apellido, correo, dirección, ciudad, RUT) y luego imprimirlos.

### 3. Implementa los siguientes escenarios de prueba

#### a) Validación de pago
- Ingresa diferentes valores de monto (positivo, cero, negativo) y verifica los mensajes de validación.
- Prueba con y sin seleccionar un medio de pago.
- Verifica que el mensaje mostrado sea el esperado según el caso.

#### b) Llenado de formulario de datos
- Completa todos los campos del formulario de datos personales.
- Haz clic en el botón "Imprimir datos".
- Verifica que todos los datos se impriman correctamente.

### 4. Detalles técnicos
- Usa Selenium WebDriver con ChromeDriver.
- Usa Cucumber para definir los escenarios en lenguaje Gherkin.
- Implementa los steps en Java.
- Utiliza WebDriverWait para esperar la visibilidad y clickabilidad de los elementos.
- Si ocurre un error al buscar un campo, guarda el HTML de la página en un archivo `pagina_error.html` para facilitar la depuración.
- El proyecto ya incluye la solución en el archivo `PagoSteps.java`.

### 5. Ejecución
- Ejecuta los tests con Maven:
  ```sh
  mvn clean test
  ```