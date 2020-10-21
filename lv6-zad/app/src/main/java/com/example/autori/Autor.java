package com.example.autori;


public class Autor {
// todo
//        Autor ima sljedece atribute:
//      Ime
//      Prezime
//      Broj objavljenih knjiga
//      Najprodavanija knjiga
//      Broj prodatih komada najprodavanije knjige
//
//    Klasa treba da ima prazan konstruktor kao i getere i setere

    private String firstName;
    private String lastName;
    private String bookName;
    private int objave;
    private int prodaja;


    public Autor() {
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getObjave() { return objave; }
    public void setObjave(int objave) {this.objave = objave; }

    public int getProdaja() { return prodaja; }
    public void setProdaja(int prodaja) { this.prodaja = prodaja; }

}
