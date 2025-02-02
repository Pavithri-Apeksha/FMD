package com.developerstack.edumanage.util.tools;

import java.util.Random;

public class VerificationCodeGenerator {
    private String NUMBERS = "0123456789";
    public int getCode(int length){
        StringBuilder code = new StringBuilder();
        for(int i=0; i<length; i++){
            char c = NUMBERS.charAt(new Random().nextInt(NUMBERS.length()));
            if(i==0 && (48==(int)c)){
                c = NUMBERS.charAt(new Random().nextInt(NUMBERS.length()-1+1)+1);
            }
            code.append(c);
        }
        return Integer.parseInt(code.toString());
    }
}
