package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();

        //Acceder URL
        driver.get("https://www.google.com/");

        //Acceptar cookies
        driver.findElement(By.id("L2AGLb")).click();

        //Identificar cuadro de texto de busqueda, introducir texto y darle a ENTER para buscar
        WebElement textBox = driver.findElement(By.id("APjFqb"));
        textBox.sendKeys("automatización");
        textBox.sendKeys(Keys.ENTER);

        //Buscar enlace que contenga URL de wikipedia y hacer click para entrar
        driver.findElement(By.cssSelector("a[href*='es.wikipedia.org']")).click();

        //Extraer todos los parrafos (p) y mostrar por pantalla el que contenga "primer proceso industrial" con la fecha deseada
        List<WebElement> todosParrafos = driver.findElements(By.tagName("p"));
        for(WebElement e : todosParrafos) {
            if(e.getText().contains("primer proceso industrial")){
                System.out.println(e.getText());
            }
        }

        //Tomar captura de pantalla y copiar en directorio temporal en C:\temp
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile , new File("C:\\temp\\screenshot.png"));

        //Terminar la prueba cerrando el navegador
        driver.close();

    }
}