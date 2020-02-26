package Evaluation;


    public class Number {
        boolean IsOperand(String s)
        {
            switch (s)
            {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case"5":
                case"6":
                case"7":
                case"8":
                case"9":
                case"10":
                    return true;

                default:
                    return false;
            }
        }
    }

