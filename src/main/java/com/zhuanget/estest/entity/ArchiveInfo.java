package com.zhuanget.estest.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Zhuang_ET
 * @since 2020-12-30 10:29:21
 */
@Data
@Accessors(chain = true)
public class ArchiveInfo {

    private Long id;

    private String aid;

    private String name;

    private String cid;
}
