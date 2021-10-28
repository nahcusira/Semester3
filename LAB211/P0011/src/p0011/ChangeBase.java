/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0011;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ChangeBase {
     String HEX = "0123456789ABCDEF";
    
    public int checkInput(int min,int max,String msg){
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        while(true){
            try{
                n = Integer.parseInt(sc.nextLine());
                if(n > max || n < min){
                    System.out.println("Out of range,plz enter again: ");
                }else{
                    break;
                }
            }catch(Exception e){
                System.out.println("Wrong type input,plz enter number: ");
            }       
            
        }
        return n; 
    }
    
    public String checkValue(String msg,String regex){
        String n = "";
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        while(true){
            n = sc.nextLine();
            if(!n.matches(regex)){
                System.out.println("Type incorrect,plz enter again: ");
            }else{
                break;
            }
                
        }
        return n;
                
    }
    
    public String DectoOther(int Dec,int Base){
        String result = "";
        while(Dec > 0){
            result = HEX.charAt(Dec % Base) + result;
            Dec /= Base;
        }
        return result;
    }
    
    public int OthertoDec(String other,int base){
        int Dec = 0;
        for (int i = 0; i < other.length(); i++) {
            Dec += HEX.indexOf(other.toUpperCase().charAt(i)) * Math.pow(base, other.length() - i - 1);
        }
        return Dec;
    }

    public int base(int choice){
        int []base = {2,8,10,16};
        return base[choice - 1];
    }
    
    public static void main(String[] args) {
        String BIN = "[01]+";
        String DEC = "[0-9]+";
        String HEX = "[0-9a-fA-f]+";
        String OCT = "[0-7]+";
        
        ChangeBase cb = new ChangeBase();
        
        String[] regex = {BIN, OCT, DEC, HEX};
        
        int inputbase = cb.checkInput(1, 4, "Choose the base number input (1 is binary,2,is octal,3 is decimal, 4 is hexadecimal): ");
        int outputbase = cb.checkInput(1, 4, "Choose the base number output (1 is binary,2,is octal,3 is decimal, 4 is hexadecimal): ");
        
        String value = cb.checkValue("Enter the input value: ", regex[inputbase - 1]);
        
        System.out.println("Result is: ");
        
        if(cb.base(inputbase) == 10){
            System.out.println(cb.DectoOther(Integer.parseInt(value), cb.base(outputbase)));
        }else{
            System.out.println(cb.DectoOther(cb.OthertoDec(value, cb.base(inputbase)), cb.base(outputbase)));
        }
        
    }
}
