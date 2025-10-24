package br.com.projeto.apialphyz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Review {
    @Id
    private String id;
    private String reviewedUserID;
    private String reviewerUserID;
    private String reviewedDate;
    private int rating;
}
