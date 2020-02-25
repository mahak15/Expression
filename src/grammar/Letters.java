package grammar;

import java.util.*;

public class Letters {
    Set<Character> Number;
    Set<Character> Characters;
    Set<Character> Operators;
    Set<Character> Symbols;


        Letters() {
            Number = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
            Characters = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
            Operators = new HashSet<>(Arrays.asList('+', '-', '/', '*','^','%'));
            Symbols = new HashSet<>(Arrays.asList('.','(',')'));
        }

        String getType(Character ch) {
            if (Number.contains(ch)) return "Number";
            else if (Operators.contains(ch)) return "Operators";
            else if(Characters.contains(ch)) return "Character";
            else if (Symbols.contains(ch)) return "Symbol";
            else return "invalid";
        }
    }




