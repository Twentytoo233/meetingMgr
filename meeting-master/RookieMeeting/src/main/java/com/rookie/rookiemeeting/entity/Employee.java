package com.rookie.rookiemeeting.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rookie.rookiemeeting.dto.LoginDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
     * 修改为 Integer 类型
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
     * 员工姓名 (对应 XML 中的 employeename)
     */
    @TableField("employeename")
    private String employeename;

    /**
     * 部门ID
     */
    @TableField("departmentid")
    private Integer departmentid;

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
     * 角色标识 (如：1-普通用户, 2-管理员)
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

    /**
     * 逻辑删除标志 (0:未删除, 1:已删除)
     */
    @TableField("is_delete")
    private Integer isDelete;

    // ============== 实用方法 ==============

    /**
     * 检查是否已录入人脸
     */
    public boolean isFaceRegistered() {
        return faceRegistered != null && faceRegistered;
    }

    /**
     * 转换为登录DTO对象
     */
    public LoginDto toLoginDto(String token, List<Menu> menus) {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmployeeid(this.employeeid);
        loginDto.setUsername(this.username);
        loginDto.setEmployeename(this.employeename);
        loginDto.setRole(this.role);
        loginDto.setToken(token);
        loginDto.setMenus(menus);
        return loginDto;
    }

    /**
     * 验证密码
     */
    public boolean validatePassword(String inputPassword, String salt) {
        String encryptedInput = DigestUtils.md5Hex(inputPassword + salt);
        return this.password.equals(encryptedInput);
    }

    /**
     * 是否已删除
     */
    public boolean isDeleted() {
        return isDelete != null && isDelete == 1;
    }
}