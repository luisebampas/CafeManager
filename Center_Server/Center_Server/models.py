from django.db import models
# db 매핑하는 클래스

# Create your models here.
class CartInfo(models.Model):
    cart_num = models.AutoField(db_column='cart_num', primary_key=True)
    table_id = models.IntegerField(db_column='table_id')
    menu_name = models.CharField(db_column='menu_name', max_length=255)
    cart_count = models.IntegerField(db_column='cart_count')
    temp_option = models.IntegerField(db_column='temp_option', max_length=255)
    size_option = models.IntegerField(db_column='size_option')
    cart_price = models.IntegerField(db_column='cart_price')


    class Meta:
        managed = False
        db_table = 'cart'

    def __str__(self):
        return "테이블 번호 : " + str(self.table_id) + ", 메뉴명 : " + self.menu_name + ", 수량 : " + str(self.cart_count) + ", 옵션 : " + str(self.temp_option) + ", 사이즈 : " + str(self.size_option)
