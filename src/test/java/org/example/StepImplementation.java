package org.example;
import com.thoughtworks.gauge.Step;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.example.base.BaseTest;
import org.example.base.Constans;
import org.example.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;

import java.util.List;


public class StepImplementation extends BaseTest {

    Methods methods = new Methods();
    Logger logger = LogManager.getLogger(StepImplementation.class);


    @Step("Open the Getir application")
    public void loginPermission() {

    }

    @Step("Wait for <duration> seconds")
    public void waitForSeconds(int duration) {
        try {
            // Belirtilen süre kadar beklenir
            methods.waitForSeconds(duration);
            logger.info("Waited for {} seconds", duration);
        } catch (Exception e) {
            logger.error("Error while waiting", e);
        }
    }

    @Step("Click on the Get Started button")
    public void clickGetStartedButton() {
        try {
            // Get Started butonuna tanımlanan ID ile tıklanır
            methods.click(Constans.GET_STARTED_BUTTON_ID, "id");
            logger.info("Clicked on the Get Started button");
        } catch (Exception e) {
            logger.error("Error while clicking on the Get Started button", e);
        }
    }


        @Step("Click on the Continue as Guest button")
        public void clickContinueAsGuestButton() {
            try {
                // Continue as Guest butonuna tanımlanan ID ile tıklanır
                methods.click(Constans.CONTINUE_AS_GUEST_BUTTON_ID, "id");
                logger.info("Clicked on the Continue as Guest button");
            } catch (Exception e) {
                logger.error("Error while clicking on the Continue as Guest button", e);
            }
        }

        @Step("Click on the New Getir Icon")
        public void clickNewGetirIcon() {
            try {
                // Yeni Getir simgesine tanımlanan Xpath ile tıklanır
                methods.click(Constans.NEW_GETIR_ICON_XPATH, "xpath");
                logger.info("Clicked on the New Getir Icon");
            } catch (Exception e) {
                logger.error("Error while clicking on the New Getir Icon", e);
            }
        }

    @Step("Click on coordinates X: <x>, Y: <y>")
    public void clickByCoordinates(int x, int y) {
        try {
            methods.clickByCoordinates(x, y);
            logger.info("Clicked on coordinates X: {}, Y: {}", x, y);
        } catch (Exception e) {
            logger.error("Error while clicking on coordinates", e);
        }
    }
    @Step("Click on profile icon")
    public void clickProfileIcon() {
        try {
            methods.click(Constans.PROFILE_ICON_XPATH, "xpath");
            logger.info("Clicked on the profile icon");
        } catch (Exception e) {
            logger.error("Error while clicking on the profile icon", e);
        }
    }

    @Step("Click on the language button")
    public void clickLanguageButton() {
        try {
            methods.click(Constans.LANGUAGE_BUTTON_XPATH, "xpath");
            logger.info("Clicked on the language button");
        } catch (Exception e) {
            logger.error("Error while clicking on the language button", e);
        }
    }

    @Step("Click on the Turkish button")
    public void clickTurkishButton() {
        try {
            methods.click(Constans.TURKISH_BUTTON_XPATH, "xpath");
            logger.info("Clicked on the Turkish button");
        } catch (Exception e) {
            logger.error("Error while clicking on the Turkish button", e);
        }
    }

    @Step("Click on the Türkçe Profil")
    public void clickTurkishProfileButton() {
        try {
            methods.click(Constans.TURKISH_PROFILE_BUTTON_XPATH, "xpath");
            logger.info("Türkçe Profil butonuna tıklandı");
        } catch (Exception e) {
            logger.error("Türkçe Profil butonuna tıklanırken hata oluştu", e);
        }
    }
    @Step("Is the Canli Destek text visible?")
    public void isLiveSupportTextVisible() {
        try {
            boolean isLiveSupportTextVisible = methods.isLiveSupportTextVisible();
            if (isLiveSupportTextVisible) {
                logger.info("Canlı Destek metni görünüyor.");
            } else {
                logger.info("Canlı Destek metni görünmüyor.");
            }
        } catch (Exception e) {
            logger.error("Canlı Destek metni kontrolü sırasında hata oluştu", e);
        }
    }

    @Step("Click on the Adreslerim Button")
    public void clickAdreslerimButton() {
        try {
            methods.click(Constans.ADRESLERIM_BUTTON_XPATH, "xpath");
            logger.info("Clicked on the Adreslerim Button");
        } catch (Exception e) {
            logger.error("Error while clicking on the Adreslerim Button", e);
        }
    }
    @Step("Click on the Add Address Button")
    public void clickAddAddressButton() {
        try {
            methods.click(Constans.ADD_ADDRESS_BUTTON_XPATH, "xpath");
            logger.info("Clicked on the Add Address Button");
        } catch (Exception e) {
            logger.error("Error while clicking on the Add Address Button", e);
        }
    }
    @Step("Click on the Address Search EditText")
    public void clickAddressSearchEditText() {
        try {
            methods.click(Constans.ADDRESS_SEARCH_EDIT_TEXT_ID, "id");
            logger.info("Clicked on the Address Search EditText");
        } catch (Exception e) {
            logger.error("Error while clicking on the Address Search EditText", e);
        }
    }

    @Step("Type <text> in the Address Search EditText")
    public void typeTextInAddressSearchEditText(String text) {
        try {
            methods.sendKeys(Constans.ADDRESS_SEARCH_EDIT_TEXT_ID, "id", text);
            logger.info("Typed '{}' in the Address Search EditText", text);
        } catch (Exception e) {
            logger.error("Error while typing in the Address Search EditText", e);
        }
    }

    @Step("Click on a Random Element in the Address Search Results")
    public void clickRandomElementInAddressSearchResults() {
        try {
            // Listeyi bul
            List<WebElement> searchResults = methods.findListElementsByKey(Constans.ADDRESS_SEARCH_LIST_XPATH, "xpath");

            // Rastgele bir öğeyi seç ve tıkla
            methods.clickRandomElement(searchResults, methods);
        } catch (Exception e) {
            logger.error("Error while clicking on a random element in the Address Search Results", e);
        }
    }

    @Step("Click on the Sample Button")
    public void clickSampleButton() {
        try {
            methods.click(Constans.SAMPLE_BUTTON_XPATH, "xpath");
            logger.info("Clicked on the Sample Button");
        } catch (Exception e) {
            logger.error("Error while clicking on the Sample Button", e);
        }
    }

    @Step("Click on Element 5")
    public void clickElement5() {
        try {
            methods.click(Constans.ELEMENT5_XPATH, "xpath");
            methods.waitForSeconds(2);
            logger.info("Clicked on Element 5");
        } catch (Exception e) {
            logger.error("Error while clicking on Element 5", e);
        }
    }
    @Step("Click on the Address Detail Submit Button")
    public void clickAddressDetailSubmitButton() {
        try {
            methods.click(Constans.ADDRESS_DETAIL_SUBMIT_BUTTON_ID, "id");
            logger.info("Clicked on the Address Detail Submit Button");
        } catch (Exception e) {
            logger.error("Error while clicking on the Address Detail Submit Button", e);
        }
    }

    @Step("Check if the top alert message is visible")
    public void checkTopAlertMessageVisibility() {
        try {
            boolean isAlertVisible = methods.isTopAlertMessageVisible();
            if (isAlertVisible) {
                logger.info("Top alert message is visible");
            } else {
                logger.info("Top alert message is not visible");
            }
        } catch (Exception e) {
            logger.error("Error while checking top alert message visibility", e);
        }






















}}







