package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "manage_menu_role")
public class ManageMenuRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 菜单表ID
     */
    @Column(name = "menuId")
    private Integer menuid;

    /**
     * 角色表ID
     */
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
     * 获取菜单表ID
     *
     * @return menuId - 菜单表ID
     */
    public Integer getMenuid() {
        return menuid;
    }

    /**
     * 设置菜单表ID
     *
     * @param menuid 菜单表ID
     */
    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    /**
     * 获取角色表ID
     *
     * @return roleId - 角色表ID
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * 设置角色表ID
     *
     * @param roleid 角色表ID
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
        sb.append(", menuid=").append(menuid);
        sb.append(", roleid=").append(roleid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}