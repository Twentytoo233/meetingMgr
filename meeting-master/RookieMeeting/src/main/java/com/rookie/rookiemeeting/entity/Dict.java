package com.rookie.rookiemeeting.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 字典实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("dict")
public class Dict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 字典类型
     */
    private String type;

    /**
     * 字典值（根据业务需要添加）
     */
    private String value;

    /**
     * 图标类名（根据业务需要添加）
     */
    private String icon;

    /**
     * 排序字段（根据业务需要添加）
     */
    private Integer sort;

    /**
     * 状态（0-禁用 1-启用）
     */
    private Integer status;

    // 其他可能存在的字段...
}