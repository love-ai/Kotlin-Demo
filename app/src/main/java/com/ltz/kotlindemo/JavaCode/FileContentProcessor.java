package com.ltz.kotlindemo.JavaCode;

import java.io.File;
import java.util.List;

/**
 * Created by xiaowei on 2018/9/28
 */
public interface FileContentProcessor {
    void processContents(File path,
                         byte[] binaryContents,
                         List<String> textContents);
}
