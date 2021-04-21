from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from rest_framework.parsers import JSONParser

from Center_Server.models import CartInfo
from Center_Server.serializer import CartSerializer

## tips
## www.django-rest-framework.org/tutorial/quickstart/


def index(request):
    return render(request, "index.html")



def get_CartInfo(request):
    datalist = CartInfo.objects.all()
    print(datalist)
    if request.method == 'GET':
        print("test=====")
        seriallizer = CartSerializer(datalist, many=True)
        print(seriallizer)
        return JsonResponse(seriallizer.data, safe=False, json_dumps_params={'ensure_ascii': False})

    # 클라이언트에서 넘어오는 데이터를 가지고 작업 - 데이터가 JSON형식으로 전달
def post_CartInfo(request):
    if request.method == 'POST':
        print("request_ok")
        data = JSONParser().parse(request)
        print(data)
        cart_num = data['cart_num']
        print(cart_num)
        obj = CartInfo.objects.get(cart_num=int(cart_num))
        print(obj)
        if data['menu_name'] == obj.writer:
            return JsonResponse("ok", safe=False, json_dumps_params={'ensure_ascii': False})
        else:
            return JsonResponse("fail", safe=False, json_dumps_params={'ensure_ascii': False})



