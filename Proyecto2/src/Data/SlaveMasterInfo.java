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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin2016
 */
@Entity
@Table(name = "slave_master_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SlaveMasterInfo.findAll", query = "SELECT s FROM SlaveMasterInfo s")
    , @NamedQuery(name = "SlaveMasterInfo.findByNumberoflines", query = "SELECT s FROM SlaveMasterInfo s WHERE s.numberoflines = :numberoflines")
    , @NamedQuery(name = "SlaveMasterInfo.findByMasterlogpos", query = "SELECT s FROM SlaveMasterInfo s WHERE s.masterlogpos = :masterlogpos")
    , @NamedQuery(name = "SlaveMasterInfo.findByHost", query = "SELECT s FROM SlaveMasterInfo s WHERE s.host = :host")
    , @NamedQuery(name = "SlaveMasterInfo.findByPort", query = "SELECT s FROM SlaveMasterInfo s WHERE s.port = :port")
    , @NamedQuery(name = "SlaveMasterInfo.findByConnectretry", query = "SELECT s FROM SlaveMasterInfo s WHERE s.connectretry = :connectretry")
    , @NamedQuery(name = "SlaveMasterInfo.findByEnabledssl", query = "SELECT s FROM SlaveMasterInfo s WHERE s.enabledssl = :enabledssl")
    , @NamedQuery(name = "SlaveMasterInfo.findBySslverifyservercert", query = "SELECT s FROM SlaveMasterInfo s WHERE s.sslverifyservercert = :sslverifyservercert")
    , @NamedQuery(name = "SlaveMasterInfo.findByHeartbeat", query = "SELECT s FROM SlaveMasterInfo s WHERE s.heartbeat = :heartbeat")
    , @NamedQuery(name = "SlaveMasterInfo.findByRetrycount", query = "SELECT s FROM SlaveMasterInfo s WHERE s.retrycount = :retrycount")
    , @NamedQuery(name = "SlaveMasterInfo.findByEnabledautoposition", query = "SELECT s FROM SlaveMasterInfo s WHERE s.enabledautoposition = :enabledautoposition")
    , @NamedQuery(name = "SlaveMasterInfo.findByChannelname", query = "SELECT s FROM SlaveMasterInfo s WHERE s.channelname = :channelname")})
public class SlaveMasterInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Number_of_lines")
    private int numberoflines;
    @Basic(optional = false)
    @Lob
    @Column(name = "Master_log_name")
    private String masterlogname;
    @Basic(optional = false)
    @Column(name = "Master_log_pos")
    private long masterlogpos;
    @Column(name = "Host")
    private String host;
    @Lob
    @Column(name = "User_name")
    private String username;
    @Lob
    @Column(name = "User_password")
    private String userpassword;
    @Basic(optional = false)
    @Column(name = "Port")
    private int port;
    @Basic(optional = false)
    @Column(name = "Connect_retry")
    private int connectretry;
    @Basic(optional = false)
    @Column(name = "Enabled_ssl")
    private boolean enabledssl;
    @Lob
    @Column(name = "Ssl_ca")
    private String sslca;
    @Lob
    @Column(name = "Ssl_capath")
    private String sslcapath;
    @Lob
    @Column(name = "Ssl_cert")
    private String sslcert;
    @Lob
    @Column(name = "Ssl_cipher")
    private String sslcipher;
    @Lob
    @Column(name = "Ssl_key")
    private String sslkey;
    @Basic(optional = false)
    @Column(name = "Ssl_verify_server_cert")
    private boolean sslverifyservercert;
    @Basic(optional = false)
    @Column(name = "Heartbeat")
    private float heartbeat;
    @Lob
    @Column(name = "Bind")
    private String bind;
    @Lob
    @Column(name = "Ignored_server_ids")
    private String ignoredserverids;
    @Lob
    @Column(name = "Uuid")
    private String uuid;
    @Basic(optional = false)
    @Column(name = "Retry_count")
    private long retrycount;
    @Lob
    @Column(name = "Ssl_crl")
    private String sslcrl;
    @Lob
    @Column(name = "Ssl_crlpath")
    private String sslcrlpath;
    @Basic(optional = false)
    @Column(name = "Enabled_auto_position")
    private boolean enabledautoposition;
    @Id
    @Basic(optional = false)
    @Column(name = "Channel_name")
    private String channelname;
    @Lob
    @Column(name = "Tls_version")
    private String tlsversion;

    public SlaveMasterInfo() {
    }

    public SlaveMasterInfo(String channelname) {
        this.channelname = channelname;
    }

    public SlaveMasterInfo(String channelname, int numberoflines, String masterlogname, long masterlogpos, int port, int connectretry, boolean enabledssl, boolean sslverifyservercert, float heartbeat, long retrycount, boolean enabledautoposition) {
        this.channelname = channelname;
        this.numberoflines = numberoflines;
        this.masterlogname = masterlogname;
        this.masterlogpos = masterlogpos;
        this.port = port;
        this.connectretry = connectretry;
        this.enabledssl = enabledssl;
        this.sslverifyservercert = sslverifyservercert;
        this.heartbeat = heartbeat;
        this.retrycount = retrycount;
        this.enabledautoposition = enabledautoposition;
    }

    public int getNumberoflines() {
        return numberoflines;
    }

    public void setNumberoflines(int numberoflines) {
        this.numberoflines = numberoflines;
    }

    public String getMasterlogname() {
        return masterlogname;
    }

    public void setMasterlogname(String masterlogname) {
        this.masterlogname = masterlogname;
    }

    public long getMasterlogpos() {
        return masterlogpos;
    }

    public void setMasterlogpos(long masterlogpos) {
        this.masterlogpos = masterlogpos;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getConnectretry() {
        return connectretry;
    }

    public void setConnectretry(int connectretry) {
        this.connectretry = connectretry;
    }

    public boolean getEnabledssl() {
        return enabledssl;
    }

    public void setEnabledssl(boolean enabledssl) {
        this.enabledssl = enabledssl;
    }

    public String getSslca() {
        return sslca;
    }

    public void setSslca(String sslca) {
        this.sslca = sslca;
    }

    public String getSslcapath() {
        return sslcapath;
    }

    public void setSslcapath(String sslcapath) {
        this.sslcapath = sslcapath;
    }

    public String getSslcert() {
        return sslcert;
    }

    public void setSslcert(String sslcert) {
        this.sslcert = sslcert;
    }

    public String getSslcipher() {
        return sslcipher;
    }

    public void setSslcipher(String sslcipher) {
        this.sslcipher = sslcipher;
    }

    public String getSslkey() {
        return sslkey;
    }

    public void setSslkey(String sslkey) {
        this.sslkey = sslkey;
    }

    public boolean getSslverifyservercert() {
        return sslverifyservercert;
    }

    public void setSslverifyservercert(boolean sslverifyservercert) {
        this.sslverifyservercert = sslverifyservercert;
    }

    public float getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(float heartbeat) {
        this.heartbeat = heartbeat;
    }

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }

    public String getIgnoredserverids() {
        return ignoredserverids;
    }

    public void setIgnoredserverids(String ignoredserverids) {
        this.ignoredserverids = ignoredserverids;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getRetrycount() {
        return retrycount;
    }

    public void setRetrycount(long retrycount) {
        this.retrycount = retrycount;
    }

    public String getSslcrl() {
        return sslcrl;
    }

    public void setSslcrl(String sslcrl) {
        this.sslcrl = sslcrl;
    }

    public String getSslcrlpath() {
        return sslcrlpath;
    }

    public void setSslcrlpath(String sslcrlpath) {
        this.sslcrlpath = sslcrlpath;
    }

    public boolean getEnabledautoposition() {
        return enabledautoposition;
    }

    public void setEnabledautoposition(boolean enabledautoposition) {
        this.enabledautoposition = enabledautoposition;
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    public String getTlsversion() {
        return tlsversion;
    }

    public void setTlsversion(String tlsversion) {
        this.tlsversion = tlsversion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (channelname != null ? channelname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SlaveMasterInfo)) {
            return false;
        }
        SlaveMasterInfo other = (SlaveMasterInfo) object;
        if ((this.channelname == null && other.channelname != null) || (this.channelname != null && !this.channelname.equals(other.channelname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.SlaveMasterInfo[ channelname=" + channelname + " ]";
    }
    
}
