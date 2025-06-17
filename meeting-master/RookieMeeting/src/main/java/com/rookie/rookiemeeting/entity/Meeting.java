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
    private Integer meetingid;  // 注意类型为 Integer，与 Controller 中的 @PathVariable 匹配

    /**
     * 会议标题
     */
    private String title;

    /**
     * 会议描述
     */
    private String description;

    /**
     * 会议室ID
     */
    @TableField("room_id")
    private Long roomId;

    /**
     * 组织者ID
     */
    @TableField("organizer_id")
    private Long organizerId;

    /**
     * 开始时间
     */
    @TableField("start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    private Date endTime;

    /**
     * 预定时间
     */
    @TableField("reservationtime")
    private Date reservationtime;

    /**
     * 会议状态 (0:待进行, 1:进行中, 2:已完成, 3:已取消)
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    // 其他可能存在的字段...
}