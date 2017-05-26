
from django.conf.urls import url
from django.contrib import admin
from main import views as main_views
from django.views import generic

urlpatterns = [

	url(r'^$', main_views.index, name='index'),
	url(r'^login/$', main_views.login, name='login'),
]
