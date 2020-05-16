package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println(substringPositions("ATTTTCTAAATATCTAAATTTCTAAATTGATCTAAATTCACCACTGCTTCCTCTAAATTCTAAATTGTCTAAATGTTATCTAAATTCATGTCTAAATATAATCTAAATGAAGTGTCTAAATTTTAATGATCTAAATATATCTAAATGACCTTCTAAATATAGTCTAAATCCTCTAAATTCTAAATGGGTCTAAATCGTCTAAATTCTAAATTCTAAATCTCTAAATTGGTCTCTAAATTATGAGTCTAAATATTTTAAGCGCAGGCTCTAAATGGTACTTACTGGCTGTCTAAATTTTCTAAATTAAATCTAAATGGAAGCGTCTAAATTCTAAATTTCTAAATTCTCTAAATTTCTAAATGGAATCTAAATGCTATCTAAATCAGCAGTATTCTAAATGTTCTAAATAAGAAGTCTAAATATCTAAATCTTCTAAATCACGATCTAAATATCTAAATTCTAAATTATTCGTCTAAATCTCTAAATTCTAAATTCTAAATAAAGATCTAAATCTCATCTAAATACTCTAAATCGGTTTAGTCTAAATGTCTAAATATCTAAATTGTGATCTAAATACTATCTAAATTTAACGACTCTACTCTAAATTCTAAATTCTAAATTGTCTAAATTCTAAATGGGACACAATCTAAATCGTCTAAATTTCTAAATTGAATCTAAATATTACTCTAAATGCGTGTCTAAATATCTAAATTACTCTAAATTCTAAATATCTAAATTGTCTAAATCTCTAAATCACTCTAAATTTCTAAATCTCTCTAAATATTCTAAATCCTGGCGTGTACTCTAAATATGCTCTAAATTGTCTAAATACTCTAAATAATCTAAATGATCTAAATTTCTAAATCTCTAAATCGATCTAAATTCTAAATTTCTAAATTCTAAATTCTAAATAATAATGTCTCTAAATTTGGTGCATCCGTTCTAAATTGG", "TCTAAATTC"));
    }

    public static ArrayList<Integer> substringPositions(String DNA, String sub){
        ArrayList<Integer> indexes = new ArrayList<>();

        for(int i=0; i<DNA.length()-sub.length(); i++){
            boolean term = true;

            if(DNA.charAt(i) == sub.charAt(0)){
                for(int j=1; j<sub.length(); j++){
                    if(DNA.charAt(i + j) != sub.charAt(j)) {
                        term = false;
                    }
                }
            }
            if(DNA.charAt(i) == sub.charAt(0) && term == true){
                indexes.add(i+1);
            }
        }

        return indexes;
    }

    public static int HammingDistance(String s, String t){
        int dist = 0;

        if(s.length() != t.length())
            return -1; //return -1 if DNAs have differente lengths
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                dist++;
            }
        }

        return dist;
    }

    public static char[] Reverse(String t){
        char[] tArr = t.toCharArray();
        int low = 0;
        int high = tArr.length;
        while(low < high){
            char temp = tArr[low];
            tArr[low] = tArr[high-1];
            tArr[high-1] = temp;
            low++;
            high--;
        }
        return tArr;
    }

    public static String ReverseCompliment(String t){
        char[] reversed = Reverse(t);
        for(int i=0; i<reversed.length; i++){
            if(reversed[i] == 'A'){
                reversed[i] = 'T';
            }
            else if(reversed[i] == 'T'){
                reversed[i] = 'A';
            }
            else if(reversed[i] == 'C'){
                reversed[i] = 'G';
            }
            else if(reversed[i] == 'G'){
                reversed[i] = 'C';
            }
        }
        return new String(reversed);
    }

    public static String RNA(String t) {
        String newt = t.replace('T', 'U');
        return newt;
    }
}
