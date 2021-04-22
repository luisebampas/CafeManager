from django.db import models


# 1-1. 사용자 app의 장바구니 품목 목록
class CartList(models.Model):

    cart_num = models.AutoField(db_column='cart_num', primary_key=True)
    table_id = models.IntegerField(db_column='table_id')
    menu_name = models.CharField(db_column='menu_name', max_length=255)
    menu_eng = models.CharField(db_column='menu_eng', max_length=255)
    price = models.IntegerField(db_column='price')
    cart_count = models.IntegerField(db_column='cart_count')
    temp_option = models.IntegerField(db_column='temp_option')
    size_option = models.IntegerField(db_column='size_option')
    cart_price = models.IntegerField(db_column='cart_price')

    class Meta:
        managed = False
        db_table = 'cartlist'

    def __str__(self):
        return "번호 : " + str(self.cart_num) + "테이블 번호 : " + str(self.table_id) + ", 메뉴명 : " + str(self.menu_name) + ", 메뉴영어명 : " + self.menu_eng + \
               ", 메뉴가격 : " + str(self.price) + ", 수량 : " + str(self.cart_count) + ", 옵션 : " + str(self.temp_option) + \
               ", 사이즈 : " + str(self.size_option) + ", 총 결제금액 : " + str(self.cart_price);


# 1-2. 사용자 app의 구매내역 리스트
class BuyList(models.Model):
    buy_id = models.IntegerField(db_column='buy_id')
    table_id = models.IntegerField(db_column='table_id')
    menu_name = models.CharField(db_column='menu_name', max_length=255)
    menu_eng = models.CharField(db_column='menu_eng', max_length=255)
    price = models.IntegerField(db_column='price')
    cart_count = models.IntegerField(db_column='cart_count')
    temp_option = models.IntegerField(db_column='temp_option')
    size_option = models.IntegerField(db_column='size_option')
    cart_price = models.IntegerField(db_column='cart_price')
    buy_date = models.DateTimeField(db_column='buy_date', max_length=100)

    class Meta:
        managed = False
        db_table = 'buylist'

    def __str__(self):
        return "번호 : " + str(self.buy_id) + "메뉴명 : " + str(self.menu_name) + "메뉴 영어명 : " + str(self.menu_eng) +\
               "메뉴가격 : " + str(self.price) + ", 수량 : " + str(self.cart_count)\
               + ", 옵션 : " + str(self.temp_option) + ", 사이즈 : " + str(self.size_option) +\
               ", 총 결제금액 : " + str(self.cart_price);


# 2-1.관리자 app의 주문접수 리스트
class OrderList(models.Model):
    buy_id = models.IntegerField(db_column='buy_id')
    table_id = models.IntegerField(db_column='table_id')
    menu_name = models.CharField(db_column='menu_name', max_length=255)
    menu_eng = models.CharField(db_column='menu_eng', max_length=255)
    price = models.IntegerField(db_column='price')
    cart_count = models.IntegerField(db_column='cart_count')
    temp_option = models.IntegerField(db_column='temp_option')
    size_option = models.IntegerField(db_column='size_option')
    cart_price = models.IntegerField(db_column='cart_price')
    buy_date = models.DateTimeField(db_column='buy_date', max_length=100)

    class Meta:
        managed = False
        db_table = 'orderlist'

    def __str__(self):
        return "번호 : " + str(self.table_id) + "테이블 번호 : " + str(self.table_id) + ", 메뉴명 : " + str(self.menu_name) + \
               ", 메뉴영어명 : " + str(self.menu_eng) + ", 메뉴가격 : " + str(self.price) + ", 수량 : " + str(self.cart_count) +\
               ", 옵션 : " + str(self.temp_option) + ", 사이즈 : " + str(self.size_option) + ", 총 결제금액 : " + str(self.cart_price);


# 2-1.관리자 app의 재고현황 리스트
class TotalStock(models.Model):
    storage_id = models.IntegerField(db_column='storage_id')
    storage_name = models.CharField(db_column='storage_name', max_length=255)
    name = models.CharField(db_column='name', max_length=255)
    s_count = models.IntegerField(db_column='s_count')
    s_date = models.DateTimeField(db_column='s_date', max_length=100)
    shelf = models.DateTimeField(db_column='shelf', max_length=100)
    expire = models.IntegerField(db_column='expire')

    class Meta:
        managed = False
        db_table = 'totalstock'

    def __str__(self):
        return "분류 : " + str(self.storage_name) + "재고 이름 : " + str(self.name) + ", 남은 수량 : " + str(self.s_count) + \
               ", 입고일자 : " + str(self.s_date) + ", 만료일자 : " + str(self.shelf) + ", 남은 일수 : " + str(self.expire)