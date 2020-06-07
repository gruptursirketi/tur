/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Araclar;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Sinem
 */
public class AraclarDAO extends DBConnection {

    public void create(Araclar s) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into araclar (arac_marka , arac_plaka) values('" + s.getArac_marka() + "' , '" + s.getArac_plaka() + "'  ) ");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public List<Araclar> read() {
        List<Araclar> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from araclar order by arac_id asc");
            while (rs.next()) {
                Araclar tmp = new Araclar(rs.getInt("arac_id"), rs.getString("arac_marka"), rs.getString("arac_plaka"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return list;
    }

    public void update(Araclar s) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update araclar set arac_marka='" + s.getArac_marka() + "' , arac_plaka='" + s.getArac_plaka() + "' where arac_id=" + s.getArac_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void delete(Araclar s) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from araclar where arac_id=" + s.getArac_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    } 

    //public void create(Araclar entity) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    
}
