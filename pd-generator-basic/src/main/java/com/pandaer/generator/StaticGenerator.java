package com.pandaer.generator;

import cn.hutool.core.io.FileUtil;

/**
 * 静态文件生成器
 * @author pandaer
 * 将静态文件从源目录复制到目标目录(默认项目根目录)
 */
public class StaticGenerator {

    /**
     * 生成静态文件
     * @param srcPath 源文件路径
     * @param destPath 目标文件路径
     */
    public static void generator(String srcPath,String destPath) {
        FileUtil.copy(srcPath,destPath,true);
    }
}
