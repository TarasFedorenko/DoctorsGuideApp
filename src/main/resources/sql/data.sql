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
insert into diseases values (default,'2023-08-05', '2023-08-05','PSYCHOLOGICAL','Шизофренія'); --10
insert into diseases values (default,'2023-08-05', '2023-08-05','PSYCHOLOGICAL','Біполярний розлад');
insert into diseases values (default,'2023-08-05', '2023-08-05','AUTOIMMUNE','Цукровий дібет 1 типу');
insert into diseases values (default,'2023-08-05', '2023-08-05','AUTOIMMUNE','Вовчанка');
insert into diseases values (default,'2023-08-05', '2023-08-05','GENETIC','Серпоподібноклітинна анемія');
insert into diseases values (default,'2023-08-05', '2023-08-05','GENETIC','Муковісцидоз');

--  Symptoms
insert into symptoms values (default,'2023-08-05', '2023-08-05','Лихоманка','COMMON');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Слабкість','COMMON');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Спрага','COMMON');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Нудота','COMMON');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Тахікардія','COMMON');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Підвищене ШОЕ','LABORATORY');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Збільшення розмірів печінки','ORGAN_SPECIFIC');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Кашель','ORGAN_SPECIFIC');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Нежить','ORGAN_SPECIFIC');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Задишка','ORGAN_SPECIFIC'); --10
insert into symptoms values (default,'2023-08-05', '2023-08-05','Біль в грудній клітині','ORGAN_SPECIFIC');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Біль в животі','ORGAN_SPECIFIC');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Біль в кінцівці','ORGAN_SPECIFIC');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Висип на лиці','ORGAN_SPECIFIC');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Протеїнурія','LABORATORY');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Підвищенна ехогенність печінки','INSTRUMENTAL');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Підвищенна артеріальний тиск','INSTRUMENTAL');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Знижений обєм легень','INSTRUMENTAL');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Лейкоцитоз','LABORATORY');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Слухові галюцінації','PSYCHOLOGICAL');--20
insert into symptoms values (default,'2023-08-05', '2023-08-05','Затьмарена свідомість','PSYCHOLOGICAL');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Депресія','PSYCHOLOGICAL');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Маніакальна поведінка','PSYCHOLOGICAL');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Нізький рівень гемоглобіну','LABORATORY');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Підвищенний рівень цукру','LABORATORY');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Серпоподібні еритроцити','LABORATORY');
insert into symptoms values (default,'2023-08-05', '2023-08-05','Генетичний тест на муковісцидоз','LABORATORY');


--  Diseases-Symptoms
insert into disease_symptom values (1, 1);
insert into disease_symptom values (2, 1);
insert into disease_symptom values (5, 1);
insert into disease_symptom values (6, 1);
insert into disease_symptom values (8, 1);
insert into disease_symptom values (10, 1);
insert into disease_symptom values (19, 1);

insert into disease_symptom values (1, 2);
insert into disease_symptom values (2, 2);
insert into disease_symptom values (5, 2);
insert into disease_symptom values (6, 2);
insert into disease_symptom values (8, 2);
insert into disease_symptom values (10, 2);
insert into disease_symptom values (11, 2);
insert into disease_symptom values (19, 2);
insert into disease_symptom values (21, 2);

insert into disease_symptom values (1, 3);
insert into disease_symptom values (2, 3);
insert into disease_symptom values (5, 3);
insert into disease_symptom values (6, 3);
insert into disease_symptom values (8, 3);
insert into disease_symptom values (9, 3);
insert into disease_symptom values (19, 3);

insert into disease_symptom values (1, 4);
insert into disease_symptom values (2, 4);
insert into disease_symptom values (4, 4);
insert into disease_symptom values (6, 4);
insert into disease_symptom values (12, 4);

insert into disease_symptom values (2, 5);
insert into disease_symptom values (4, 5);
insert into disease_symptom values (5, 5);
insert into disease_symptom values (12, 5);

insert into disease_symptom values (5, 6);
insert into disease_symptom values (11, 6);
insert into disease_symptom values (17, 6);

insert into disease_symptom values (1, 7);
insert into disease_symptom values (2, 7);
insert into disease_symptom values (5, 7);
insert into disease_symptom values (6, 7);
insert into disease_symptom values (10, 7);
insert into disease_symptom values (11, 7);
insert into disease_symptom values (19, 7);

insert into disease_symptom values (3, 8);
insert into disease_symptom values (4, 8);
insert into disease_symptom values (5, 8);
insert into disease_symptom values (21, 8);

insert into disease_symptom values (5, 9);
insert into disease_symptom values (13, 9);

insert into disease_symptom values (20, 10);
insert into disease_symptom values (22, 10);

insert into disease_symptom values (22, 11);
insert into disease_symptom values (23, 11);

insert into disease_symptom values (3, 12);
insert into disease_symptom values (17, 12);
insert into disease_symptom values (25, 12);

insert into disease_symptom values (1, 13);
insert into disease_symptom values (2, 13);
insert into disease_symptom values (7, 13);
insert into disease_symptom values (14, 13);
insert into disease_symptom values (16, 13);

insert into disease_symptom values (6, 14);
insert into disease_symptom values (7, 14);
insert into disease_symptom values (24, 14);
insert into disease_symptom values (26, 14);

insert into disease_symptom values (2, 15);
insert into disease_symptom values (8, 15);
insert into disease_symptom values (10, 15);
insert into disease_symptom values (18, 15);
insert into disease_symptom values (27, 15);


--  Procedures
insert into procedures values (default,'2023-08-05', '2023-08-05','Рентгенографія','INSTRUMENTAL');
insert into procedures values (default,'2023-08-05', '2023-08-05','Загальний аналіз крові','LABORATORY');
insert into procedures values (default,'2023-08-05', '2023-08-05','Біохімічний аналіз крові','LABORATORY');
insert into procedures values (default,'2023-08-05', '2023-08-05','Апендектомія','TREATMENT');
insert into procedures values (default,'2023-08-05', '2023-08-05','Флюорографія','INSTRUMENTAL');

--  Diseases-Procedures
insert into disease_procedure values (2,1);
insert into disease_procedure values (3,1);
insert into disease_procedure values (5,1);

--Drugs
insert into drugs values (default,'2023-08-05', '2023-08-05', 'A-280-360', 'антибіотик, що діє бактеріостатично, інгібуючи синтез бактеріального білка за рахунок зв''язування з 50S-субодиницею рибосом. Препарат має широкий спектр антибактеріальної дії. До азитроміцину чутливі стрептококи, метицилінчутливі стафілококи, хламідії, легіонелли, клостридії, Haemophilus influenzae, Moraxella catarrhalis, пастерелла, фузобактерії, Porphyromonas, бліда спірохета, лістерія, борелія, нейсерії, сальмонели, шиґелли, єрсінії, Escherichia coli, Bordetella pertussis, Helicobacter pylori, мікоплазми, пептококи, пептострептококи. Нечутливими до азитроміцину є метицилінрезистентні стафілококи, ентерококи, більшість анаеробних бактерій.','г', 0.25,'ANTIBIOTICS', 'Азітроміцин',34);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'N-347-122', 'безбарвні голчасті кристали моноклінної структури, у чистому вигляді без запаху, але у вологому середовищі (наприклад при контакті з повітрям) набуває запаху оцтової кислоти. Одержують взаємодією оцтового ангідриду та саліцилової кислоти. Вживають як протизапальний, знеболювальний, жарознижувальний та антиагрегантний засіб.','г', 0.5,'ANALGESICS', 'Ацетилсаліцилова кислота',88);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'J-456-652', 'напівсинтетичний антибіотик з групи цефалоспоринів ІІІ покоління для парентерального введення широкого спектра дії. Цефтріаксон уперше синтезовано у лабораторії швейцарської компанії Hoffmann-La Roche[2], яка розпочала його випуск під торговою маркою «Роцефін». Цефтріаксон використовується у клінічній практиці з 1982 року.[3] Цефтріаксон, на думку багатьох експертів, вважається найуспішнішим із цефалоспоринів ІІІ покоління.','г', 1.0,'ANTIBIOTICS', 'Цефтріаксон',5);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'V-445-212', 'Дротаверин — синтетичний препарат, що по хімічному складу є похідним ізохіноліну та структурним аналогом папаверину. Механізм дії препарату полягає в інгібуванні ферменту фосфодіестерази IV типу, яка бере участь у регуляції скорочень гладких м''язів шлунково-кишкового тракту, сечовидільної системи та міометрію.','г', 2.0,'SPASMOLYTICS', 'Дротаверин',18);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'F-643-131', 'сильний опіоїд, що міститься в маку снодійному (Papaver somniferum). Використовується як знеболювальне, а також як рекреаційний наркотик та для створення інших опіоїдів..','г/кг ', 40,'ANALGESICS', 'Морфій',2);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'A-567-223', 'Спіронолактон є конкурентним антагоністом альдостерону. Він впливає на дистальні канальці нирок.
Через блокаду альдостерону пригнічує затримку води та Na+ та сприяє утриманню K+, що не тільки підвищує екскрецію Na+ та Cl−, та знижує екскрецію K+ з сечею, а й знижує екскрецію H+. У результаті цього сечогінний ефект має також гіпотензивну дію.','мг/кг ', 20,'DIURETICS', 'Спироналактон',22);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'G-892-584', 'Фуросемід є петльовим діуретиком швидкої дії з відносно сильним та короткочасним діуретичним ефектом. Фуросемід блокує Na+K+2CI-котранспортер, розташований у базальних мембранах клітин товстого сегмента висхідної частини петлі Генле: ефективність салуретичної дії фуросеміду, таким чином, залежить від потрапляння лікарського засобу до канальців у місцях просвітів шляхом аніонотранспортного механізму.','мкг,кг ', 100,'DIURETICS', 'Фуросемід',45);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'B-355-955', 'Метамізол чинить виражену аналгетичну та жарознижувальну дію в комбінації з менш чіткою протизапальною та спазмолітичною активністю. Його ефекти є результатом пригнічення синтезу простагландинів і ендогенних алгогенів, підвищення порога збудливості в таламусі і проведення больових екстеро- і інтероцептивних імпульсів у ЦНС, а також він впливає на гіпоталамус і формування ендогенних пірогенів.','мг/кг ', 10,'SPASMOLYTICS', 'Метамізол',2);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'B-452-981', 'Ванкоміцин – це трициклічний глікопептидний антибіотик, отриманий з Amycolatopsis orientalis, ефективний проти багатьох грампозитивних мікроорганізмів. Бактерицидна дія ванкоміцину полягає у пригніченні синтезу бактеріальної стінки за рахунок гальмування полімеризації глікопептидів та селективного інгібування синтезу РНК-бактерій. Перехресної резистентності між ванкоміцином та іншими антибіотиками не виникає.','мг/кг ', 25,'ANTIBIOTICS', 'Ванкоміцин',12);
insert into drugs values (default,'2023-08-05', '2023-08-05', 'R-223-561', 'Похідна речовина піразолону, блокатор циклооксигенази. Знижує утворення простагландинів із арахідонової кислоти. Відрізняється від інших блокаторів циклооксигенази незначно вираженим протизапальним ефектом при вираженій аналгетичній, жарознижувальній та спазмолітичній дії. Спазмолітична дія проявляється на гладку мускулатуру сечовивідних та жовчних шляхів.','г/кг ', 20,'ANALGESICS', 'Аналгін',89);

--  Diseases-Drug
insert into disease_drug values (1,1);
insert into disease_drug values (2,1);
insert into disease_drug values (3,1);
insert into disease_drug values (4,1);
insert into disease_drug values (7,1);
insert into disease_drug values (4,3);
insert into disease_drug values (7,3);
insert into disease_drug values (4,9);
insert into disease_drug values (7,9);


-- users

insert into users values ('ADMIN',1,'2023-12-10 18:28:17.916000','2023-12-10 18:28:17.916000','admin@mail.com', true, 'Mikola', 'Mikolenko', '$2a$10$oNvF33f6E84sfeHvHJ/ik.ULBRkOkXiuOAJyap1Wg.p9nDjpQzAsy', 1, 39, null, 'MALE');

-- Drug-analog

INSERT INTO analog_drug (drug_id, analog_id) VALUES (1, 3);
INSERT INTO analog_drug (drug_id, analog_id) VALUES (3, 1);
INSERT INTO analog_drug (drug_id, analog_id) VALUES (9, 1);
INSERT INTO analog_drug (drug_id, analog_id) VALUES (1, 9);
INSERT INTO analog_drug (drug_id, analog_id) VALUES (3, 9);
INSERT INTO analog_drug (drug_id, analog_id) VALUES (9, 3);

