package com.app.bubbledemoapp.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.bubbledemoapp.data.room.dbHelper.DBUtils


@Entity(tableName = DBUtils.LOGIN_DETAILS)
data class LoginDetailsEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = DBUtils.LoginDetailsConstants.KEY_USER_ID) var user_id: String,
    @ColumnInfo(name =DBUtils.LoginDetailsConstants.KEY_USERNAME) var user_name: String,
    @ColumnInfo(name = DBUtils.LoginDetailsConstants.KEY_APP_VERSION) var app_version: String



)

