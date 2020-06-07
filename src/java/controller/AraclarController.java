/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AraclarDAO;
import entity.Araclar;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author Sinem
 */
@Named
@SessionScoped
public class AraclarController implements Serializable {

    private AraclarDAO aracdao;
    private Araclar entity;

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String str = value.toString();
        if (str.length() < 2) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "summary", "en az 2 karakter giriniz"));
        }
        /*if (str.length() > 6) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "summary", "en fazla 6 karakter giriniz "));
        }*/
    }

    public String create() {
        this.getAracdao().create(entity);
        this.entity = new Araclar();
        return "/araclar/index";
    }

    public List<Araclar> getRead() {
        return this.getAracdao().read();
    }

    public String updateForm(Araclar s) {
        this.entity = s;
        return "/araclar/update";
    }

    public String update() {
        this.getAracdao().update(entity);
        this.entity = new Araclar();
        return "/araclar/index";
    }

    public String deleteConfirm(Araclar s) {
        this.entity = s;
        return "/araclar/confirm_delete";
    }

    public String delete() {
        this.getAracdao().delete(entity);
        this.entity = new Araclar();
        return "/araclar/index";
    }

    public AraclarController() {
    }

    public AraclarDAO getAracdao() {
        if (this.aracdao == null) {
            this.aracdao = new AraclarDAO();
        }
        return aracdao;
    }

    public void setAracdao(AraclarDAO aracdao) {
        this.aracdao = aracdao;
    }

    public Araclar getEntity() {
        if (this.entity == null) {
            this.entity = new Araclar();
        }
        return entity;
    }

    public void setEntity(Araclar entity) {
        this.entity = entity;
    }

}
