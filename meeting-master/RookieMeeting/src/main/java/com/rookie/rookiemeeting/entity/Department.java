package com.rookie.rookiemeeting.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 部门实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID (主键)
     */
    @TableId(value = "departmentid", type = IdType.AUTO)
    private Integer departmentid;

    /**
     * 部门名称
     */
    private String departmentname;

    // 其他可能存在的字段（根据业务需要添加）
    // 例如：
    // private String description; // 部门描述
    // private Integer status;     // 部门状态
    // private Date createTime;    // 创建时间
}