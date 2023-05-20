package pro.sky.junittest.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class User {
    public String login;
    public String email;

    //Дефолтный конструктор;
    public User() {
    }

    //Конструктор с параметрами;
    public User(String login, String email) {
        if(!StringUtils.isAlpha(login)){
            throw new IllegalArgumentException("Логин пользователя введен не верно");   //реализовал исключения для не правильного ввода.
        }else {
            this.login = login;
        }
        if(email.contains("@")&& email.contains(".")){
            this.email = email;
        }else {
            throw new IllegalArgumentException("В введеном адресе отсутсвуют необходимые знаки '@' и '.'");    //реализовал исключения для не правильного ввода.
        }
    }

    //Getters
    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    //equals and hashCode for test on JUnit;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(login, that.login) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email);
    }
}
