package com.zzs.jetpack_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val users = listOf(
            User(1, "张三", 20, true, "123456", ""),
            User(2, "李四", 22, true, "123456", "")
        )
        //插入
        AppDatabase.getInstance(this)
            .userDao()
            .addUsers(users)

        //查询
        AppDatabase.getInstance(this)
            .userDao()
            .getUsers()

        val updateUsers = listOf(
            User(1, "张三1", 20, true, "123456", ""),
            User(2, "李四2", 22, true, "123456", "")
        )
        //更新
        AppDatabase.getInstance(this)
            .userDao()
            .updateUsers(updateUsers)

        //删除
        AppDatabase.getInstance(this)
            .userDao()
            .deleteUser(User(1, "张三1", 20, true, "123456", ""))
    }
}
