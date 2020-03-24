import re

str = "ABCDEFGHIJKMNOPQTUVWXZLRSY"

list=[ "10", "11", "12", "13", "14", "15", "16", "17", "34",
       "18", "19", "21", "22", "35", "23", "24", "27", "28", 
       "29", "32", "30", "33", "20", "25", "26", "31" ]

while True:
    try:
        num=input("請輸入身分證字號:")             
        obj = re.match('[A-Z]{1}[1,2]{1}[0-9]{8}',num,flags=0)
  
        capital = str.find(num[0])

        if obj:
            x=list[capital]
            index, checksum = 1 , 0

            for i in range(8,0,-1):
                checksum += int(num[index]) * i
                index += 1

            checksum += int(x[0]) + int(x[1])*9 + int(num[index])

            if(checksum % 10 == 0):
                print("real")
            else:
                print("fake")
        else:
            print("fake")

    except:
        break    