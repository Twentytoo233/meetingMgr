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
 * 会议参与者实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("meetingparticipants")  // 确保表名匹配
public class MeetingParticipants implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 会议ID
     */
    @TableField("meetingid")
    private Integer meetingid;

    /**
     * 员工ID
     */
    @TableField("employeeid")
    private Long employeeid;

    /**
     * 签到状态 (0:未签到, 1:已签到, 2:已补签)
     * XML 中更新操作设置为 1
     */
    private Integer status;

    /**
     * 签到时间 (XML 中命名为 checkintime)
     */
    @TableField("checkintime")
    private Date checkintime;

    /**
     * 签到地点
     */
    private String location;

    /**
     * 创建时间 (可选)
     */
    @TableField("create_time")
    private Date createTime;

    // ============== 业务方法 ==============

    /**
     * 执行签到操作
     * @param location 签到地点
     */
    public void signIn(String location) {
        this.status = 1;  // 已签到
        this.checkintime = new Date();
        this.location = location;
    }

    /**
     * 执行补签操作
     * @param location 签到地点
     * @param checkintime 补签时间
     */
    public void lateSignIn(String location, Date checkintime) {
        this.status = 2;  // 已补签
        this.checkintime = checkintime;
        this.location = location;
    }
}