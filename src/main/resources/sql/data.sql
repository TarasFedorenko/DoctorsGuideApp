--  Diseases
insert into diseases values (default,'2023-08-05', '2023-08-05','INFECTION','Грип');
insert into diseases values (default,'2023-08-05', '2023-08-05','INFECTION','Пневмонія');
insert into diseases values (default,'2023-08-05', '2023-08-05','INFECTION','ГРВІ');
insert into diseases values (default,'2023-08-05', '2023-08-05','SOMATIC','Апендицит');
insert into diseases values (default,'2023-08-05', '2023-08-05','SOMATIC','Виразка шлунка');
insert into diseases values (default,'2023-08-05', '2023-08-05','SOMATIC','Стенокардія');
insert into diseases values (default,'2023-08-05', '2023-08-05','SOMATIC','Міокардит');
insert into diseases values (default,'2023-08-05', '2023-08-05','TRAUMA','Струс мозку');
insert into diseases values (default,'2023-08-05', '2023-08-05','TRAUMA','Вивих кінцівки');
insert into diseases values (default,'2023-08-05', '2023-08-05','PSYCHOLOGICAL','Шизофренія');
insert into diseases values (default,'2023-08-05', '2023-08-05','PSYCHOLOGICAL','Біполярний розлад');
insert into diseases values (default,'2023-08-05', '2023-08-05','AUTOIMMUNE','Цукровий дібет 1 типу');
insert into diseases values (default,'2023-08-05', '2023-08-05','AUTOIMMUNE','Вовчанка');
insert into diseases values (default,'2023-08-05', '2023-08-05','GENETIC','Серпоподібноклітинна анемія');
insert into diseases values (default,'2023-08-05', '2023-08-05','GENETIC','Муковісцидоз');

--  Symptoms
insert into symptoms values (1,'2023-08-05', '2023-08-05','Лихоманка','COMMON');
insert into symptoms values (2,'2023-08-05', '2023-08-05','Слабкість','COMMON');
insert into symptoms values (3,'2023-08-05', '2023-08-05','Спрага','COMMON');
insert into symptoms values (4,'2023-08-05', '2023-08-05','Підвищене ШОЕ','LABORATORY');
insert into symptoms values (5,'2023-08-05', '2023-08-05','Збільшення розмірів печінки','ORGAN_SPECIFIC');
insert into symptoms values (6,'2023-08-05', '2023-08-05','Протеїнурія','LABORATORY');
insert into symptoms values (7,'2023-08-05', '2023-08-05','Підвищенна ехогенність печінки','INSTRUMENTAL');
insert into symptoms values (8,'2023-08-05', '2023-08-05','Лейкоцитоз','LABORATORY');
insert into symptoms values (9,'2023-08-05', '2023-08-05','Слухові галюцінації','PSYCHOLOGICAL');
insert into symptoms values (10,'2023-08-05', '2023-08-05','Нізький рівень гемоглобіну','LABORATORY');

--  Diseases-Symptoms
insert into disease_symptom values (1, 1);
insert into disease_symptom values (2, 1);
insert into disease_symptom values (3, 1);

--  Procedures
insert into procedures values (1,'2023-08-05', '2023-08-05','Рентгенографія','INSTRUMENTAL');
insert into procedures values (2,'2023-08-05', '2023-08-05','Загальний аналіз крові','LABORATORY');
insert into procedures values (3,'2023-08-05', '2023-08-05','Біохімічний аналіз крові','LABORATORY');
insert into procedures values (4,'2023-08-05', '2023-08-05','Апендектомія','TREATMENT');
insert into procedures values (5,'2023-08-05', '2023-08-05','Флюорографія','INSTRUMENTAL');

--  Diseases-Procedures
insert into disease_procedure values (2,1);
insert into disease_procedure values (3,1);
insert into disease_procedure values (5,1);

--Drugs
insert into drugs values (default,'2023-08-05', '2023-08-05', 'A-280-360', 'антибіотик, що діє бактеріостатично, інгібуючи синтез бактеріального білка за рахунок зв''язування з 50S-субодиницею рибосом. Препарат має широкий спектр антибактеріальної дії. До азитроміцину чутливі стрептококи, метицилінчутливі стафілококи, хламідії, легіонелли, клостридії, Haemophilus influenzae, Moraxella catarrhalis, пастерелла, фузобактерії, Porphyromonas, бліда спірохета, лістерія, борелія, нейсерії, сальмонели, шиґелли, єрсінії, Escherichia coli, Bordetella pertussis, Helicobacter pylori, мікоплазми, пептококи, пептострептококи. Нечутливими до азитроміцину є метицилінрезистентні стафілококи, ентерококи, більшість анаеробних бактерій.','г', 0.25,'ANTIBIOTICS', 'Азітроміцин',34);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'N-347-122', 'безбарвні голчасті кристали моноклінної структури, у чистому вигляді без запаху, але у вологому середовищі (наприклад при контакті з повітрям) набуває запаху оцтової кислоти. Одержують взаємодією оцтового ангідриду та саліцилової кислоти. Вживають як протизапальний, знеболювальний, жарознижувальний та антиагрегантний засіб.','г', 0.5,'ANALGESICS', 'Ацетилсаліцилова кислота',88);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'J-456-652', 'напівсинтетичний антибіотик з групи цефалоспоринів ІІІ покоління для парентерального введення широкого спектра дії. Цефтріаксон уперше синтезовано у лабораторії швейцарської компанії Hoffmann-La Roche[2], яка розпочала його випуск під торговою маркою «Роцефін». Цефтріаксон використовується у клінічній практиці з 1982 року.[3] Цефтріаксон, на думку багатьох експертів, вважається найуспішнішим із цефалоспоринів ІІІ покоління.','г', 1.0,'ANTIBIOTICS', 'Цефтріаксон',5);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'V-445-212', 'Дротаверин — синтетичний препарат, що по хімічному складу є похідним ізохіноліну та структурним аналогом папаверину. Механізм дії препарату полягає в інгібуванні ферменту фосфодіестерази IV типу, яка бере участь у регуляції скорочень гладких м''язів шлунково-кишкового тракту, сечовидільної системи та міометрію.','г', 2.0,'SPASMOLYTICS', 'Дротаверин',18);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'A-222-111', 'сильний опіоїд, що міститься в маку снодійному (Papaver somniferum). Використовується як знеболювальне, а також як рекреаційний наркотик та для створення інших опіоїдів..','мг ', 40,'ANALGESICS', 'Морфій',2);


--  Diseases-Drug
insert into disease_drug values (1,1);
insert into disease_drug values (2,1);
insert into disease_drug values (3,1);
insert into disease_drug values (1,3);
insert into disease_drug values (1,5);

-- users

insert into users values ('ADMIN',1,'2023-12-10 18:28:17.916000','2023-12-10 18:28:17.916000','admin@mail.com', true, 'Mikola', 'Mikolenko', '$2a$10$oNvF33f6E84sfeHvHJ/ik.ULBRkOkXiuOAJyap1Wg.p9nDjpQzAsy', 1, 39, null, 'MALE');

-- Drug-analog
INSERT INTO analog_drug (drug_id, analog_id) VALUES (1, 3);

INSERT INTO analog_drug (drug_id, analog_id) VALUES (3, 1);
