package com.example.mongodb_spring.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "chibm")
public class Book implements Serializable {
    @Id
    private String id;
    @Indexed()
    private String name;
    private String author;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date publicationDate;
    private String describe;
}
