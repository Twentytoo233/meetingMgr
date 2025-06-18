package com.rookie.rookiemeeting.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 角色菜单关联实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role_menu")  // 更新表名为 sys_role_menu
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     * 注意：XML 中没有使用主键字段，但通常表中应有主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色ID
     * 对应 XML 中的 role_id 字段
     */
    @TableField("role_id")  // 明确指定数据库字段名
    private Integer roleId;

    /**
     * 菜单ID
     * 对应 XML 中的 menu_id 字段
     */
    @TableField("menu_id")  // 明确指定数据库字段名
    private Integer menuId;
}