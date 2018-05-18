package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "manage_user_role")
public class ManageUserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "backendUserId")
    private Integer backenduserid;

    @Column(name = "roleId")
    private Integer roleid;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return backendUserId
     */
    public Integer getBackenduserid() {
        return backenduserid;
    }

    /**
     * @param backenduserid
     */
    public void setBackenduserid(Integer backenduserid) {
        this.backenduserid = backenduserid;
    }

    /**
     * @return roleId
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", backenduserid=").append(backenduserid);
        sb.append(", roleid=").append(roleid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}