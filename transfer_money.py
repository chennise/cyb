#encoding:utf-8
import sys
import MySQLdb
import string


class transfermoney(object):
     def __init__(self,conn):
           self.conn=conn

     def checkavaliable(self,acctid):
         cursor = self.conn.cursor()
         try:
           sql="select * from account where acctid=%s"%acctid
           cursor.execute(sql)
           print "checkavaliable"+sql
           rs = cursor.fetchall()
           if len(rs)!=1:
               raise Exception("账号%s不存在"%acctid)
         finally:
           cursor.close()


     def hasmoney(self,acctid, money):
         cursor = self.conn.cursor()
         try:
             sql = "select * from account where acctid=%s and money>%s" % (acctid,money)
             cursor.execute(sql)
             print "hasmoney" + sql
             rs = cursor.fetchall()
             if len(rs) != 1:
                 raise Exception("账号%s没有足够的钱" % acctid)
         finally:
             cursor.close()

     def  reducemoney(self,acctid, momey):
             cursor = self.conn.cursor()
             try:
                 sql = "update account set money=money-%s where acctid=%s" % (money, acctid)
                 cursor.execute(sql)
                 print "reduce.money" + sql
                 if cursor.rowcount != 1:
                     raise Exception("账号%s减款失败" % acctid)
             finally:
                  cursor.close()

     def  addmoney(self,acctid, money):
         cursor = self.conn.cursor()
         try:
             sql = "update account set money=money+%s where acctid=%s" % (money, acctid)
             cursor.execute(sql)
             print "reduce.money" + sql
             if cursor.rowcount != 1:
                 raise Exception("账号%s增款失败" % acctid)
         finally:
             cursor.close()

     def transfer(self,source_acctid,target_acctid,momey):
        try:
           self.checkavaliable(source_acctid)
           self.checkavaliable(target_acctid)
           self.hasmoney(source_acctid,momey)
           self.reducemoney(source_acctid,momey)
           self.addmoney(target_acctid,momey)
           self.conn.commit()
        except Exception as e:
             self.conn.rollback()
             raise e
if  __name__ =="__main__":
       source_acctid = sys.argv[1]
       target_acctid=sys.argv[2]
       money = sys.argv[3]

       conn = MySQLdb.Connect(
           host='127.0.0.1',
           port=3306,
           user='root',
           passwd='123456',
           db='cyb',
           charset='utf8')

       tr_money=transfermoney(conn)

       try:
           tr_money.transfer(source_acctid,target_acctid,money)
       except Exception as e:
            print "出现问题" + str(e)
       finally:
        conn.close()
