package com.bezkoder.spring.datajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "member")
public class Member {

    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 名前
     */
    @Column(name = "name")
    private String name;
    
    /**
     * 担当
     */
    @Column(name = "tantou")
    private String tantou;
    
    /**
     * クライアント
     */
    @Column(name = "cliant")
    private String cliant;
    
    /**
     * 稼働店舗
     */
    @Column(name = "tenpo")
    private String tenpo;
    
    /**
     * キャリア
     */
    @Column(name = "carrier")
    private String carrier;
}
