package com.example.cafe_user.ui.sqldb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


const val DB_VERSION = 2

class DBHelper: SQLiteOpenHelper{
    //생성자
    //test.db -> 파일형태로 저장된다. - SQLiteOpenHelper
    //부모생성자내부에서 데이터베이스를 오픈하고 사용할 수 있는 상태로 만들어주는 작업
    constructor(context: Context): super(context,"test.db",null,DB_VERSION)

    //숫자: integer, 문자: text, 날짜:date
    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("mydbtest","DB가 생성됨.")
        val sql = """
            create table mytable(
                idx integer primary key autoincrement,
                id text,
                name text,
                age integer
            )
        """.trimIndent()
        //SQL 실행
        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


}