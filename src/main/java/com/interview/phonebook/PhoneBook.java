package com.interview.phonebook;

import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    private Map<String, Set<String>> phoneBook = new HashMap<>();

    public Set<String> get(String person) {
        Set<String> phones = phoneBook.get(person.toLowerCase());
        if (null == phones) {
            return Sets.newHashSet();
        } else {
            return Sets.newHashSet(phones);
        }
    }

    public void add(String person, String phone) {
        Set<String> phones = get(person);
        phones.add(phone);
        phoneBook.put(person.toLowerCase(), phones);
    }
}
