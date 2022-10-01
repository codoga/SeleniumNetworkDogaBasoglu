package com.network;

import Utilities.Log4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.*;

public class NetworkTest {
    public static WebDriver driver;
    public static String url;
    public static WebElements webElements;
    private static Logger log  = Logger.getLogger(Log4j.class.getName());

    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\OneDrive\\Masaüstü\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        url = "https://www.network.com.tr/";
        webElements = new WebElements(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testing() throws InterruptedException {
        Actions opendriver = new Actions(driver);
        driver.get(url);
        assertTrue("URL yanlis",url.equals("https://www.network.com.tr/"));
        log.info("Tarayıcı açıldı ve URL kontrol edildi.");

        WebElement kabulEt = webElements.hepsiniKabulEt();
        kabulEt.click();
        log.info("Tüm çerezleri kabul et butonu tıklandı.");

        WebElement aramaAlani = webElements.aramaAlaninaYaz();
        aramaAlani.sendKeys("ceket");
        aramaAlani.sendKeys(Keys.ENTER);
        log.info("Arama alanına ceket yazıldı ve enter tıklandı.");

        WebElement dahaFazlaGosterButonu = webElements.DahaFazlaGosterButonunaTikla();
        Actions action = new Actions(driver);
        action.moveToElement(dahaFazlaGosterButonu);
        action.perform();
        dahaFazlaGosterButonu.click();
        log.info("Daha fazla göster butonu bulundu ve tıklandı.");

        Thread.sleep(5000);
        String strUrl = driver.getCurrentUrl();
        assertTrue("URL yanlis", strUrl.equals("https://www.network.com.tr/search?searchKey=ceket&page=2"));
        log.info("Yeni URL kontrol edildi.");

        WebElement indirimliIlkUrun = webElements.indirimliIlkUruneGit();
        Actions action1 = new Actions(driver);
        action1.moveToElement(indirimliIlkUrun);
        action1.perform();
        log.info("İndirimli ilk ürüne gidildi.");

        WebElement indirimliUrundeIlkBeden = webElements.indirimliUrundeilkBedenTikla();
        indirimliUrundeIlkBeden.click();
        log.info("İndirimli ilk üründe beden seçildi.");

        WebElement sepeteGitButonu = webElements.sepeteGitButonuTikla();
        sepeteGitButonu.click();
        log.info("Sepete Git butonu tıklandı.");

        Thread.sleep(5000);
        String eskiFiyat = webElements.eskiFiyatiAl().getText();
        String indirimliFiyat = webElements.indirimliFiyatiAl().getText();
        eskiFiyat = eskiFiyat.replaceAll(" TL","");
        eskiFiyat = eskiFiyat.replaceAll("\\.","");
        eskiFiyat = eskiFiyat.replaceAll("\\,","");
        indirimliFiyat = indirimliFiyat.replaceAll(" TL","");
        indirimliFiyat = indirimliFiyat.replaceAll("\\.","");
        indirimliFiyat = indirimliFiyat.replaceAll("\\,","");
        int indirimsizValue = parseInt(eskiFiyat);
        int indirimliValue = parseInt(indirimliFiyat);
        assertTrue("Eski fiyat indirimli fiyattan büyük değil",indirimsizValue > indirimliValue);
        log.info("Eski fiyatın indirimli fiyattan büyük olduğu kontrol edildi.");

        WebElement devamEtButonu = webElements.devamEtButonuTikla();
        devamEtButonu.click();
        log.info("Devam Et butonu tıklandı.");

        WebElement email = webElements.emailYaz();
        email.sendKeys("doga53gs@gmail.com");
        log.info("Email yazıldı.");

        WebElement sifre = webElements.sifreYaz();
        sifre.sendKeys("Sifre123");
        log.info("Şifre yazıldı.");

        WebElement girisYapButonu = webElements.girisYapButonuKontrol();
        assertTrue("Buton sayfada bulunamadı",girisYapButonu.isDisplayed());
        log.info("Giriş Yap butonu kontrol edildi.");

        WebElement networkLogo = webElements.networkLogoTikla();
        networkLogo.click();
        log.info("Network logosu tıklandı.");

        WebElement cantaLogosu = webElements.cantaLogosuTikla();
        cantaLogosu.click();
        log.info("Çanta iconu tıklandı.");

        WebElement copKutusuIconu = webElements.copKutusuIconTikla();
        copKutusuIconu.click();
        log.info("Sil butonu tıklandı.");

        WebElement cikartButonu = webElements.sepettenCikartButonu();
        cikartButonu.click();
        log.info("Çıkart butonu tıklandı.");

        WebElement cantaLogosu1 = webElements.cantaLogosuTikla();
        cantaLogosu1.click();
        log.info("Çanta iconu tıklandı.");

        Thread.sleep(2000);
        WebElement sepetinizBosText = webElements.sepetinizBosTexti();
        assertTrue("Sepetiniz bos degil", sepetinizBosText.isDisplayed());
        log.info("Sepetiniz boş texti bulundu.");
    }

    @After
    public void afterTest(){
        driver.manage().timeouts().implicitlyWait(800,TimeUnit.SECONDS);
        driver.quit();
    }

}
