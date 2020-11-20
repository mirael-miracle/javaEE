package com.rest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/ctofservice")
public class TestClass {
	@GET
	@Produces("application/xml")
	public void convertCtoF() {
		 List<Character> alphabet = Arrays.asList(
				    'a','b','c','d','e',
				            'f','g','j', 'k', 'l', 'm','n','o','p',
				            'q','r','s','t','u','v','w','x','y','z'
				    );

				        ArrayList<String> list = new ArrayList<String>();
				        for(int i = 0; i < 1; i++){
				            String line = "Example";
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
				                String result = (letter + " " + count);
				              
				            }
				            
		}
						
	}
}
