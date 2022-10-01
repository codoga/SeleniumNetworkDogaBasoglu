package com.network;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElements {

    public static WebDriver driver;
    public WebElements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement aramaAlaninaYaz(){
        return driver.findElement(By.name("searchKey"));
    }

    public WebElement hepsiniKabulEt(){
        return driver.findElement(By.id("onetrust-accept-btn-handler"));
    }

    public WebElement DahaFazlaGosterButonunaTikla(){
        return driver.findElement(By.cssSelector("button[class='button -secondary -sm relative']"));
    }

    public WebElement indirimliIlkUruneGit(){
        return driver.findElement(By.xpath("(//span[@class='product__price -label -old -size'])[1]"));
    }

    public WebElement indirimliUrundeilkBedenTikla(){
        return driver.findElement(By.xpath("(//label[@class='radio-box__label '])[1]"));
    }

    public WebElement sepeteGitButonuTikla(){
        return driver.findElement(By.xpath("//a[text()='Sepete Git']"));
    }

    public WebElement eskiFiyatiAl(){
        return driver.findElement(By.cssSelector("span[class='cartItem__price -old -labelPrice']"));
    }

    public WebElement indirimliFiyatiAl(){
        return driver.findElement(By.cssSelector("span[class='cartItem__price -sale']"));
    }

    public WebElement devamEtButonuTikla(){
        return driver.findElement(By.cssSelector("button[class='continueButton n-button large block text-center -primary']"));
    }

    public WebElement emailYaz(){
        return driver.findElement(By.id("n-input-email"));
    }

    public WebElement sifreYaz(){
        return driver.findElement(By.id("n-input-password"));
    }

    public WebElement girisYapButonuKontrol(){
        return driver.findElement(By.cssSelector("button[class='n-button large block text-center -primary ']"));
    }

    public WebElement networkLogoTikla(){
        return driver.findElement(By.cssSelector("svg[class='headerCheckout__logo__img']"));
    }

    public WebElement cantaLogosuTikla(){
        return driver.findElement(By.cssSelector("button[class='header__basketTrigger js-basket-trigger -desktop']"));
    }

    public WebElement copKutusuIconTikla(){
        return driver.findElement(By.cssSelector("svg[class='header__basketProductRemove']"));
    }

    public WebElement sepettenCikartButonu(){
        return driver.findElement(By.cssSelector("button[class='btn -black o-removeCartModal__button']"));
    }

    public WebElement sepetinizBosTexti(){
        return driver.findElement(By.xpath("//span[text()='Sepetiniz Henüz Boş']"));
    }



}
