//package com.example.cafe_user.ui.HttpConnection
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import okhttp3.*
//import org.json.JSONObject
//import kotlin.concurrent.thread
//
//
//class HttpClient {
//    // 클라이언트가 서버에게 post 내용 보내기.
//
//
//        login.setOnClickListener {
//            thread {
//                //EditText에 입력한  id와 pass로 json 데이터를 만들기
//                var jsonobj = JSONObject()
//                jsonobj.put("boardNo", id.text)
//                jsonobj.put("writer", pass.text)
//                val json: String = Jsonobj.toStirng()
//
//
//                val site = "http://172.30,1.50:8000/login"
//                // 접속하기 위한 객체를 생성
//                val client = OkHttpClient()
//                //request 정보를 담은 Request 객체 만들기
//                val request: Request = Request.Builder()
//                    .url(site)
//                    .post(RequestBody.create(MediaType.parse("application/json"), json))
//                    .build()
//                // 요청 후 서버로부터 응답 받기
//                val resqonse: Response = client.newCall(request).execute()
//                val result = resqonse.body()!!.string() //response의 body 추출
//                Log.d("msg", result)
//            }
//        }
//
//}