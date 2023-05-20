package pro.sky.junittest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    String login = "loginTest";
    String email = "user@test.com";
    String invalidLogin = "";
    String invalidEmail = "usernotinvalidcom";
    User userTest = new User(login, email);

    @Test
    @DisplayName("Создание пользователя с параметрами")
    void shouldCreateUserWithParameters() {
        Assertions.assertEquals(login, userTest.getLogin());
        Assertions.assertEquals(email, userTest.getEmail());
    }

    @Test
    @DisplayName("создание пользователя без параметров")    //проверка на пустой ввод
    void shouldCheckUserCreationWithoutParameters() {
        User userWithNoParamsTest = new User();
        Assertions.assertNull(userWithNoParamsTest.getLogin(), "Логин не может быть пустым");
        Assertions.assertNull(userWithNoParamsTest.getEmail(), "email не может быть пустым");
    }

    @Test
    @DisplayName("Проверка email")              //проверка мыла на совпадение с заранее созданым не верным вводом
    void shouldValidateCharsInEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new User(login, invalidEmail);
        }, "email должен быть неверный для вывода данного сообщения");
    }

    @Test
    @DisplayName("проверка логина")             //проверка логина на совпадение с заранее созданым не верным вводом
    void shouldValidateCharsInLogin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new User(invalidLogin, email);
        }, "Логин быть неверный для вывода данного сообщения");
    }

    @Test
    @DisplayName("Провека на совпадение логина и почты")        //проверка на совпадение логина и мыла
    void shouldCheckThatLoginAndEmailAreNotEqual() {
        Assertions.assertNotEquals(userTest.getLogin(), userTest.getEmail(), "Логин и email должны отличаться");
    }
}