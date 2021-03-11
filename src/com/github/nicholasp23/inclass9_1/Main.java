package com.github.nicholasp23.inclass9_1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // TODO: loop through getPasswords() and print out all passwords
        for(String secretPasswords: getPasswords()){
            System.out.println(secretPasswords);
        }
    }

    private static List<String> getPasswords() {
        // TODO: Get passwords from Passwords.java via reflection

        Field[] fields = Passwords.class.getDeclaredFields();
        List<String> passwords = new ArrayList<>();

        for(Field field : fields){
            field.setAccessible(true);
            try{
                passwords.add(((String) field.get(null)).replace("@", ""));
                //passwords.add(((String) field.get(null)).replace("@",""));
            }
            catch (IllegalAccessException ignored){}
        }
        return passwords;
    }



}
