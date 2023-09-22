package io.github.librarymanagement.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOK_DETAILS")
@Data
@NoArgsConstructor
public class BookDetails extends BaseEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID")
  private String id;

  @Column(unique = true, name = "BOOK_ID")
  private String bookId;

  @Column(name = "BOOK_NAME")
  private String bookName;

  @Column(name = "BOOK_DESCRIPTION")
  private String description;

}
