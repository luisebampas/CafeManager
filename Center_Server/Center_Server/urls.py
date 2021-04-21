from django.urls import path
from Center_Server import views

urlpatterns = [
    path('', views.index, name="index"),
    path('get_CartInfo', views.get_CartInfo, name="get_CartInfo"),
    path('post_CartInfo', views.post_CartInfo, name="post_CartInfo"),
]
