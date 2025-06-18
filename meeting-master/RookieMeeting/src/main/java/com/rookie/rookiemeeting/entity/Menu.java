package com.rookie.rookiemeeting.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID (主键)
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 图标类名
     */
    private String icon;

    /**
     * 菜单描述
     */
    private String description;

    /**
     * 父菜单ID
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 菜单类型 (0:目录, 1:菜单, 2:按钮)
     */
    private Integer type;

    /**
     * 组件路径
     */
    private String component;

    // ================ 树形结构支持 ================

    /**
     * 子菜单列表（非数据库字段）
     */
    @TableField(exist = false)
    private List<Menu> children;

    /**
     * 获取父菜单ID（兼容 pid 方法调用）
     */
    public Integer getPid() {
        return this.parentId;
    }

    /**
     * 设置父菜单ID（兼容 pid 方法调用）
     */
    public void setPid(Integer pid) {
        this.parentId = pid;
    }
    // 其他可能存在的字段...

}