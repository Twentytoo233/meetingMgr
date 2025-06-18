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
 * 会议实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("meeting")
public class Meeting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会议ID (主键)
     */
    @TableId(value = "meetingid", type = IdType.AUTO)
    private Integer meetingid;

    /**
     * 会议名称
     */
    private String meetingname;

    /**
     * 会议室ID
     */
    @TableField("roomid")
    private Integer roomid;

    /**
     * 预定人ID (组织者ID)
     */
    @TableField("reservationistid")
    private Integer reservationistid;

    /**
     * 参会人数
     */
    @TableField("numberofparticipants")
    private Integer numberofparticipants;

    /**
     * 签到开始时间
     */
    @TableField("signinstarttime")
    private Date signinstarttime;

    /**
     * 签到结束时间
     */
    @TableField("signinendtime")
    private Date signinendtime;

    /**
     * 会议开始时间
     */
    @TableField("starttime")
    private Date starttime;

    /**
     * 会议结束时间
     */
    @TableField("endtime")
    private Date endtime;

    /**
     * 预定时间
     */
    @TableField("reservationtime")
    private Date reservationtime;

    /**
     * 取消时间
     */
    @TableField("canceledtime")
    private Date canceledtime;

    /**
     * 会议描述
     */
    private String description;

    /**
     * 会议状态 (0:正常, 1:已取消)
     */
    private Integer status;

    /**
     * 取消原因
     */
    @TableField("canceledreason")
    private String canceledreason;

    // 其他可能存在的字段...
}