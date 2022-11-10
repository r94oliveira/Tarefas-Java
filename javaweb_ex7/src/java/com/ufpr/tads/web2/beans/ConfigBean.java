//Um Java Bean que contém dados de configuração da aplicação, no caso o e-mail do
//administrador.

package com.ufpr.tads.web2.beans;

import java.io.Serializable;

//Classe de configuração ConfigBran
public class ConfigBean implements Serializable {
    private String email;
    
    //variável email encapsulada
    public String getEmail() {
        return email;
    }
    
    //variável email encapsulada
    public void setEmail(String email) {
        this.email = email;
    }
}
