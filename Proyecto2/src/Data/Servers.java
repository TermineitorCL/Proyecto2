/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin2016
 */
@Entity
@Table(name = "servers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servers.findAll", query = "SELECT s FROM Servers s")
    , @NamedQuery(name = "Servers.findByServername", query = "SELECT s FROM Servers s WHERE s.servername = :servername")
    , @NamedQuery(name = "Servers.findByHost", query = "SELECT s FROM Servers s WHERE s.host = :host")
    , @NamedQuery(name = "Servers.findByDb", query = "SELECT s FROM Servers s WHERE s.db = :db")
    , @NamedQuery(name = "Servers.findByUsername", query = "SELECT s FROM Servers s WHERE s.username = :username")
    , @NamedQuery(name = "Servers.findByPassword", query = "SELECT s FROM Servers s WHERE s.password = :password")
    , @NamedQuery(name = "Servers.findByPort", query = "SELECT s FROM Servers s WHERE s.port = :port")
    , @NamedQuery(name = "Servers.findBySocket", query = "SELECT s FROM Servers s WHERE s.socket = :socket")
    , @NamedQuery(name = "Servers.findByWrapper", query = "SELECT s FROM Servers s WHERE s.wrapper = :wrapper")
    , @NamedQuery(name = "Servers.findByOwner", query = "SELECT s FROM Servers s WHERE s.owner = :owner")})
public class Servers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Server_name")
    private String servername;
    @Basic(optional = false)
    @Column(name = "Host")
    private String host;
    @Basic(optional = false)
    @Column(name = "Db")
    private String db;
    @Basic(optional = false)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "Port")
    private int port;
    @Basic(optional = false)
    @Column(name = "Socket")
    private String socket;
    @Basic(optional = false)
    @Column(name = "Wrapper")
    private String wrapper;
    @Basic(optional = false)
    @Column(name = "Owner")
    private String owner;

    public Servers() {
    }

    public Servers(String servername) {
        this.servername = servername;
    }

    public Servers(String servername, String host, String db, String username, String password, int port, String socket, String wrapper, String owner) {
        this.servername = servername;
        this.host = host;
        this.db = db;
        this.username = username;
        this.password = password;
        this.port = port;
        this.socket = socket;
        this.wrapper = wrapper;
        this.owner = owner;
    }

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getWrapper() {
        return wrapper;
    }

    public void setWrapper(String wrapper) {
        this.wrapper = wrapper;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servername != null ? servername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servers)) {
            return false;
        }
        Servers other = (Servers) object;
        if ((this.servername == null && other.servername != null) || (this.servername != null && !this.servername.equals(other.servername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Servers[ servername=" + servername + " ]";
    }
    
}
