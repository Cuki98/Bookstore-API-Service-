package net.javaguides.restfulapitest.controller;

import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;

import java.util.List;
import javax.validation.Valid;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import net.javaguides.restfulapitest.repository.BookRepository;
import net.javaguides.restfulapitest.repository.RatingRepository;
import net.javaguides.restfulapitest.model.Rating;
import net.javaguides.restfulapitest.model.User;
import net.javaguides.restfulapitest.model.Book;
import net.javaguides.restfulapitest.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;

    //get ratings in a descending order
    @GetMapping("ratings")
    public List<Rating> getAllRatings() {
        return this.ratingRepository.findAll(Sort.by(Sort.Direction.DESC, "rating"));
    }

    //get ratings by RID
    /* @GetMapping("/ratings/{rid}")
    public ResponseEntity<Rating> getRatingByrid(@PathVariable(value= "rid") Long rid)
        throws ResourceNotFoundException {
            Rating rating = ratingRepository.findById(rid)
                .orElseThrow(() -> new ResourceNotFoundException("Ratings for this ISBN not found: "  + rid));
            return ResponseEntity.ok().body(rating);
        } */

    //get ratings by ISBN and rating descending
    /*@GetMapping("/ratings/book/{isbn}")
    public List<Rating> getByISBN(@PathVariable Long isbn) {
        List<Rating> ratings = new ArrayList<>();
        ratingRepository.findByBookISBNOrderByRatingDesc(isbn).forEach(ratings::add);
        return ratings;
    }*/
    
    //get the average rating for a book
    @GetMapping("/ratings/book/{isbn}")
    public Double avg(@PathVariable Long isbn) {
        return ratingRepository.avg(isbn);
    }


    //save rating
    @PostMapping("ratings")
    public Rating createRating(@RequestBody Rating rating) {
        return this.ratingRepository.save(rating);
    }

    //update rating
    @PutMapping("ratings/{rid}")
    public ResponseEntity<Rating> updateRating(@PathVariable(value = "RID") Long RID, @Valid @RequestBody Rating ratingDetails) throws ResourceNotFoundException {
        Rating rating = ratingRepository.findById(RID)
                .orElseThrow(() -> new ResourceNotFoundException("Ratings for this RID not found: "  + RID));
        
        rating.setComment(ratingDetails.getComment());
        rating.setRating(ratingDetails.getRating());

        return ResponseEntity.ok(this.ratingRepository.save(rating));
    }

    //delete rating
    @DeleteMapping("ratings/{rid}")
    public Map<String, Boolean> deleteRating(@PathVariable(value = "RID") Long RID) throws ResourceNotFoundException {
        Rating rating = ratingRepository.findById(RID)
                .orElseThrow(() -> new ResourceNotFoundException("Ratings for this RID not found: "  + RID));
        
        this.ratingRepository.delete(rating);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

}
