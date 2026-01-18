package com.bradorda.exception_handlers_II.models;

import java.util.Objects;

public class Usuario {

    private Long id;
    private Pessoa pessoa;
    private String login;
    private String password;

    public Usuario(Long id, Pessoa pessoa, String login, String password) {
        this.id = id;
        this.pessoa = pessoa;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(getId(), usuario.getId()) && Objects.equals(getPessoa(), usuario.getPessoa()) && Objects.equals(getLogin(), usuario.getLogin()) && Objects.equals(getPassword(), usuario.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPessoa(), getLogin(), getPassword());
    }
}
