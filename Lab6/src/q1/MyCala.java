/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ngoth
 */
public class MyCala implements ICala{
    private ArrayList<Cala> calalist;
    
    public MyCala(){
        this.calalist = new ArrayList<>();
    }
    
    @Override
    public int f1(ArrayList<Cala> a){
        int count = 0;
        for (Cala cala : a) {
            if(Character.isDigit(cala.getOwner().charAt(2)))
                count++;
        }
        return count;
    }

    @Override
    public int f2(ArrayList<Cala> a) {
        if(a.size() < 2)
            return 0;
        int max = Collections.max(a, Comparator.comparingInt(Cala::getPrice)).getPrice();
        ArrayList<Cala> maxPrice = new ArrayList<>();
        for (Cala cala : a) {
            if(cala.getPrice() == max)
                maxPrice.add(cala);
        }
        if(maxPrice.size() > 1){
            a.remove(maxPrice.get(1));
            return 1;
        }
        return 0;
    }

    @Override
    public int f3(ArrayList<Cala> a) {
        Collections.sort(a, Comparator.comparingInt(c -> c.getOwner().charAt(1)));
        return 1;
    }

    @Override
    public String printData(ArrayList<Cala> a) {
        if(a.isEmpty()){
            return "Empty";
        }
        StringBuilder sb = new StringBuilder();
        for (Cala cala : a) {
            sb.append("(").append(cala.getOwner()).append(",").append(cala.getPrice()).append("),");
        }
        if(sb.length() > 0)
            sb.setLength(sb.length() - 1);
        return sb.toString();
    }
    
    public void addCala(Cala cala){
        calalist.add(cala);
    }
    
    public ArrayList<Cala> getCalaList(){
        return calalist;
    }
}
