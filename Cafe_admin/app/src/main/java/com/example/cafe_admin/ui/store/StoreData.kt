package com.example.cafe_user.ui.store

data class StoreData (var no: Int, var title: String, var count: Long){


    inner class DairyStock
        var MenuImg :Int = 0
        var MenuName:String = ""
        var MenuDetail:String = ""

        constructor(MenuImg: Int, MenuName: String, MenuDetail: String) {
            this.MenuImg = MenuImg
            this.MenuName = MenuName
            this.MenuDetail = MenuDetail
        }

}