import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;


public class pruebas{
    public static void main(String[] args){

        String[] arr = {"a", "b", "c", "d"};
        char[] arrChar = {'a', 'b', 'c', 'd'};
        // try{

        //     Scanner scan = new Scanner(new File("./tests/afd/hex.afd"));
        //     List<String> lista = new ArrayList<>();

        //     while(scan.hasNextLine()){
        //         lista.add(scan.nextLine());
        //     }

        //     System.out.println("Linea 1 como int: " + "\n\t" + (Integer.parseInt(lista.get(0)) + 1));

        //     for(int i = 1; i < lista.size(); i++){
        //         System.out.println("Linea " + (i+1) + ": " + "\n\t" + lista.get(i));
        //     }

        //     scan.close();
        // } catch(FileNotFoundException e){
        //     System.out.println("FALLÓ TU PROGRAMA, BROCOLI");
        // }

        // for(int i = 0; i < arr.length; i++){
        //     if(arr[i].equals(String.valueOf('c'))){
        //         System.out.println("Esta es una c");
        //         continue;
        //     }System.out.println("Esta NO es una c");
        // }

        // if(arrChar[0] == 'a') System.out.println("SIMON");

        // String file = "1,2,3,4";

        // String[] alphStr = file.split(",");
		// for(int i = 0; i < alphStr.length; i++){
		// 	System.out.println(alphStr[i].charAt(0));
		// }

        // String str = "abcde";
        // String[] arrStr = new String[str.length()];
        // arrStr = str.split("");

        // for(String i : arrStr){
        //     System.out.println(i);
        // }

        int[] finalState = {1, 2};
        int currentState = 3;
        for(int i : finalState){
			if(currentState == i){
				System.out.println("true");
                break;
			}
		    System.out.println("false");
		}

    }
}