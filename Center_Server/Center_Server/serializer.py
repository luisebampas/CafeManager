from rest_framework import serializers

from Center_Server.models import CartList, BuyList, OrderList, TotalStock


class CartListSerializer(serializers.ModelSerializer):
    class Meta:
        model = CartList
        fields = ['table_id', 'menu_name', 'cart_count', 'temp_option', 'size_option', 'cart_price']


class BuyListSerializer(serializers.ModelSerializer):
    class Meta:
        model = BuyList
        fields = ['cart_num', 'table_id', 'menu_name', 'cart_count', 'temp_option', 'size_option', 'cart_price']


class OrderListSerializer(serializers.ModelSerializer):
    class Meta:
        model = OrderList
        fields = ['cart_num', 'table_id', 'menu_name', 'cart_count', 'temp_option', 'size_option', 'cart_price']


class TotalSerializer(serializers.ModelSerializer):
    class Meta:
        model = TotalStock
        fields = ['cart_num', 'table_id', 'menu_name', 'cart_count', 'temp_option', 'size_option', 'cart_price']