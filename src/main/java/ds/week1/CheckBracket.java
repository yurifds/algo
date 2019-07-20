package ds.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class CheckBracket {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();

        if(text.length() == 1) {
            printPosition(1);
            return;
        }

        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                if(position == text.length() - 1) {
                    printPosition(position + 1);
                    return;
                }
                opening_brackets_stack.push(new Bracket(next, position));
            }

            if (next == ')' || next == ']' || next == '}') {
                if(opening_brackets_stack.isEmpty()){
                    printPosition(position + 1);
                    return;
                }
                Bracket top = opening_brackets_stack.pop();
                if(top.Match(next)) {
                    continue;
                }else {
                    printPosition(position + 1);
                    return;
                }
            }
        }

        if(!opening_brackets_stack.isEmpty()){
            Bracket top = opening_brackets_stack.pop();
            printPosition(text.indexOf(top.type) + 1);
            return;
        }
        System.out.println("Success");
    }

    private static void printPosition(int position){
        System.out.println(position);
    }
}
