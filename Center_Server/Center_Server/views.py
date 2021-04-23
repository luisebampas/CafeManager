from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from rest_framework.parsers import JSONParser

from Center_Server.models import CartList, BuyList, TotalStock, OrderList
from Center_Server.serializer import CartListSerializer, TotalSerializer, BuyListSerializer, OrderListSerializer


## tips
## www.django-rest-framework.org/tutorial/quickstart/


def index(request):
    return render(request, "index.html")


def get_CartInfo(request):
    datalist = CartList.objects.all()
    print(datalist)
    if request.method == 'GET':
        print("test=====")
        serializer = CartListSerializer(datalist, many=True)
        print(serializer)
        return JsonResponse(serializer.data, safe=False, json_dumps_params={'ensure_ascii': False})


    # 클라이언트에서 넘어오는 데이터를 가지고 작업 - 데이터가 JSON형식으로 전달
def post_CartInfo(request):
    if request.method == 'POST':
        print("request_ok")
        data = JSONParser().parse(request)
        print(data)
        cart_num = data['cart_num']
        print(cart_num)
        obj = CartList.objects.get(cart_num=int(cart_num))
        print(obj)
        if data['menu_name'] == obj.writer:
            return JsonResponse("ok", safe=False, json_dumps_params={'ensure_ascii': False})
        else:
            return JsonResponse("fail", safe=False, json_dumps_params={'ensure_ascii': False})


def get_BuyInfo(request):
    datalist = BuyList.objects.all()
    print(datalist)
    if request.method == 'GET':
        print("test=====")
        serializer = BuyListSerializer(datalist, many=True)
        print(serializer)
        return JsonResponse(serializer.data, safe=False, json_dumps_params={'ensure_ascii': False})


def get_stock(request):
    datalist = TotalStock.objects.all()
    print(datalist)
    if request.method == 'GET':
        print("test=====")
        serializer = TotalSerializer(datalist, many=True)
        print(serializer)
        return JsonResponse(serializer.data, safe=False, json_dumps_params={'ensure_ascii': False})

def get_order(request):
    datalist = OrderList.objects.all()
    print(datalist)
    if request.method == 'GET':
        print("test=====")
        serializer = OrderListSerializer(datalist, many=True)
        print(serializer)
        return JsonResponse(serializer.data, safe=False, json_dumps_params={'ensure_ascii': False})