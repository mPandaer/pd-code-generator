package com.pandaer.marker.meta;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.json.JSONUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * 代码生成器元信息管理器
 */
public class MetaManager {
    private static volatile Meta meta;

    public static Meta getMeta() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        ClassPathResource classPathResource = new ClassPathResource("meta.json");
        String metaStr = FileUtil.readString(new File(classPathResource.getAbsolutePath()), StandardCharsets.UTF_8);
        return JSONUtil.toBean(metaStr,Meta.class);
    }
}
