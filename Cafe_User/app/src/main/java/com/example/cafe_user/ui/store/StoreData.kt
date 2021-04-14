package com.example.cafe_user.ui.store

class StoreData {

    inner class DairyStock
        var :Int = 0
        var MenuName:String = ""
        var MenuDetail:String = ""

        constructor(MenuImg: Int, MenuName: String, MenuDetail: String) {
            this.MenuImg = MenuImg
            this.MenuName = MenuName
            this.MenuDetail = MenuDetail
        }

}