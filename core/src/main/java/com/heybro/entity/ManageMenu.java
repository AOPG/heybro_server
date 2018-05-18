package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "manage_menu")
public class ManageMenu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单地址
     */
    private String url;

    /**
     * 父ID
     */
    @Column(name = "pId")
    private Integer pid;

    /**
     * 图标地址
     */
    private String icon;

    private Integer grade;

    /**
     * 排序
     */
    @Column(name = "sortNo")
    private Integer sortno;

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
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取菜单地址
     *
     * @return url - 菜单地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单地址
     *
     * @param url 菜单地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取父ID
     *
     * @return pId - 父ID
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父ID
     *
     * @param pid 父ID
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取图标地址
     *
     * @return icon - 图标地址
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标地址
     *
     * @param icon 图标地址
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * @return grade
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * @param grade
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取排序
     *
     * @return sortNo - 排序
     */
    public Integer getSortno() {
        return sortno;
    }

    /**
     * 设置排序
     *
     * @param sortno 排序
     */
    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", pid=").append(pid);
        sb.append(", icon=").append(icon);
        sb.append(", grade=").append(grade);
        sb.append(", sortno=").append(sortno);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}