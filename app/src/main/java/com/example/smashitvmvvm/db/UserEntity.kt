package com.example.smashitvmvvm.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class UserEntity(
    @PrimaryKey
    var id : Int,
    @ColumnInfo(name = "name")
    var name : String,
    @ColumnInfo(name = "email")
    var email : String,
    @ColumnInfo(name = "password")
    var password: String
)