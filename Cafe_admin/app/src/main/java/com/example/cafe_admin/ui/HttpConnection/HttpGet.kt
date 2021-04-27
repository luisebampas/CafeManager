//package com.example.cafe_admin.ui.HttpConnection
//
//class HttpGet {
//
//    button.setOnClickListener
//    {
//        thread {
//            //네트워크를 토 ㅇ해 데이터를 요청하는 경우는 무조건 쓰레드로 작업
//            // 접속할 주소
//            val site = "http://172.30.1.50:8000/list"
//            // 주소를 사용할 수 있도록 객체로 정의. URL 클래스 활용
//            val url = URL(site)
//
//            //접속하기 - openConnecation이 반환하는 객체를 하위 객체로 변환(캐스팅)
//            // URLConnection의 자식클래스가 HttpURLConnection. 더 구체적인 객체로 변환하는 것.
//            val con = url.openConnection() as HttpURLConnection
//            //네트워크를 통해 전송되어 오는 데이터를 읽어서 처리하기 위한 안드로이드의
//            // 입력스트림클래스를 선언하고 처리
//            // byte로 전송 -> 한글이 있으므로 문자단위 처리로 변경
//            // byte단위 처리 클래스로 ㅂ문자단위 처리클래스 생성
//            // InPutStreamReader(ISR)은 기본처리만 가능
//            var isr = InputStreamReader(con.inputStream, "UTF-8")
//            val br = BufferedReader(isr) // 버퍼를 쓰면 문장 단위로 읽을 수 있다.
//
//
//            var str: String? = null //String으로 문자열을 표현하면 객체가 너무 만들어진다.
//            val buf = StringBuffer() // Stirng보다 리소스를 적게 사용.
//            // 네트워크에서 받아온 문자열은 주로 이것으로 다룬다.
//
//            do {
//                str = br.readLine() // 버퍼의 있는 모든 내용을 읽어온다. - 한 라인씩 읽기
//                if (str != null) {
//                    buf.append(str)
//                }
//            } while (str != null) // 네트워크로 전송되는 데이터를 읽어서 String Buffer에 저장하는 방법
//
//            val data = buf.toString()
//            //JSON 객체를 파싱하는 작업을 처리
//            //JSONArray 객체로 받아서 JsonArray에 저장된 JsonObject의 갯수만큼큼 처리
//            // [  ] -> json 데이터에서 array
//            // {  } -> json 데이터에서 object
//
//            val root = JSONArray(data)
//            for (i in 0 until root.length()) {
//                // i번째 JSON Object를 추출해서 boardData로 변환
//                var jsonobj = root.getJSONObject(i)
//                var dto = BoardData(
//                    jsonobj.getInt("boardNo"),
//                    jsonobj.getString("title"), jsonobj.getString("content"),
//                    jsonobj.getString("writer"), jsonobj.getString("write_date")
//                )
//                runOnUiThread {
//                    textView2.append(dto.toString() + "\n")
//                }
//            }
//        }
//    }
//}