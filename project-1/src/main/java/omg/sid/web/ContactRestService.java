package omg.sid.web;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import omg.sid.dao.ContactRepository;
import omg.sid.entitie.Contact;

@RestController
@CrossOrigin("*")
public class ContactRestService {
@Autowired
private ContactRepository contact;

@GetMapping("/constacts")
public List<Contact> getContacts(){
	return contact.findAll();
}
@GetMapping("/chercher")
public List<Contact> chercher(@RequestParam(name="mc",defaultValue = "" )  String mc,@RequestParam(name="page",defaultValue = "0" )  int page ,@RequestParam(name="size",defaultValue = "5" )  int size){
	return contact.chercher("%"+mc+"%");
}
@GetMapping("/constacts/{id}")
public Optional<Contact> getbyid(@PathVariable Long id){
	return contact.findById(id);
}
@PostMapping("contact")
public Contact Save(@RequestBody Contact c ) {
	return contact.save(c);
}
@DeleteMapping("delete/{id}")
public void delete(@PathVariable Long id) {
	contact.deleteById(id);
}
@PutMapping("PUT/{id}")
public Contact put(@PathVariable Long id,@RequestBody Contact c) {
	c.setId(id);
	
	return contact.save(c);
}
}
