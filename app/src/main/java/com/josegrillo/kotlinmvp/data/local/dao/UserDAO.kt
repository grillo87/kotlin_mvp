package com.josegrillo.kotlinmvp.data.local.dao

import android.arch.persistence.room.*
import com.josegrillo.kotlinmvp.domain.model.database.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<User>)

    @Query("SELECT * FROM users")
    fun loadUsers(): List<User>

    @Delete
    fun deleteUsers(users: List<User>)

}