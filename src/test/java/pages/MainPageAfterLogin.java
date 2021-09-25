package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPageAfterLogin {

    private SelenideElement newMail = $(byText("Написать письмо"));
    private SelenideElement mailTo = $(".container--H9L5q");
    private SelenideElement subject = $(byName("Subject"));
    private SelenideElement bodyMail = $("[role=textbox]");
    private SelenideElement sendButton = $("[title=Отправить]");
    private SelenideElement mailSuccessfulSend = $(".layer__link");
    private String successfulMessage = "Письмо отправлено";

    @Step("Нажимаем кнопку 'Написать письмо'")
    public MainPageAfterLogin composeNewMail() {
        newMail.click();
        return this;
    }

    @Step("Заполняем поле 'Получатель' {email}")
    public MainPageAfterLogin fillMailTo(String email) {
        mailTo.setValue(email);
        return this;
    }

    @Step("Заполняем поле 'Тема письма': {subjectText}")
    public MainPageAfterLogin fillSubject(String subjectText) {
        subject.setValue(subjectText);
        return this;
    }

    @Step("Заполняем поле 'Тело письма': {bodyText}")
    public MainPageAfterLogin fillBodyText(String bodyText) {
        bodyMail.setValue(bodyText);
        return this;
    }

    @Step("Нажимаем кнопку 'Отправить'")
    public MainPageAfterLogin pressSendButton() {
        sendButton.click();
        return this;
    }

    @Step("Проверяем что письмо успешно отправлено")
    public void checkMailSuccessfulSend() {
        mailSuccessfulSend.shouldHave(Condition.text(successfulMessage));
    }
}
