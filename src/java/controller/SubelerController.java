/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SubelerDAO;
import entity.Subeler;
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
public class SubelerController implements Serializable {

    private SubelerDAO subedao;
    private Subeler entity;

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
        this.getSubedao().create(entity);
        this.entity = new Subeler();
        return "/subeler/index";
    }

    public List<Subeler> getRead() {
        return this.getSubedao().read();
    }

    public String updateForm(Subeler s) {
        this.entity = s;
        return "/subeler/update";
    }

    public String update() {
        this.getSubedao().update(entity);
        this.entity = new Subeler();
        return "/subeler/index";
    }

    public String deleteConfirm(Subeler s) {
        this.entity = s;
        return "/subeler/confirm_delete";
    }

    public String delete() {
        this.getSubedao().delete(entity);
        this.entity = new Subeler();
        return "/subeler/index";
    }

    public SubelerController() {
    }

    public SubelerDAO getSubedao() {
        if (this.subedao == null) {
            this.subedao = new SubelerDAO();
        }
        return subedao;
    }

    public void setSubedao(SubelerDAO subedao) {
        this.subedao = subedao;
    }

    public Subeler getEntity() {
        if (this.entity == null) {
            this.entity = new Subeler();
        }
        return entity;
    }

    public void setEntity(Subeler entity) {
        this.entity = entity;
    }

}
