package contactsDemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    private final ContactRepository repository;
    //private int count;


    ContactController(ContactRepository repository) {
        this.repository = repository;
        //count = 0;
    }

    @GetMapping("/api/contacts")
    List<Contact> all() {
        return repository.findAll();
    }

    @PostMapping("/api/contacts") @ResponseStatus(HttpStatus.CREATED)
    Contact newContact(@RequestBody Contact newContact) {
        //System.out.println(IdGenerator.getId());
        //newContact.setId(String.valueOf(count++));
        newContact.setId(IdGenerator.getId());
        return repository.save(newContact);
    }

    @DeleteMapping("/api/contacts")
    List<Contact> deleteContact() {
        List<Contact> temp = repository.findAll();
        repository.deleteAll();
        return temp;
    }

    // Single item

    @GetMapping("/api/contacts/{id}")
    Contact one(@PathVariable String id) {

        return repository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    @PutMapping("/api/contacts/{id}")
    Contact replaceContact(@RequestBody Contact newContact, @PathVariable String id) {

        return repository.findById(id)
                .map(contact -> {
                    contact.setFirstname(newContact.getFirstname());
                    contact.setFamilyname(newContact.getFamilyname());
                    //contact.setId(newContact.getId());
                    contact.setPhonenumber(newContact.getPhonenumber());
                    contact.setEmail(newContact.getEmail());
                    return repository.save(contact);
                })

                .orElseGet(() -> {
                    newContact.setId(id);
                    return repository.save(newContact);
                });
    }

    @DeleteMapping("/api/contacts/{id}")
    Contact deleteContact(@PathVariable String id) {
        Contact temp = repository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
        repository.deleteById(id);
        return temp;
    }
}
