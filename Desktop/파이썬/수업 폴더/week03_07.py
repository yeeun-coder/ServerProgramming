# week03_07.py
test = "i am a BOY."

print(test.count("a")) #시작위치 2
print(test.count("A")) #없어서 0

print(test.find("a"))
print(test.find("q")) #q가 없어서 -1
print(test.find("am"))
print(test.find("qm"))

#index는 없으면 죽
print(test.index("a"))
#print(test.index("q"))
print(test.index("am"))
if "qm" in test:
    print(test.index("qm"))
else:
    print("x")


print(test.upper())
print(test.lower())
print(test.title())
print(test.capitalize())
print("/".join(test))


test = " JMT University "
print("|" + test.strip() + "|")
print("|" + test.lstrip() + "|")
print("|" + test.rstrip() + "|")

print(test.replace("University", "High school"))
print(test)

print(test.split()) #공백과 리스트가 반환
print(test.split("i")) #리스트가 반환



'''
print(len("a")) #문자열 길이
print("aba".count("a")) #문자열 a 수
#print("a".len())
#print(count("a"))
#print((1).count('1'))

print("123".index('1')) #문자열의(.) index
print([1,2.5,3].index(3)) #리스트의(.) index
'''
