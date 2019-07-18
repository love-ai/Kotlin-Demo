package com.ltz.kotlindemo.chapter3.chapter3_6
import com.ltz.stringutil.countStr1 as count
/**
 * Created by xiaowei on 2018/8/1
 */

class User(val id: Int, val name: String, val address: String)


fun print3_6() {
//    saveUser(User(1, "xiaowei", "tongzhou"))
//    saveUser1(User(1, "xiaowei", "tongzhou"))
    val str = "goto home A and B and C and D and E and F and G and H"
    println("count is ${str.count("and")}")
//    saveUser2(User(1, "xiaowei", "tongzhou"))
    //保存user

}

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalStateException("Can't save user ${user.id} :empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalStateException("Can't save user ${user.address} :empty address")
    }
    println("save success userId:${user.id} userName:${user.name} userDddress:${user.address}")
}


fun saveUser1(user: User) {
    //函数中的函数 局部函数
    fun validUser(user: User, value: String, filedName: String) {
        if (value.isEmpty()) {
            throw IllegalStateException("Can't save user ${user.id} :empty $filedName")
        }
    }
    //只能再当前函数内部 调用局部函数
    validUser(user, user.name, "Name")
    validUser(user, user.address, "Address")
    println("save success userId:${user.id} userName:${user.name} userDddress:${user.address}")
}

//将验证放在User的扩展函数中 该函数可以嵌套再saveUser2()中
fun User.valideUser() {
    fun validUser(user: User, value: String, filedName: String) {
        if (value.isEmpty()) {
            throw IllegalStateException("Can't save user ${user.id} :empty $filedName")
        }
    }
    validUser(this, this.name, "Name")
    validUser(this, this.address, "Address")
}

fun saveUser2(user: User) {
    user.valideUser()
    println("save success userId:${user.id} userName:${user.name} userDddress:${user.address}")
}

