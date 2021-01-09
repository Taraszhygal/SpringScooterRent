package com.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/*
CRUD for Books
CRUD for User
CRUD for Order
get orders for user
add to cart/remove from/get cart
==============================  
unit test
int test
=======
will be done :
exceptions
REST API
simulate DB

--master бренча--
git checkout -b назва_нової_бренчі
git add .
git commit -m "назва коміту"
git push origin назва_нової_бренчі
git log - показує останні коміти (вихід q)
git pull - завантажує всі зміни з бренчі на якій ви знаходитеся
git reset . - зворотня команда до git add
git merge назва_бренчі - змерджить "назва_бренчі" у вашу теперішню бренчу
master -> git checkout -b назва_першої_бренчі -> мерджите через ПР в мастер  ->
-> переходите в мастер -> git pull -> git checkout -b назва_другої_бренчі  ->
-> мерджите через ПР в мастер
resource/controller - повинен бути простим
service - містить бізнес-логіку
repository - містить спосіб отримання даних
entity - працює ЛИШЕ з репозиторієм, серсісом та маппером
mapper - робить конвертацію між entity та dto
dto/model - працює ЛИШЕ з контроллер/ресурс, серсісом та маппером
exception - містить вийняткові ситуації та обробник
KISS - залиш це простим
DRY - не повторюй себе
YAGNI - тобі це не потрібно
200 - все ок
300 - редірект
400 - помилка клієнта
500 - помилка сервера
*/
