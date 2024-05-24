package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NaturalId
    private String dni;

    public Employee() {
    }

    public Employee(String name, String dni) {
        this.name = name;
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


//    @Override
//    public boolean equals(Object obj) {
////        System.out.println("equals");
//        if(this == obj) return true;
//        if(obj == null || Hibernate.getClass(this) != Hibernate.getClass(obj)) return false;
//        var emp = (Employee) obj;
//        return dni != null && Objects.equals(dni, emp.dni);
//    }
//
//    @Override
//    public int hashCode() {
////        System.out.println("hashCode");
////        return getClass().hashCode();
//        return Objects.hashCode(dni);
//    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "dni = " + dni + ", " +
                "name = " + name + ")";
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Employee employee = (Employee) o;
        return getId() != null && Objects.equals(getId(), employee.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
