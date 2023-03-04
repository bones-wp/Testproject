package com.example.test.service;

import com.example.test.entity.User;
import com.example.test.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements UserDetailsService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return this.repository.getAll();
    }

    public User getByLogin(String login) {
        return this.repository.getByLogin(login);
    }

    /**
     * Поиск пользователя по логину, которого будем авторизовывать
     *
     * Полученного пользователя необходимо преобразовать в класс с реализацией интерфейса UserDetails или
     * воспользоваться уже готовой реализацией из пакета org.springframework.security.core.userdetails.
     * Последним параметром конструктора необходимо добавить список элементов GrantedAuthority, это роли пользователя,
     * у нас их нет, оставим его пустым. Если пользователя по логину не нашли, то бросаем исключение
     * UsernameNotFoundException.
     */
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = getByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(u.getLogin(), u.getPassword(),
                true, true, true, true, new HashSet<>());
    }
}
