package com.zzs.jetpack_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * @author:      ZhangZhiSheng
 * @date:        2020/7/16 0016 下午 3:58
 * @description:
 */
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo(name = "user_name") var name: String,
    @ColumnInfo(name = "user_age") var age: Int,
    @ColumnInfo var onLine: Boolean,
    @ColumnInfo var mobile: String,
    @Ignore var remark: String
){
    constructor():this(0L,"",0,false,"","")
}