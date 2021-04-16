package com.example.datamanagment.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.cafe_user.R
import com.example.cafe_user.ui.sqldb.MyTableDB
import kotlinx.android.synthetic.main.dbjob_main.*


class ContentValuesTestActivity : AppCompatActivity() {
    var dao: MyTableDB?=null //테이블에 연결해서 CRUD처리

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dbjob_main)

        dao = MyTableDB(this)

        save.setOnClickListener{
            Log.d("mydata",age.text.toString())
            var myperson = Person(id.text.toString(), name.text.toString(), Integer.parseInt(age.text.toString()))
            dao?.insert(myperson)
            id.setText("")
            name.setText("")
            age.setText("")
            Toast.makeText(this, "삽입성공",Toast.LENGTH_SHORT).show()
            selectData()
        }

        find.setOnClickListener{
            selectData()
        }
        update.setOnClickListener{
            dao?.update(id.text.toString(), age.text.toString())//update호출하면서 액티비티에서 입력한 값 넘기기
            selectData()
        }
        del.setOnClickListener{
            dao?.delete(id.text.toString())
            selectData()
        }


    }
    fun selectData() {
        result.setText("")
        val datalist = dao?.select()
        Toast.makeText(this, "ArrayList변환 데이터:${datalist!!.size}", Toast.LENGTH_SHORT).show()

        for (i in datalist.indices) {
            var data = datalist[i]

            Log.d("mydbtest", "번호: ${data.idx}\n아이디:${data.id}\n성명:${data.name}\n나이:${data.age}\n========================\n")
            result.append("번호: ${data.idx}\n아이디:${data.id}\n성명:${data.name}\n나이:${data.age}\n========================\n")
        }
    }


}