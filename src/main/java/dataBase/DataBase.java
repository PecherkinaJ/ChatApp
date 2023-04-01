package dataBase;

public class DataBase {

    // медод добавления в БД
    // мб надо будет поменять местами if и try-catch;
    // либо в try-catch запрос к БД, а далее в условии проверка наличия пользователя
    public String setNewUser(String email, String password, String nickName){
        try {
            // проверка, есть ли пользователь в БД, в условии
            // подставить нужное условие
            if (1 != 0) {
                // если нет - добавить и прислать об этом сообщение
                return "new user added";
            }
            // если есть - ошибка
            else return "user already exists";
        } catch (Exception e) {
            return "exception; not added";
        }
    }
}
