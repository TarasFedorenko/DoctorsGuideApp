***Doctor guide application***

Розміщений на https://github.com/TarasFedorenko/DoctorsGuideApp
Для коректної роботи знадобиться використання додаткового
проекту постачальника за адресою https://github.com/TarasFedorenko/Supplier_drug_base

Застосунок заснований на завданні: 
Довідник лікаря.
База хвороб: назва, симптоми, процедури, перелік рекомендованих ліків із зазначенням необхідної кількості. База медикаментів на складі: назва, кількість, взаємозамінність.
• Формування рецепту після огляду хворого,
• перевірка наявності ліків,
• коригування запасів.

В проекті використані технології  Spring Boot, Spring Web, Spring Data JPA, 
Spring Security, PostgreSQL, Junit, Mockito, Lombok, Thymeleaf, BootStrap, HTML, CSS, JS, 
інші утілітні бібілотеки.

Для коректного початку роботи слід створити 2 бази данних на PostgreSQL
назви, паролі, налаштування в application.properties файлі sql скрипти розміщені в файлі 
resources/data/data.sql для запуску скриптів в application.properties файлі в полі 
spring.sql.init.mode=  змінити значення з never на always та запустити застосунок, після 
відпрацювання скриптів бажано відразу змінити знову на never.

Застосунок розрахований для роботи невеликої часної клініки, відкритих для входу не 
авторизованих користувчів сторінок крім логін/реєстрації немає. Логічно застосунок розділений 
на 2 частини: користувацька для лікарів та адміністративна для адміністратора. Сутність 
адмінстратора з захешованим паролем загружаеться з sql скриптами (логін: admin@mail.com 
пароль: 12345). Сутності лікарів можна створити через форму створення на сторніці адміна
або через реєстрацію на формі через посилання SIGN IN з форми логіна(створення користувачів 
через реєстраційну форму логічно не вірно проте полегшує створення юзерів та залишено на
випадок додавання блоку для пацієнтів). На формі наявні валідація в разі введення не коректних 
даних зявляються банери з попередженням. 

Лікарський блок включає сторінки - підблоки Хвороби, Симптоми, Процедури, Ліки, Призначення, 
Особистий кабінет. За допомогою перших 4 підблоків лікар може визначитись з діагнозом для пацієнта,
перевірити наявнсть певних симптомів, визначитись з процедурами які варто використати та 
препаратами. За умови, що застосунок використовується для частної клініки на засадах страхування,
визначившись з діагнозом лікар робить призначання ліків які пацієнту видають в місцевій аптеці.
Для цього спочатку лікар додає до призначення лікі (Кнопка додати до призначення на сторінці 
деталей ліків) в вкладці призначення лікар вводить особисті дані пацієнта визначає кількість 
упаковок ліків та створє призначення яке зберігається в базі та окремо друкується (створюється
txt файл в папці appointments). При цьому в базі списується відповідна кількість препарату а 
якщо його кількість менша за необхідну викидає помилку. В особистому кабінеті лікар може 
подивитись свої призначення та при необхідності змінити особисті дні включаючи логін та пароль.

Адмін блок включає 2 підблоки: менеджмент ліків та менеджмент користувачів.
Менеджмент користувачів дає можливість створювати нових акаунти нових лікарів, деактивувати\активувати
їх ( тут логіка що лікарі можуть бути в тривалих відпустках, конференціях, декреті, і щоб ніхто не міг 
використвувати акаунт його можно деактивувати на необхідний час) далі можно подивитись дані лікарів та
призначення які вони зробили.
Оскількі додавання хвороб, симптомів та процедур не логічно оскільки в цих категоріях зміні вкрай 
малоімовірні, то ліки постійно змінюються додаються тому зроблено окремий блок для роботи з ними
Менеджмент ліків підблок де можна створити препарат(не встиг виправити баг при обиранні аналогів та 
хвороб повязаних з нови препаратом, постійно оновлюються форми тож спочатку слід обирати аналоги та 
хвороби а потім інші форми) далі препарати можно оновити та видалити.

Додатково зробив імітування системи саплаер-баер для цього спочатку треба запустити 2 проеки та у кожного 
перевірити базу, далі в основному проекті є Scheduler який кожну хвилину відсилає запит для бази на 
http://localhost:8080 з артикулами ліків кількість яких дорівнює нуль,  в базі саплаєра ті самі ліки з
тими самим артикулами і видатковою кількістю (тобто скільки треба віддати нашій аптеці якщо закінчився 
препарат так для аспірину це може бути 100 а для морфія тільки 10), оскільки кожна клініка має власні потреби
при запиті передається ключ без якого запит буде не валідний. Після прохдження запити база з ліками 
клініки поповнюється на видаткову кількість.

Для візуалізції використовував Thymeleaf, BootStrap, HTML, CSS, JS без готових темплейтів чи стилів.
Тестуванням покриті всі методи сервіс класу використвував Junit, Mockito для тестування сутностей 
використвував патерн фабрика. Крім того в коді використаний патерн білдер.Проведена валідація та обробка 
екзепшенів.