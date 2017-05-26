#coding:utf-8
from django.shortcuts import render
from django.http import HttpResponse	
import json
from gradepoint import *
from getpost import *


def index(request):
	a=back()
	return render(request, 'index.html',{'a': str(a)})
	
def login(request):
	if request.POST:
		account= request.POST['account']
		pwd= request.POST['pwd']
		verifycode= request.POST['verifycode']
		# end,chard=get(account,pwd,verifycode)
		chard=get(account,pwd,verifycode)
		return HttpResponse(json.dumps(chard), content_type='application/json')
