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
public class Pxpagexinterface implements Serializable {
	private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
           
    //
    private String name;
       
    //
    private Long pxpageId;
       
    //
    private String pxpageName;
       
    //
    private Long xinterfaceId;
       
    //
    private String xinterfaceName;
       
    public Pxpagexinterface() {
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
     public Long getPxpageId(){
         return this.pxpageId;
     };
     public void setPxpageId(Long pxpageId){
         this.pxpageId = pxpageId;
     }
     
     //
     public String getPxpageName(){
         return this.pxpageName;
     };
     public void setPxpageName(String pxpageName){
         this.pxpageName = pxpageName;
     }
     
     //
     public Long getXinterfaceId(){
         return this.xinterfaceId;
     };
     public void setXinterfaceId(Long xinterfaceId){
         this.xinterfaceId = xinterfaceId;
     }
     
     //
     public String getXinterfaceName(){
         return this.xinterfaceName;
     };
     public void setXinterfaceName(String xinterfaceName){
         this.xinterfaceName = xinterfaceName;
     }
     



	@Override
	public String toString() {
		return "CLASS DATA: [id=" + id +"]";
	}
}
