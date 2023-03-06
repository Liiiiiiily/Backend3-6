# Backend3-

Урок 3. Автоматизированное тестирование REST API с использованием rest-assured
1. Автоматизируйте GET /recepies/complexSearch (минимум 5 кейсов) и POST /recipes/cuisine (минимум 5 кейсов), используя rest-assured.
2. Сделать автоматизацию цепочки (хотя бы 1 тест со всеми эндпоинтами) для создания и удаления блюда в MealPlan). 
Подумайте, как использовать tearDown при тестировании POST /mealplanner/:username/shopping-list/items
3. Воспользуйтесь кейсами, которые вы написали в ДЗ №2, перенеся всю логику из постман-коллекции в код.
4. Сдайте ссылку на репозиторий, указав ветку с кодом.

Урок 4. Расширенные возможности rest-assured. Работа со Spoonacular API
1. Отрефакторьте код проверок и добавьте дополнительные тесты для запросов из цепочки Shopping List, используя rest-assured.
2. Воспользуйтесь кейсами из ПЗ № 2 и 3, перенеся всю логику из постман-коллекции в код.
3. Сдайте ссылку на репозиторий, указав ветку с кодом.
Главные критерии для проверки — отсутствие хардкода в коде тестов и наличие тестов на запросы Add to Shopping list (POST /mealplanner/:username/shopping-list/items), 
Get Shopping List (GET /mealplanner/:username/shopping-list) и Delete from Shopping list (DELETE /mealplanner/:username/shopping-list/items/:id).
