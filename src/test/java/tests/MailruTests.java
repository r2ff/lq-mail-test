package tests;

import config.App;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPageBeforeLogin;

import static com.codeborne.selenide.Selenide.open;

public class MailruTests extends TestBase {

    @Test
    @DisplayName("Вход с логином и паролем в почту mail.ru и отправка письма")
    void loginWithCorrectUserAndPasswordTest() {

        MainPageBeforeLogin mainPageBeforeLogin = open("https://mail.ru/", MainPageBeforeLogin.class);
        mainPageBeforeLogin
                .enterLogin(App.config.email())
                .pressPasswordButton()
                .enterPassword(App.config.password())
                .pressLoginButton()
                .composeNewMail()
                .fillMailTo(App.config.email())
                .fillSubject("Some text for Subject")
                .fillBodyText("Some text for Body")
                .pressSendButton()
                .checkMailSuccessfulSend();
    }
}