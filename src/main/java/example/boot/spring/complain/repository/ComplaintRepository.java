package example.boot.spring.complain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.boot.spring.complain.model.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}
