package com.zzs.jetpack_room

import androidx.room.*

/**
 * @author:      ZhangZhiSheng
 * @date:        2020/7/16 0016 下午 5:07
 * @description:
 */
@Dao
interface UserDao {
    //查询所有用户
    @Query("select * from users")
    fun getUsers(): List<User>

    //根据ID查询用户
    @Query("select * from users where id = :id")
    fun getUserById(id: Long): User

    //根据用户名模糊查询用户
    @Query("select * from users where user_name Like '%' || :name ||'%'")
    fun getUsersByName(name: String): List<User>

    //根据用户名和年龄查询用户
    @Query("select * from users where user_name =:name and user_age >:age")
    fun getUsersByNameAndAge(name: String, age: Int): List<User>

    //插入用户
    /*
        onConflict：默认值是OnConflictStrategy.ABORT，表示当插入有冲突的时候的处理策略。
                    OnConflictStrategy封装了Room解决冲突的相关策略：
       1. OnConflictStrategy.REPLACE：冲突策略是取代旧数据同时继续事务。
       2. OnConflictStrategy.ROLLBACK：冲突策略是回滚事务。
       3. OnConflictStrategy.ABORT：冲突策略是终止事务。
       4. OnConflictStrategy.FAIL：冲突策略是事务失败。
       5. OnConflictStrategy.IGNORE：冲突策略是忽略冲突。
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUsers(users: List<User>)

    //更新用户
    @Update
    fun updateUsers(users: List<User>)

    //删除用户
    @Delete
    fun deleteUser(user: User)

    //根据条件删除用户
    @Query("delete from users where id = :id")
    fun deleteUserById(id: Long)

}