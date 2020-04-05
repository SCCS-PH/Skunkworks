
package com.hccs.skunkworks.jpa.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DCSalenga
 */
@Entity
@Table(name = "commands")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommandBean.findAll", query = "SELECT c FROM CommandBean c")
    , @NamedQuery(name = "CommandBean.findByCommandid", query = "SELECT c FROM CommandBean c WHERE c.commandid = :commandid")
    , @NamedQuery(name = "CommandBean.findByName", query = "SELECT c FROM CommandBean c WHERE c.name = :name")
    , @NamedQuery(name = "CommandBean.findByExtension", query = "SELECT c FROM CommandBean c WHERE c.extension = :extension")
    , @NamedQuery(name = "CommandBean.findByCommand", query = "SELECT c FROM CommandBean c WHERE c.command = :command")
    , @NamedQuery(name = "CommandBean.findByDescription", query = "SELECT c FROM CommandBean c WHERE c.description = :description")
    , @NamedQuery(name = "CommandBean.findByActive", query = "SELECT c FROM CommandBean c WHERE c.active = :active")})
public class CommandBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "command_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "command_sequence", sequenceName = "command_sequence", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "commandid")
    private Integer commandid;
    @Column(name = "name")
    private String name;
    @Column(name = "extension")
    private String extension;
    @Column(name = "command")
    private String command;
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;

    public CommandBean() {
    }

    public CommandBean(Integer commandid) {
        this.commandid = commandid;
    }

    public Integer getCommandid() {
        return commandid;
    }

    public void setCommandid(Integer commandid) {
        this.commandid = commandid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commandid != null ? commandid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandBean)) {
            return false;
        }
        CommandBean other = (CommandBean) object;
        if ((this.commandid == null && other.commandid != null) || (this.commandid != null && !this.commandid.equals(other.commandid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }
    
}
