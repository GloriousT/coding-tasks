package com.interview.phonebook;

import com.interview.phonebook.PhoneBook;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookTest {

    private PhoneBook phoneBook = new PhoneBook();

    @Test
    public void shouldReturnEmptyListForNotKnownPerson() {
        assertThat(phoneBook.get("non existing")).isEmpty();
    }

    @Test
    public void shouldReturnOnePhone() {
        phoneBook.add("Name", "aPhone");

        Set<String> person = phoneBook.get("Name");

        assertThat(person).containsExactly("aPhone");
    }

    @Test
    public void shouldReturnMoreThanOnePhone() {
        phoneBook.add("Name", "phone1");
        phoneBook.add("Name", "phone2");

        Set<String> personPhones = phoneBook.get("Name");

        assertThat(personPhones).containsExactlyInAnyOrder("phone1", "phone2");
    }

    @Test
    public void shouldReturnPhonesForAppropriatePersons() {
        phoneBook.add("Name", "phone1");
        phoneBook.add("Other Name", "phone2");

        assertThat(phoneBook.get("Name")).containsExactly("phone1");
        assertThat(phoneBook.get("Other Name")).containsExactly("phone2");
    }

    @Test
    public void shouldNotReturnDuplicatePhones() {
        phoneBook.add("Name", "phone1");
        phoneBook.add("Name", "phone1");

        assertThat(phoneBook.get("Name")).containsOnlyOnce("phone1");
    }

    @Test
    public void shouldReturnPhonesForCaseInsensitiveNames() {
        phoneBook.add("Name", "phone");

        assertThat(phoneBook.get("name")).containsExactly("phone");
        assertThat(phoneBook.get("NAME")).containsExactly("phone");
        assertThat(phoneBook.get("nAmE")).containsExactly("phone");
    }
}
