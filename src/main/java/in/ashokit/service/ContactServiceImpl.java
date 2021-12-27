package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.ContactForm;
import in.ashokit.entitiy.Contact;
import in.ashokit.repositories.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService 
{
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String saveContact(ContactForm form) 
	{
		Contact contact = new Contact();
		BeanUtils.copyProperties(form, contact);
		contact.setActiveSw("Yes");
		Contact entity = contactRepo.save(contact);
		if (entity.getContactId() != null) 
		{
			return "Sucess adding contact";
		}
		return "Contact is not saved";
	}

	@Override
	public List<ContactForm> viewContacts() 
	{
		List<Contact> findAll = contactRepo.findAll();
		List<ContactForm> dataList = new ArrayList<>();
		for (Contact contact : findAll) 
		{
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(contact, form);
			dataList.add(form);
		}
		return dataList;
	}

	@Override
	public ContactForm editContact(Integer contactId) 
	{
		Optional<Contact> findById = contactRepo.findById(contactId);
		if (findById.isPresent()) {
			Contact entity = findById.get();
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			return form;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) 
	{
		contactRepo.deleteById(contactId);
		return viewContacts();
	}

}
