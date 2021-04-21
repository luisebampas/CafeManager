from rest_framework import serializers
from Center_Server.models import CartInfo


class CartSerializer(serializers.ModelSerializer):
    class Meta:
        model = CartInfo
        fields = ['cart_num', 'table_id', 'menu_name', 'cart_count', 'temp_option', 'size_option', 'cart_price']