package in.sai.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.sai.entity.Book;
import in.sai.repository.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repo; 
	
	
	@GetMapping("/book")
	public ModelAndView getBookById(@RequestParam("id") Integer  id) {
		
		ModelAndView mav = new ModelAndView();
		
		Optional<Book> findById = repo.findById(id);
		System.out.println("Id :"+id);
		if(findById.isPresent()) {
			Book bookObj= findById.get();
			
			System.out.println(bookObj);
			
			//sending the data to view
			mav.addObject("book", bookObj);
			
		}
		//setting view page name
		mav.setViewName("index");
		
		
		return mav;
		/*
		 //Another Approach 
		  
		  
		  
		  @GetMapping("/book")
	    public String  getBookById(@RequestParam("id") Integer  id,Model model) {
		
		
		Optional<Book> findById = repo.findById(id);
		System.out.println("Id :"+id);
		if(findById.isPresent()) {
			Book bookObj= findById.get();
			
			System.out.println(bookObj);
			
			//sending the data to view
			model.addAttribute("book", bookObj);
			
		}
		return "index";
		  
		  
		 */
	}
	
	
	
	
}
