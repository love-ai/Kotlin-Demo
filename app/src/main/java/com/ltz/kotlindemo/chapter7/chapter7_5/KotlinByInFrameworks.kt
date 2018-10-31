package com.ltz.kotlindemo.chapter7.chapter7_5

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Created by xiaowei on 2018/10/31
 *
 */

fun print7_5_6() {

}

object Users : IntIdTable() {
    val name: Column<String> = varchar("name", 50).index()
    val city = reference("city", Cities)
    val age: Column<Int> = integer("age")
}

object Cities : IntIdTable() {
    val name = varchar("name", 50)
}

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var name by Users.name
    var city by City referencedOn Users.city
    var age by Users.age
}

class City(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<City>(Cities)

    var name by Cities.name
    val users by User referrersOn Users.city
}

fun main(args: Array<String>) {
    Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver")

    transaction {
        addLogger(StdOutSqlLogger)

        SchemaUtils.create(Cities, Users)

        val stPete = City.new {
            name = "St. Petersburg"
        }

        val munich = City.new {
            name = "Munich"
        }

        User.new {
            name = "a"
            city = stPete
            age = 5
        }

        User.new {
            name = "b"
            city = stPete
            age = 27
        }

        User.new {
            name = "c"
            city = munich
            age = 42
        }

        println("Cities: ${City.all().joinToString { it.name }}")
        println("Users in ${stPete.name}: ${stPete.users.joinToString { it.name }}")
        println("Adults: ${User.find { Users.age greaterEq 18 }.joinToString { it.name }}")
    }
}