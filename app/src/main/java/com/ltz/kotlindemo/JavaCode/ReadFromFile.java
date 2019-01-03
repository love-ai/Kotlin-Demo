package com.ltz.kotlindemo.JavaCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by xiaowei on 2019/1/3
 */
public class ReadFromFile {
    public static String readFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
}
