package com.reDesign.domin;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addReantal(Rental rental){
        _rentals.add(rental);
    }

    public String get_name() {
        return _name;
    }

    public String Statement(){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rentals Record for "+get_name()+"\n";
        while (rentals.hasMoreElements()){
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            switch (each.get_movie().get_priceCode()){
                case Movie.REGULAR:
                    thisAmount += 2;
                    if(each.get_daysRented()>2)
                        thisAmount+=(each.get_daysRented()-2)*1.5;
                    break;
                case Movie.NEW_BALANCE:
                    thisAmount += 1.5;
                    if(each.get_daysRented()>2)
                        thisAmount+=(each.get_daysRented()-2)*3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if(each.get_daysRented()>3)
                        thisAmount+=(each.get_daysRented()-3)*1.5;
                    break;
            }
            frequentRenterPoints ++ ;


        }
        return null;
    }
}
