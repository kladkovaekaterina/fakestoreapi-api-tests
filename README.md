## Проект c API тестами для [FakeStoreAPI](https://fakestoreapi.com/)
Этот репозиторий содержит набор тестов API для Fake Store API, который представляет собой простой электронный API, имитирующий функциональность сайтов для покупок.

### Навигация:
* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Список автоматизированных тест-кейсов</a>
* <a href="#console">Запуск тестов из терминала</a>
* <a href="#jenkins">Запуск тестов из Jenkins</a>
* <a href="#telegram">Уведомление в Telegram при помощи бота</a>
* <a href="#allure">Allure отчет</a>

____

<a id="tools"></a>
### <a name="Технологии и инструменты" style="color:black;"></a>Технологии и инструменты</a>
<p align="center">
<a href="https://www.java.com/">                      <img src="media/logos/java-original.svg"            width="45" height="45"    title="Java"/></a> 
<a href="https://www.jetbrains.com/idea/">            <img src="media/logos/intellij-original.svg"        width="45" height="45"    title="IntelliJ IDEA"/></a>   
<a href="https://gradle.org/">                        <img src="media/logos/gradle-original.svg"          width="45" height="45"    title="Gradle"/></a>
<a href="https://junit.org/junit5/">                  <img src="media/logos/junit-original.svg"           width="45" height="45"    title="JUnit 5"/></a>
<a href="https://rest-assured.io/">                   <img src="media/logos/restassured-original.png"     width="45" height="45"    title="Rest Assured"/></a>
<a href="https://github.com/">                        <img src="media/logos/github-original.svg"          width="45" height="45"    title="Github"/></a>
<a href="https://www.jenkins.io/">                    <img src="media/logos/jenkins-original.svg"         width="45" height="45"    title="Jenkins"/></a>  
<a href="https://github.com/allure-framework/allure2"><img src="media/logos/allure-original.svg"          width="45" height="45"    title="Allure"/></a> 
<a href="https://web.telegram.org/a/">                <img src="media/logos/telegram-original.svg"        width="45" height="45"    title="Telegram"/></a>
</p>

- Используемый стек:
  - <code>Java</code> - автотесты написаны на Java
  - <code>Gradle</code> - инструмент автоматизации сборки
  - <code>JUnit 5</code> - фреймворк для выполнения автотестов
  - <code>Rest Assured</code> - фреймворк для тестирования REST-API
  

- Используемая инфраструктура:
  - <code>Github</code> - хранение кода
  - <code>Jenkins</code> - CI/CD для запуска тестов удаленно
  - <code>Allure</code> - визуализация результатов тестирования
  - <code>Telegram Bot</code> - инструмент для отправки результатов тестирования


- Генерация данных: <code>Faker</code>

<a id="cases"></a>
### <a name="Список автоматизированных тест-кейсов" style="color:black;"></a>Список автоматизированных тест-кейсов</a>

- [Проверка работы сервера c Login функционалом:](https://github.com/kladkovaekaterina/fakestoreapi-api-tests/blob/main/src/test/java/api/tests/LoginTests.java)
  - Проверка ответа сервера на успешную авторизацию пользователя
  - Проверка ответа сервера на неуспешную авторизацию пользователя из-за неверного пароля
- [Проверка работы сервера с User функционалом:](https://github.com/kladkovaekaterina/fakestoreapi-api-tests/blob/main/src/test/java/api/tests/UserActionTests.java)
  - Проверка ответа сервера на успешное удаление пользователя
- [Проверка работы сервера с Product функционалом:](https://github.com/kladkovaekaterina/fakestoreapi-api-tests/blob/main/src/test/java/api/tests/ProductsActionTests.java)
  - Проверка ответа сервера на успешное изменение данных о товаре

<a id="console"></a>
### <a name="Запуск тестов из терминала" style="color:black;"></a><img src="media/logos/intellij-original.svg" width="20" height="20"/> Запуск тестов из терминала</a>

Проект можно скачать на локальную машину и запускать тесты через терминал.
 
```bash  
./gradlew clean test
```

<a id="jenkins"></a>
### <a name="Запуск тестов из Jenkins" style="color:black;"></a><img src="media/logos/jenkins-original.svg" width="20" height="20"/> Запуск тестов из [Jenkins](https://jenkins.autotests.cloud/job/25-KatherineMiers-fakestoreapi-api-tests/)</a>

Для того, чтобы тесты можно было запускать независимо от кого-либо, в <code>Jenkins</code> реализована джоба для удаленного запуска.
Чтобы запустить сборку в Jenkins необходимо c левой стороны страницы нажать на кнопку "Build Now".

Основная страница сборки:

![image](https://github.com/kladkovaekaterina/fakestoreapi-api-tests/assets/93866007/601b3d66-bad7-47a8-afbd-eae5e8b7b5b7)


<a id="telegram"></a>
### <a name="Уведомление в Telegram при помощи бота" style="color:black;"></a><img src="media/logos/telegram-original.svg" width="20" height="20"/> Уведомление в Telegram при помощи бота</a>

После завершения прогона автотестов, в соответствии с настройками в <code>Jenkins</code>, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом прохождения автотестов.

![image](https://github.com/kladkovaekaterina/fakestoreapi-api-tests/assets/93866007/366e1a1e-311a-4d5e-b784-4b585b117965)


<a id="allure"></a>
### <a name="Allure отчет" style="color:black;"></a><img src="media/logos/allure-original.svg" width="20" height="20"/></a> Allure [отчет](https://jenkins.autotests.cloud/job/25-KatherineMiers-lundenilona-tests/allure/)</a>

После завершения прогона автотестов, в соответствии с настройками в <code>Jenkins</code>, сформируется Allure отчет. Для просмотра отчета необходимо в Jenkins в окне "Build History" нажать на значок Allure, расположенный справа от номера билда. 

Пример основной страницы Allure отчёта: 

![image](https://github.com/kladkovaekaterina/fakestoreapi-api-tests/assets/93866007/84f24632-fd48-44a3-8924-5437b8e96869)

Пример страницы Behaviors Allure отчёта: 

![image](https://github.com/kladkovaekaterina/fakestoreapi-api-tests/assets/93866007/d7da4f95-885d-4e0d-a9a3-480c945fbb16)

