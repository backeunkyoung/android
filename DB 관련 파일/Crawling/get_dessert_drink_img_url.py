#!/usr/bin/env python
# coding: utf-8

# In[1]:


from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from openpyxl import load_workbook
from bs4 import BeautifulSoup
import pandas as pd
import time
import urllib.request

# 엑셀 파일 시트 설정
df_sheet_name = pd.read_excel('D:\DB\select_food_app\dessert_drink.xlsx', sheet_name='Sheet1')

# 크롬 드라이버 설정
driver = webdriver.Chrome("D:\Development\chromedriver_win32\chromedriver.exe")

img_urls = []   # thumbnail_picture
img_urls2 = []  # detail_picture

# food_name 의 img url 추출(열 개수만큼 만복)
for name in df_sheet_name['food_name']:
    keyword=name
    
    # 구글 이미지 창 열기
    driver.get("https://images.google.com")

    #검색창에 검색어 입력하기
    search_box = driver.find_element_by_css_selector("#sbtc > div > div.a4bIc > input")
    search_box.send_keys(keyword)

    #검색버튼 누르기
    search_box.send_keys(Keys.ENTER)
    
    thum = False
    detail = False

    try:
        # -- thumbnail_picture --
        # 작은 이미지 선택
        img = driver.find_element_by_css_selector("#islrg > div.islrc > div:nth-child(1) > a.wXeWr.islib.nfEiy > div.bRMDJf.islir > img")
        time.sleep(2)

        # 이미지 클릭
        img.click()

        # 크게 뜬 이미지 선택하여 "src" 속성을 받아옴   
        text = driver.find_element_by_css_selector("#Sva75c > div > div > div.pxAole > div.tvh9oe.BIB1wf > c-wiz > div > div.OUZ5W > div.zjoqD > div.qdnLaf.isv-id > div > a > img")
        time.sleep(3)

        print(text.get_attribute("src"))

        # 받아온 url 넣기
        img_urls.append(text.get_attribute("src"))
        thum = True

        # -- detail_picture --
        # 작은 이미지 선택
        img = driver.find_element_by_css_selector("#islrg > div.islrc > div:nth-child(2) > a.wXeWr.islib.nfEiy > div.bRMDJf.islir > img")
        time.sleep(2)

        # 이미지 클릭
        img.click()

        # 크게 뜬 이미지 선택하여 "src" 속성을 받아옴   
        text2 = driver.find_element_by_css_selector("#Sva75c > div > div > div.pxAole > div.tvh9oe.BIB1wf > c-wiz > div > div.OUZ5W > div.zjoqD > div.qdnLaf.isv-id > div > a > img")
        time.sleep(3)

        print(text2.get_attribute("src"))

        # 받아온 url 넣기
        img_urls2.append(text2.get_attribute("src"))
        detail = True
    
    except:
        # 구글 이미지 창 열기
        driver.get("https://images.google.com")

        #검색창에 검색어 입력하기
        search_box = driver.find_element_by_css_selector("#sbtc > div > div.a4bIc > input")
        search_box.send_keys("에러 이미지")

        #검색버튼 누르기
        search_box.send_keys(Keys.ENTER)
        
        # 작은 이미지 선택
        img = driver.find_element_by_css_selector("#islrg > div.islrc > div:nth-child(1) > a.wXeWr.islib.nfEiy > div.bRMDJf.islir > img")

        # 이미지 클릭
        img.click()
        time.sleep(2)

        # 크게 뜬 이미지 선택하여 "src" 속성을 받아옴   
        text = driver.find_element_by_css_selector("#Sva75c > div > div > div.pxAole > div.tvh9oe.BIB1wf > c-wiz > div > div.OUZ5W > div.zjoqD > div.qdnLaf.isv-id > div > a > img")
        
        print(text.get_attribute("src"))

        if thum == False:
            img_urls.append(text.get_attribute("src"))
        if detail == False:
            img_urls2.append(text.get_attribute("src"))

for data in img_urls:
    df_sheet_name['thumbnail_picture'] = img_urls
    df_sheet_name['detail_picture'] = img_urls2

print(df_sheet_name)

df_sheet_name.to_excel('D:\DB\select_food_app\sample.xlsx', index=False)


#크롬 웹페이지를 닫음
driver.close()

print("fin")


# In[ ]:




