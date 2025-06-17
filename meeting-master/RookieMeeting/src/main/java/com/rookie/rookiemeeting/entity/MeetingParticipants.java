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
@TableName("meeting_participants")
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
     */
    private Integer status;

    /**
     * 签到时间
     */
    @TableField("sign_time")
    private Date signTime;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    // 其他可能存在的字段...
}