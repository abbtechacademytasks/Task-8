# Task-8

Tapşırıq mətni:
Bir avtobus marşrutu sistemini simulyasiya edən proqram yaz.
Avtobuslar müəyyən dayanacaqlara çatır, sərnişinlər növbə ilə minib-düşür, və bəziləri xüsusi statusa malikdir (priority passenger — yaşlı, əlil, hamilə və s.), yəni onlara birinci minib düşməyə icazə verilməlidir.
Şərtlər:
Hər dayanacaqda sərnişinlər növbə ilə gözləyir (Queue və ya LinkedList).
Hər dayanacaqda ən çox 10 sərnişin gözləyə bilər.
Hər sərnişinin 2 məlumatı var:
name
isPriority (boolean)
Avtobusun da sərnişin tutumu 5 nəfərdir.
Avtobus dayanacaqlara gedir (stop1, stop2, stop3 ardıcıllığı ilə) və hər dayanacaqda bu addımlar baş verir:
Avtobusdakı sərnişinlərdən 1-2 nəfər düşür (təsadüfi).
Dayanacaqda gözləyən sərnişinlər minib.
Əgər isPriority == true olan sərnişin varsa, o həmişə əvvəl minir.
Simulyasiya 3 dayanacaqdan sonra bitir və son vəziyyət göstərilir:
Avtobusda kimlər var
Hər dayanacaqda kimlər qaldı
Netice daima ferqli ola biler birisi avtobusdan ya duse biler ya dusmeye, hemcinin ya mine biler yada minmeye


Kod elə yazın ki, performans cəhətdən ən optimal olsun.
Hansı Collection növü hansı hissəyə daha uyğundur, onu özünüz seçin.
Məqsəd: həm işləsin, həm də səmərəli olsun.Hemcinin sadece dersde kecdiyimiz collection novlerinin icinden secerek  istifade edin (List, Deque, Queue, PriorityQueue, Stack və LinkedList)

Result
Example1

🚌 Stop 1 reached.
Aysel(PRIORITY) boarded the bus.
Rauf boarded the bus.
Ali boarded the bus.
Bus now: [Aysel(PRIORITY), Rauf, Ali]
Stop 1 remaining: []

🚌 Stop 2 reached.
Ali left the bus.
Rauf left the bus.
Nigar(PRIORITY) boarded the bus.
Samir(PRIORITY) boarded the bus.
Murad boarded the bus.
Bus now: [Aysel(PRIORITY), Nigar(PRIORITY), Samir(PRIORITY), Murad]
Stop 2 remaining: []

🚌 Stop 3 reached.
Murad left the bus.
Sevinc(PRIORITY) boarded the bus.
Leyla boarded the bus.
Bus now: [Aysel(PRIORITY), Nigar(PRIORITY), Samir(PRIORITY), Sevinc(PRIORITY), Leyla]
Stop 3 remaining: [Tural]

✅ Simulation finished.
Final passengers in bus: [Aysel(PRIORITY), Nigar(PRIORITY), Samir(PRIORITY), Sevinc(PRIORITY), Leyla]





Example 2

🚌 Stop 1 reached.
Aysel(PRIORITY) boarded the bus.
Rauf boarded the bus.
Ali boarded the bus.
Bus now: [Aysel(PRIORITY), Rauf, Ali]
Stop 1 remaining: []

🚌 Stop 2 reached.
Ali left the bus.
Nigar(PRIORITY) boarded the bus.
Samir(PRIORITY) boarded the bus.
Murad boarded the bus.
Bus now: [Aysel(PRIORITY), Rauf, Nigar(PRIORITY), Samir(PRIORITY), Murad]
Stop 2 remaining: []

🚌 Stop 3 reached.
Murad left the bus.
Sevinc(PRIORITY) boarded the bus.
Bus now: [Aysel(PRIORITY), Rauf, Nigar(PRIORITY), Samir(PRIORITY), Sevinc(PRIORITY)]
Stop 3 remaining: [Leyla, Tural]

✅ Simulation finished.
Final passengers in bus: [Aysel(PRIORITY), Rauf, Nigar(PRIORITY), Samir(PRIORITY), Sevinc(PRIORITY)]


