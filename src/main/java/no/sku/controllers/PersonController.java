package no.sku.controllers;

import no.sku.person.Person;
import no.sku.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {


    @GetMapping("/error")
    public String customError() {
        return "The link you followed may be broken, or the page may have been removed.";
    }

    @GetMapping
    public List<Person> allPersons() {
        return PersonRepository.fetchAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") UUID id) {
        return PersonRepository.fetchPersonById(id);
    }

    @PostMapping("/{id}")
    public void createPerson(@RequestBody Person person) {
        Person newPerson = new Person(person.getFirstName(), person.getLastName());
        PersonRepository.save(newPerson);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person person) {
        PersonRepository.update(id, person.getFirstName(), person.getLastName());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        PersonRepository.delete(id);
    }

    @GetMapping("/{id}/palindrome")
    public String checkPalindrome(@PathVariable("id") UUID id) {
        Person person = PersonRepository.fetchPersonById(id);

        assert person != null;
        if(isPalindrome(person.getFirstName())) return person.getFirstName() + " er et palindrom!";
        if(isPalindrome(person.getLastName())) return person.getLastName() + " er et palindrom!";

        return "Dessverre hadde ikke denne personen et palindrom.";
    }

    private boolean isPalindrome(String text) {
        StringBuilder reversedText = new StringBuilder();
        for(int i=0; i<text.length(); i++){
            char c = text.charAt(i);
            reversedText.insert(0, c);
        }
        return text.equalsIgnoreCase(reversedText.toString());
    }


}
