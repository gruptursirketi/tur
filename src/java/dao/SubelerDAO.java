/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Subeler;

import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Sinem
 */
public class SubelerDAO extends DBConnection {

    public void create(Subeler s) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into subeler (sube_il , sube_ilce , sube_isim) values('" + s.getSube_il() + "' , '" + s.getSube_ilce() + "'  ,'" + s.getSube_isim() + "'  ) ");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public List<Subeler> read() {
        List<Subeler> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from subeler order by sube_id asc");
            while (rs.next()) {
                Subeler tmp = new Subeler(rs.getInt("sube_id"), rs.getString("sube_il"), rs.getString("sube_ilce"), rs.getString("sube_isim"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return list;
    }

    public void update(Subeler s) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update subeler set sube_il='" + s.getSube_il() + "' , sube_ilce='" + s.getSube_ilce() + "' , sube_isim='" + s.getSube_isim() + "' where sube_id=" + s.getSube_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void delete(Subeler s) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from subeler where sube_id=" + s.getSube_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    //public void create(Subeler entity) {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // }
}
