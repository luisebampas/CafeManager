package com.example.cafe_user.ui.sqldb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast

//test.db파일에 저장된 mytable에 CRUD 기능처리

class MyTableDB {
    var contentValObj:ContentValues?=null
    var mydb:SQLiteDatabase?=null
    var context:Context ?= null

    constructor(context: Context){
        this.context = context
        var helper = DBHelper(context)
        mydb = helper.writableDatabase
    }

    fun insert(person:Person){
        //데이터 저장
        //매개변수로 전달된 Person객체에 저장된 데이터를 SQLite에 insert
        contentValObj = ContentValues()
        contentValObj!!.put("id",person.id)
        contentValObj!!.put("name",person.name)
        contentValObj!!.put("age",person.age)

        //insert내부에서 insert기능 처리하는 sql문 생성. 필요한 컬럼에 전달할 값 등은 ContentValues에서 추출6
        mydb?.insert("mytable",null,contentValObj) //contentValObj 넣으면 위에 put한거 다 들어감
    }


    fun select():ArrayList<Person>{
        var datalist:ArrayList<Person> ?= ArrayList<Person>()
        /*
            select 컬럼명 from 테이블명 where 조건
            group by 컬럼명
            having 조건
            order by 컬럼명
            1. table 매개변수 => 테이블명
            2. columns => 조회할 컬럼명 매열
            3. selection => 조건(where절 다음에 오는 문자열: id = ?)
            4. selectionArgs => 조건으로 정의된 ?에 바인딩될 데이터 배열로 처리
            5. groupby => group by 절 뒤에 정의할 컬럼명
            6. having => having절 뒤에 정의할 조건
            7. orderby => orderby 절에 정의할 정렬기준
        */

        val cursor = mydb?.query("mytable",null,null,null,
                null,null,null)

        val size = cursor?.count//레코드 갯수 반환환
        //Toast.makeText(context,"조회된row: $size",Toast.LENGTH_SHORT).show()
        //DB조회된 데이터를 contentValuesTestActivity로 넘기기 위해 ArrayList로 변환
        while(cursor!!.moveToNext()){
            //DB에서 조회된 레코드로 Person객체 생성
            var person = Person(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getInt(3))
            datalist!!.add(person)
        }

        return datalist!!
    }


    fun update(id:String,age:String){
        //update mytable
        //set age = 50
        //where id like ?
        // '%a%'
        contentValObj = ContentValues()
        contentValObj!!.put("age",age)
        var where:String = "id like ?"//update문 where절 뒤에 올 조건문자열
        var whereargs = arrayOf("%${id}%") //특정 문자 들어간거 수정
        mydb?.update("mytable",contentValObj, where, whereargs)
    }

    fun delete(id:String){
        //whereArgs는 whereClause에서 조건에 정의한 ?의 갯수만큼 배열로 작성해야하다
        mydb?.delete("mytable","id =? ", arrayOf(id))
    }


}









