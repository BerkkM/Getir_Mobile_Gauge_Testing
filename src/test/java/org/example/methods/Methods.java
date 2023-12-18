package org.example.methods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.BaseTest;
import org.example.base.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Methods extends BaseTest {

    AppiumDriver driver;
    FluentWait<AppiumDriver> wait;
    Actions actions;
    Logger logger = LogManager.getLogger(Methods.class);

    public Methods() {
        driver = appiumDriver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        actions = new Actions(driver);
    }
    public MobileElement findElement(By by) {
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        highlightElement(element);
        return element;
    }

    public void waitForElementToBeClickable(String key, String selector) {
        By by = getBy(key, selector);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        logger.info(key + " elementinin tıklanabilir olması bekleniyor.");
    }

    public By getBy(String key, String selector) {
        if (selector.equals("xpath")) {
            return By.xpath(key);
        } else {
            return By.id(key);
        }
    }

    public MobileElement findElementBykey(String key, String selector) {
        MobileElement element;
        if (selector.equals("xpath")) {
            element = findElement(By.xpath(key));
        } else {
            element = findElement(By.id(key));
        }
        highlightElement(element); // Elementi bulduktan sonra vurgula
        return element;
    }

    public void highlightElement(MobileElement element) {
        try {
            // Elementin etrafına sarı bir çerçeve çizmek için bir JavaScript kodu kullanılır
            String script = "arguments[0].style.border='2px solid yellow'";
            ((AppiumDriver) driver).executeScript(script, element);
        } catch (Exception e) {
            logger.error("Error while highlighting element", e);
        }
    }



    public void click(String key, String selector) {
        findElementBykey(key, selector).click();
        logger.info(key + " Butonuna tiklandi");
    }

    public List<WebElement> findListElementsByKey(String key, String selector) {
        By by;

        switch (selector.toLowerCase()) {
            case "id":
                by = By.id(key);
                break;
            case "xpath":
                by = By.xpath(key);
                break;
            // Diğer seçenekler de eklenebilir
            default:
                throw new IllegalArgumentException("Geçersiz selector: " + selector);
        }

        return driver.findElements(by);
    }

    public void waitForSeconds(int duration) {
        try {
            TimeUnit.SECONDS.sleep(duration);
            logger.info("Waited for {} seconds", duration);
        } catch (InterruptedException e) {
            logger.error("Error while waiting", e);
        }
    }

    public void clickByCoordinates(int x, int y) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(x, y)).perform();
        logger.info("Clicked on coordinates X: {}, Y: {}", x, y);
    }

    public boolean isLiveSupportTextVisible() {
        try {
            MobileElement liveSupportElement = findElement(By.xpath(Constans.LIVE_SUPPORT_XPATH));
            String liveSupportText = liveSupportElement.getText();
            return liveSupportText.equals("Canlı Destek");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void sendKeys(String key, String selector, String text) {
        try {
            MobileElement element = findElementBykey(key, selector);

            if (element.isDisplayed() && element.isEnabled()) {
                highlightElement(element);
                element.clear();
                element.sendKeys(text);
                logger.info("Typed '{}' in the element with key: '{}'", text, key);
            } else {
                logger.error("Element is not displayed or not enabled. Key: '{}'", key);
            }
        } catch (Exception e) {
            logger.error("Error while typing in the element. Key: '{}'", key, e);
        }
    }



    public void clickRandomElement(List<WebElement> elements, Methods methods) {
        try {
            if (elements.size() > 0) {
                Random random = new Random();
                int randomIndex = random.nextInt(elements.size());
                MobileElement randomElement = (MobileElement) elements.get(randomIndex);
                methods.click(randomElement);
                logger.info("Clicked on a random element");
            } else {
                logger.error("No elements found to click");
            }
        } catch (Exception e) {
            logger.error("Error while clicking on a random element", e);
        }
    }

    public void click(MobileElement element) {
        element.click();
        logger.info("Element clicked");
    }

    public boolean isTopAlertMessageVisible() {
        try {
            MobileElement alertMessage = findElement(By.xpath(Constans.TOP_ALERT_MESSAGE_XPATH));
            return alertMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }











}
