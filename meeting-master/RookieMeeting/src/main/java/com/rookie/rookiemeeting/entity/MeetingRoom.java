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
 * 会议室实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("meeting_room")
public class MeetingRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会议室ID (主键)
     */
    @TableId(value = "roomid", type = IdType.AUTO)
    private Integer roomid;  // 注意类型为 Integer，与 Controller 中的 @PathVariable 匹配

    /**
     * 会议室名称
     */
    @TableField("roomname")
    private String roomname;

    /**
     * 会议室编号
     */
    @TableField("roomnum")
    private String roomnum;

    /**
     * 会议室容量
     */
    private Integer capacity;

    /**
     * 会议室状态 (0:禁用, 1:可用)
     */
    private Integer status;

    /**
     * 位置信息
     */
    private String location;

    /**
     * 设备信息
     */
    private String equipment;

    // 其他可能存在的字段...
}