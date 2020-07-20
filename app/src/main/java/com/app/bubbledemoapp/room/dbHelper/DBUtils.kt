package com.app.bubbledemoapp.data.room.dbHelper

class DBUtils {
    companion object {
        const val DATABASE_NAME = "bubbleApp.db"
        const val DB_VERSION = 1
        const val LOGIN_DETAILS = "login_details"


    }

    interface LoginDetailsConstants {
        companion object {
            const val KEY_USERNAME = "user_name"
            const val KEY_USER_ID = "user_id"
            const val KEY_APP_VERSION = "app_version"
        }


    }
}

