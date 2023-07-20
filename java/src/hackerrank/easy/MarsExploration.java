package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarsExploration {
    public static int marsExploration(String s) {
        int sosStart = 0;
        int sosEnd = 3;
        int alteracoes = 0;

        while(sosEnd <= s.length()){
            char[] sosSubstring = s.substring(sosStart, sosEnd).toCharArray();

            if(sosSubstring[0] != 'S') alteracoes += 1;
            if(sosSubstring[1] != 'O') alteracoes += 1;
            if(sosSubstring[2] != 'S') alteracoes += 1;

            sosStart += 3;
            sosEnd += 3;
        }

        return alteracoes;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("SOSSOT", "SOSSPSSQSSOR", "SOSOSOSOSDSDSKWOSDOSDOASDOASDFAFJDFDOSOSOWNSOSOSNDSKDDOSOSOSJDSDSOOSOSDSDOSASSOASDSAOSOSODSDSOASDWS"));

        for(String str : strings) {
            System.out.println(marsExploration(str));
        }
    }
}
