package com.nickolamora.springbootdemodailycodebuffer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * @Data is a convenient shortcut annotation that bundles the features of
 * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together:
 * In other words, @Data generates all the boilerplate that is normally associated with simple POJOs (Plain Old Java Objects)
 * and beans: getters for all fields, setters for all non-final fields, and appropriate toString, equals and hashCode implementations
 * that involve the fields of the class, and a constructor that initializes all final fields, as well as all
 * non-final fields with no initializer that have been marked with @NonNull, in order to ensure the field is never null.
 */
@Data
/**
 * @NoArgsConstructor will generate a constructor with no parameters.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Department {

  // Sets the PK
  @Id
  //Auto Generates the ID based on a strategy i.e UUID
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long departmentId;

  @NotBlank(message = "Please Add Department Name")
//  @Length(max = 5, min = 1)
//  @Email
//  @Positive
//  @NegativeOrZero
  private String departmentName;
  private String departmentAddress;
  private String departmentCode;

}
