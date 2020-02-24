package grammar;

public class Token {

    String type;
    String data;

    public Token(String name, String value) {
        type = name;
        data = value;
    }

    public String tokToString() {
        return "<" + type + "," + data + ">" ;
    }
};

