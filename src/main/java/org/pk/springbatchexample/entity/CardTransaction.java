package org.pk.springbatchexample.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CardTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String seriesReference;
    @Column
    private String period;
    @Column
    private String dataValue;
    @Column
    private String status;
    @Column
    private String units;
    @Column
    private String subject;
    @Column
    private String transactionGroup;
    @Column
    private String seriesTitle1;
    @Column
    private String seriesTitle2;
    @Column
    private String seriesTitle3;
    @Column
    private String seriesTitle4;
    @Column
    private String seriesTitle5;
}
