# _*_ coding: utf-8 _*_
import cookielib  
import urllib2
import re
def back():
	url = "http://222.200.98.147/login!getOnlineCount.action"
	headers = {"User-Agent": "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"}
	resp = urllib2.urlopen(url)
	html=resp.read()
	# print type(html)	
	return html

