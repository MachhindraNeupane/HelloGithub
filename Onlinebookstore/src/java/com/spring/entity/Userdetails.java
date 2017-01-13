/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spring.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mac New
 */
@Entity
@Table(name = "userdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userdetails.findAll", query = "SELECT u FROM Userdetails u"),
    @NamedQuery(name = "Userdetails.findById", query = "SELECT u FROM Userdetails u WHERE u.id = :id"),
    @NamedQuery(name = "Userdetails.findByUsername", query = "SELECT u FROM Userdetails u WHERE u.username = :username"),
    @NamedQuery(name = "Userdetails.findByFirstname", query = "SELECT u FROM Userdetails u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Userdetails.findByLastname", query = "SELECT u FROM Userdetails u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Userdetails.findByPassword", query = "SELECT u FROM Userdetails u WHERE u.password = :password"),
    @NamedQuery(name = "Userdetails.findByGender", query = "SELECT u FROM Userdetails u WHERE u.gender = :gender"),
    @NamedQuery(name = "Userdetails.findByPhonenumber", query = "SELECT u FROM Userdetails u WHERE u.phonenumber = :phonenumber"),
    @NamedQuery(name = "Userdetails.findByCountry", query = "SELECT u FROM Userdetails u WHERE u.country = :country"),
    @NamedQuery(name = "Userdetails.findByState", query = "SELECT u FROM Userdetails u WHERE u.state = :state"),
    @NamedQuery(name = "Userdetails.findByCity", query = "SELECT u FROM Userdetails u WHERE u.city = :city"),
    @NamedQuery(name = "Userdetails.findByProfilepicture", query = "SELECT u FROM Userdetails u WHERE u.profilepicture = :profilepicture")})
public class Userdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "country")
    private String country;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "profilepicture")
    private String profilepicture;

    public Userdetails() {
    }

    public Userdetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userdetails)) {
            return false;
        }
        Userdetails other = (Userdetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.entity.Userdetails[ id=" + id + " ]";
    }
    
}
