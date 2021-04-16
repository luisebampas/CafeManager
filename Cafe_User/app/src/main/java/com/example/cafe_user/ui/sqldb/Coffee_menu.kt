package com.example.datamanagment.sqlite

class Coffee_menu{
    var table_id: Int = 0
    var menu_id:Int = 0
    var menu_name:String =""
    var menu_category:String = ""
    var price:Int=0
    var menu_state:Int = 0
    var menu_title:String =""

    //주문 입력용 constructor
    constructor(table_id:Int,menu_id: Int, menu_name: String, menu_category: String, price: Int, menu_title: String) {
        this.table_id = table_id
        this.menu_id = menu_id
        this.menu_name = menu_name
        this.menu_category = menu_category
        this.price = price
        this.menu_title = menu_title
    }
//    //insert용 생성자
//    constructor( id: String, name: String, age: Int) {
//        this.id = id
//        this.name = name
//        this.age = age
//    }
//
//    //select용 생성자
//    constructor(idx: Int, id: String, name: String, age: Int) {
//        this.idx = idx
//        this.id = id
//        this.name = name
//        this.age = age
//    }
//
//
//    override fun toString(): String {
//        return "Person(idx=$idx, id='$id', name='$name', age=$age)"
//    }
}