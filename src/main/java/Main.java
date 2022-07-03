public class Main {
    public static void main(String[] args) {
        Person father = new PersonBuilder() //Создаем отца в соответствии с требованиями
                .setName("Вася")
                .setSurname("Пупкин")
                .setAge(33)
                .setAddress("Москва")
                .build();

        Person mother = new PersonBuilder() //Создаем мать в соответствии с требованиями
                .setName("Лена")
                .setSurname("Головач")
                .setAge(20)
                .setAddress("Москва")
                .build();

        Person daughter = father.newChildBuilder() //Создаем дочь, которая получит фамилию отца и место его жительства
                .setName("Василиса")
                .setAge(0)
                .build();

        System.out.println("У " + father + " и " + mother + " есть дочь " + daughter); //выводим изначальные параметры созданных людей

        //прибавляем год к возрасту всех людей
        father.happyBirthday();
        mother.happyBirthday();
        daughter.happyBirthday();

        //выводим новый возраст
        System.out.println("Прошел год, и теперь " + father.getName() + " уже " + father.getAge() + " лет");
        System.out.println("Прошел год, и теперь " + mother.getName() + " уже " + mother.getAge() + " лет");
        System.out.println("Прошел год, и теперь " + daughter.getName() + " уже " + daughter.getAge() + " лет");

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}