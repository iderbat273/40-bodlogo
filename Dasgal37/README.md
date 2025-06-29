DownToZero
 Даалгаврын зорилго: Нэг бүхэл тоо n өгөгдөнө. Энэхүү n тоог хамгийн бага алхмаар 0 болгох ёстой бөгөөд дараах хоёр төрлийн үйлдлүүдийг хийж болно:

n = n - 1 гэж багасгах (өөрөөр хэлбэл, 1-р төрөл).

Хэрвээ n-г хоёр бүхэл тооны үржвэр хэлбэрт задлаж болох бол n = max(a, b) гэж өөрчлөх (2-р төрөл).

🔍 Шийдэл гаргах бодлогын анализ: Энэ бол минимум алхам олох сонгодог бодлого бөгөөд ингэхдээ Breadth-First Search (BFS) хэмээх граф алгоритм ашиглах нь хамгийн үр дүнтэй. BFS нь хамгийн богино зам буюу хамгийн бага алхам олохдоо хэрэглэгддэг. Энэ бодлого нь тоонуудыг зангилаа (node) гэж үзэн, тухайн тооноос дараагийн боломжит тоонуудад "үсрэх" байдлаар ажиллана.

📚 Алгоритмын алхамууд: n-г гарааны цэг гэж үзээд queue-д хийж өгнө.

Queue-аас тухайн тоог гаргаж ирээд:

Нэгээр хасаж n - 1-рүү шилжинэ.

Бүх боломжит i-г шалгана: i * j == n бол max(i, j) рүү үсрэх.

Үүссэн тоонуудыг дахин queue-д хийнэ.

Хэрвээ ямар нэг мөчид 0 хүрвэл тэр үеийн алхамын тоо бол хариу болно.

Давталтаар аль хэдийн орсон тоонуудыг дахин шалгахгүйн тулд visited маягаар тэмдэглэнэ.

🧠 Оновчтой болгох стратеги: Memoization: steps[] гэх массив ашиглаж, аль хэдийн хэдэн алхмаар хүрснийг тэмдэглэнэ.

Square Root Optimization: Үржвэрийн хувилбаруудыг зөвхөн i ≤ √n хүртэл шалгана, учир нь i * j = n үед хоёр тал нь √n-аас ихгүй байна.

✅ Жишээ: Жишээ нь, n = 10:

Алхам 1: 10 → 9 (10 - 1) Алхам 2: 9 → 3 (9 = 3 * 3 → max(3, 3)) Алхам 3: 3 → 2 (3 - 1) Алхам 4: 2 → 1 (2 - 1) Алхам 5: 1 → 0 (1 - 1) => Хариу: 5 алхам Бид BFS ашиглан хамгийн түрүүнд хүрэх замыг олдог учраас энэ нь хамгийн бага алхам байх баталгаа болдог.

🧾 Дүгнэлт: Энэ бодлого нь тоог 0 болгох хамгийн цөөн алхмыг BFS аргаар олох тухай.

queue, steps[], visited[] зэрэг бүтцүүд ашиглан хэрэгтэй бүх тоог нэг бүрчлэн судалж, хамгийн богино замыг олдог.

Бодлогын онцлог нь үржвэрийн логик байгаа бөгөөд энэ нь зөвхөн n % i == 0 үед боломжтой байдаг.

BFS-ийн шинж чанараас хамааран эхний удаа 0-д хүрэх зам бол хамгийн цөөн алхамын зам юм.
![alt text](<Screenshot 2025-06-09 181027.png>)