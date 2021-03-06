package com.simple.server.auto.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.*;

import com.simple.core.base.user.entity.*;
import com.simple.server.bz.entity.*;
import com.simple.server.auto.entity.*;

import java.util.List;


@Entity
public class Xmodulextable implements Serializable {
	private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
           
    //
    private String name;
       
    //
    private Long xmoduleId;
       
    //
    private String xmoduleName;
       
    //
    private Long xtableId;
       
    //
    private String xtableName;
       
    public Xmodulextable() {
	}
       
     //
     public Long getId(){
         return this.id;
     };
     public void setId(Long id){
         this.id = id;
     }
     
     //
     public String getName(){
         return this.name;
     };
     public void setName(String name){
         this.name = name;
     }
     
     //
     public Long getXmoduleId(){
         return this.xmoduleId;
     };
     public void setXmoduleId(Long xmoduleId){
         this.xmoduleId = xmoduleId;
     }
     
     //
     public String getXmoduleName(){
         return this.xmoduleName;
     };
     public void setXmoduleName(String xmoduleName){
         this.xmoduleName = xmoduleName;
     }
     
     //
     public Long getXtableId(){
         return this.xtableId;
     };
     public void setXtableId(Long xtableId){
         this.xtableId = xtableId;
     }
     
     //
     public String getXtableName(){
         return this.xtableName;
     };
     public void setXtableName(String xtableName){
         this.xtableName = xtableName;
     }
     



	@Override
	public String toString() {
		return "CLASS DATA: [id=" + id +"]";
	}
}
