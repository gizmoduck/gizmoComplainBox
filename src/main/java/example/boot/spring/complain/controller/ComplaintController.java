package example.boot.spring.complain.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.boot.spring.complain.exception.ResourceNotFoundException;
import example.boot.spring.complain.model.Complaint;
import example.boot.spring.complain.repository.ComplaintRepository;

@RestController
@RequestMapping("/api")
public class ComplaintController {
	
	@Autowired
	ComplaintRepository complaintRepository;
	
	
	//Get All complaints
	@GetMapping("/complaints")  //@GetMapping("/complaints") annotation is a short form of @RequestMapping(value="/complaints", method=RequestMethod.GET)
	public List<Complaint> getAllComplaint() {
		return complaintRepository.findAll();
	}
	
	//add a complaint
	//@RequestBody annotation is used to bind the request body with a method parameter
	//@Valid annotation makes sure that the request body is valid. Remember, 
	//we had marked Note’s title and content with @NotBlank annotation in the Complaint model?
	//If the request body doesn’t have a title or a content, then spring will return a 400 BadRequest error to the client
	@PostMapping("/complaints")
	public Complaint addComplaint(@Valid @RequestBody Complaint complaint) {  	
		return complaintRepository.save(complaint);
	}
	
	//update a complaint
	@PutMapping("/complaints/{id}")
	public Complaint upgateComplaint(@PathVariable(value="id") Long complaintId, @Valid @RequestBody Complaint complaintDetails) {  	
		Complaint complaint = complaintRepository.findById(complaintId)
				.orElseThrow(() -> new ResourceNotFoundException("Complaint", "id", complaintId));
		complaint.setContent(complaintDetails.getContent());
		complaint.setTitle(complaintDetails.getTitle());
		
		Complaint updatedComplaint = complaintRepository.save(complaint); 
		return updatedComplaint;
		
	}
	//delete a complaint
	@DeleteMapping("/complaints/{id}")
	public void deleteComplaintById(@PathVariable(value="id") Long complaintId) {
		complaintRepository.deleteById(complaintId);
	}
	//get a single complaint
	@GetMapping("/complaints/{id}")
	public Complaint getComplaintById(@PathVariable(value="id") Long complaintId) {
		return complaintRepository.findById(complaintId)
				.orElseThrow(() -> new ResourceNotFoundException("Complaint", "id", complaintId));
	}
	

	
}
