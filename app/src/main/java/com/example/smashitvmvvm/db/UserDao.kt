package com.example.smashitvmvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM user_data")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM user_data")
    fun getAllLiveData(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM user_data WHERE name LIKE :name")
    fun findByName(name: String): UserEntity

    @Insert
    fun insertAll(vararg user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Update
    fun updateUser(vararg user: UserEntity)
}