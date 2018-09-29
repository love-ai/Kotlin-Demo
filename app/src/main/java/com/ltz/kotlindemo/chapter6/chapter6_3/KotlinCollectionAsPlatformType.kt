package com.ltz.kotlindemo.chapter6.chapter6_3

import com.ltz.kotlindemo.JavaCode.DataParser
import com.ltz.kotlindemo.JavaCode.FileContentProcessor
import com.ltz.kotlindemo.chapter6.chapter6_2.Person
import java.io.File

/**
 * Created by xiaowei on 2018/9/28
 * kotlin调用java中的集合 作为平台类型的集合
 *
 * 作为破ing台类型的集合，kotlin在调用时要根据如下几个方面去判断用什么类型来表示
 * 集合是否可空?
 * 集合中的元素是否可空?
 * 你的方法会不会修改集合?
 *
 * 默认情况应该优先使用集合而不是数组
 */

class FileIndexer : FileContentProcessor {
    override fun processContents(path: File,
                                 binaryContents: ByteArray?,
                                 textContents: List<String>?) {
    }
}

class PersonParser : DataParser<Person> {
    override fun parseData(input: String,
                           output: MutableList<Person>,
                           errors: MutableList<String?>) {

    }

}