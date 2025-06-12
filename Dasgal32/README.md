Time In Words
Тайлбар: words[] массив нь 1-29 хүртэлх тоонуудыг үгээр илэрхийлсэн массив бөгөөд "time in words" бодлого хийхэд ашиглагддаг.

if (m == 0) — минут 0 бол “x o’ clock” хэлбэрээр буцаана.

else if (m == 15) — 15 минут бол “quarter past x”.

else if (m == 30) — 30 минут бол “half past x”.

else if (m == 45) — 45 минут бол “quarter to x+1”.

else if (m < 30) — 1-29 минутын хооронд бол “x minutes past h”.

else — 31-59 минутын хооронд бол “x minutes to h+1”.

🧾 Жишээ: Input: 5 47

Output: thirteen minutes to six

Input: 3 00

Output: three o' clock

Input: 7 15

Output: quarter past seven
![alt text](<image (2).png>)