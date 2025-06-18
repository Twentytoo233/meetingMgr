package com.rookie.rookiemeeting.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工ID (主键)
     */
    @TableId(value = "employeeid", type = IdType.AUTO)
    private Long employeeid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码 (MD5加密存储)
     */
    private String password;

    /**
     * 真实姓名 (对应DTO中的employeename)
     */
    @TableField("real_name")
    private String realName;

    /**
     * 部门ID
     */
    @TableField("department_id")
    private Integer departmentId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态 (0:未审批, 1:正常, 2:审批未通过)
     */
    private Integer status;

    /**
     * 角色 (用于权限管理)
     * 存储角色标识（如：1-普通用户, 2-管理员）
     */
    private String role;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 人脸照片路径
     */
    @TableField("face_photo")
    private String facePhoto;

    /**
     * 是否已录入人脸
     */
    @TableField("face_registered")
    private Boolean faceRegistered;

    // 其他可能存在的字段...

    /**
     * 检查是否已录入人脸
     */
    public boolean isFaceRegistered() {
        return faceRegistered != null && faceRegistered;
    }

    /**
     * 获取角色描述（用于EasyPoi导出）
     */
    public String getRoleDescription() {
        if ("1".equals(role)) {
            return "普通用户";
        } else if ("2".equals(role)) {
            return "管理员";
        }
        return role;
    }

    /**
     * 获取状态描述（用于EasyPoi导出）
     */
    public String getStatusDescription() {
        switch (status) {
            case 0: return "未审批";
            case 1: return "正常";
            case 2: return "审批未通过";
            default: return String.valueOf(status);
        }
    }
}