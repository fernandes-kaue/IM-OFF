package com.bookstore.jpa.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "book")
@Data
public class BookModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = false)
    private String title;

    @Column(nullable = false, unique = false)
    private String author;

    @Column(nullable = false, unique = true)
    private long ISBN;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private LibraryModel library;
}

