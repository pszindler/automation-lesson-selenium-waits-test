package Models;

import com.github.javafaker.Faker;

public class UserFactory {

    public static User generateRandomUser() {
        Faker faker = new Faker();
        return new User.UserBuilder()
                .withFirstName(faker.name().firstName())
                .withLastName(faker.name().firstName())
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.internet()
                        .password(8, 10, true, true, true))
                .withBirthday(String.valueOf(faker.date().birthday(18, 85))).build();
    }

    public static User generateUser() {
        return new User.UserBuilder()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("doej@email.com")
                .withPassword("lubiePlacki88")
                .withBirthday("12/23/1990").build();
    }
}
