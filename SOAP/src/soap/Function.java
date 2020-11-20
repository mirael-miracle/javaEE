package soap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Function {
	
	@WebMethod(operationName="counterWords")
	public void counter(String string) {
		  List<Character> alphabet = Arrays.asList(
				    'a','b','c','d','e',
				            'f','g','i','j', 'k', 'l', 'm','n','o','p',
				            'q','r','s','t','u','v','w','x','y','z'
				    );
		  ArrayList<String> list = new ArrayList<String>();
	        for(int i = 0; i < 1; i++){
	            String line = string;
	            list.add(line.toLowerCase());
	        }
	        for(char letter:alphabet){
	            int count = 0;
	            for(String listItem : list){
	                for(int j = 0;j<listItem.length();j++){
	                    if(listItem.charAt(j)==letter){
	                        count++;
	                    }
	                }
	            }
	            if(count>0) {
	                System.out.println(letter + " " + count);
	            }
	        }
	    
	}
}
