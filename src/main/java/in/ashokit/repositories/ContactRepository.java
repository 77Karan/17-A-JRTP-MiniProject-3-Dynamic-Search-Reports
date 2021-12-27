package in.ashokit.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entitiy.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable>
{
	

}
