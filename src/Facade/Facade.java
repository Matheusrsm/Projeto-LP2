package Facade;

import easyaccept.EasyAccept;

public class Facade{
	
	public static void main(String[] args){
		args = new String[] {"Facade.Facade", "acceptance_test/us1_test (3).txt",
											 "acceptance_test/us2_test (3).txt",
											 "acceptance_test/us3_test (3).txt"};
		
		EasyAccept.main(args);
	}

}
