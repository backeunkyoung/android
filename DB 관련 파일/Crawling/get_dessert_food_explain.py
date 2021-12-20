#!/usr/bin/env python
# coding: utf-8

# In[3]:


from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from bs4 import BeautifulSoup
import pandas as pd
import time

# 엑셀 파일 시트 설정
df_sheet_name = pd.read_excel('D:\DB\select_food_app\dessert_food.xlsx', sheet_name='Sheet1')

# 크롬 드라이버 설정
driver = webdriver.Chrome("D:\Development\chromedriver_win32\chromedriver.exe")

explain_datas = []

# food_name 의 img url 추출(열 개수만큼 만복)
for name in df_sheet_name['food_name']:
    text=name
    
    # 구글 검색 창 열기
    driver.get("https://www.google.com")

    #검색창에 검색어 입력하기
    search_box = driver.find_element_by_css_selector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input")
    search_box.send_keys(text)
    
    #검색버튼 누르기
    search_box.send_keys(Keys.ENTER)
    time.sleep(2)
    
    try:
        explain = driver.find_element_by_css_selector("#kp-wp-tab-overview > div.TzHB6b.cLjAic.LMRCfc > div > div > div > div > div > div > div > div > span:nth-child(2)")
        explain_datas.append(explain.text)       
#         print(explain.text)
    except:
        explain_datas.append('설명 없음')
#         print('설명 없음')
        
for data in explain_datas:
    df_sheet_name['menu_explain'] = explain_datas
    print(data)

print(df_sheet_name)

df_sheet_name.to_excel('D:\DB\select_food_app\sample.xlsx', index=False)    
    
#웹페이지를 닫음
driver.close()

print("fin")


# In[ ]:




