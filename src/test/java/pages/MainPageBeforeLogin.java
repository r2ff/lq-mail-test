package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPageBeforeLogin {

    private SelenideElement loginInput = $("[data-testid=login-input]");
    private SelenideElement enterPasswordButton = $("[data-testid=enter-password]");
    private SelenideElement passwordInput = $("[data-testid=password-input]");
    private SelenideElement loginToMailButton = $("[data-testid=login-to-mail]");

    @Step("Вводим логин: {login}")
    public MainPageBeforeLogin enterLogin(String login) {
        loginInput.setValue(login);
        return this;
    }

    @Step("Нажимаем кнопку 'Ввести пароль'")
    public MainPageBeforeLogin pressPasswordButton() {
        enterPasswordButton.click();
        return this;
    }

    @Step("Вводим пароль")
    public MainPageBeforeLogin enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Нажимаем кнопку 'Войти'")
    public MainPageAfterLogin pressLoginButton() {
        loginToMailButton.click();
        return new MainPageAfterLogin();
    }
}
