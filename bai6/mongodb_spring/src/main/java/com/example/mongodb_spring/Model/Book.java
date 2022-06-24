package com.example.mongodb_spring.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
    @Field(name = "name")
//    @TextIndexed()
    private String name;
    @Field(name = "author")
//    @TextIndexed()
    private String author;
    @Field(name = "publicationDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date publicationDate;
    @Field(name = "describe")
    private String describe;
}
