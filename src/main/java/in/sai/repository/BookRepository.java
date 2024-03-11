package in.sai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sai.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	
	
}
