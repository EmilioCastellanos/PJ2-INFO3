import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
	Utilice esta clase para guardar la informacion de su
	AFD. NO DEBE CAMBIAR LOS NOMBRES DE LA CLASE NI DE LOS 
	METODOS que ya existen, sin embargo, usted es libre de 
	agregar los campos y metodos que desee.
*/
public class AFD{

	int statesNumber;
	int[] finalState;
	int[][] transitions;
	char[] alphabet;
	/*
		Implemente el constructor de la clase AFD
		que recibe como argumento un string que 
		representa el path del archivo que contiene
		la informacion del afd (i.e. "Documentos/archivo.afd").
		Puede utilizar la estructura de datos que desee
	*/
	public AFD(String path){
		try{
			Scanner file = new Scanner(new File(path));

		// numero de estados
		this.statesNumber = Integer.parseInt(file.nextLine());

		// estado final.
		String[] finalStr = file.nextLine().split(",");
		this.finalState = new int[finalStr.length];
		for(int i = 0; i < finalStr.length; i++){
			this.finalState[i] = Integer.parseInt(finalStr[i]);
		}

		// alfabeto
		String[] alphStr = file.nextLine().split(",");
		this.alphabet = new char[alphStr.length];
		for(int i = 0; i < alphStr.length; i++){
			this.alphabet[i] = alphStr[i].charAt(0);
		}

		// transiciones
		this.transitions = new int[this.alphabet.length][statesNumber];

		int count = 0;
		while(file.hasNextLine()){
			String[] transStr = file.nextLine().split(",");
			for(int i = 0; i < transStr.length; i++){
				transitions[count][i] = Integer.parseInt(transStr[i]);
			}
			count++;
		}

		file.close();
		}catch(FileNotFoundException e){
			System.out.println("ERROR! Archivo no encontrado, revisa bien tu direccion.");
			}
	}

	/*
		Implemente el metodo transition, que recibe de argumento
		un entero que representa el estado actual del AFD y un
		caracter que representa el simbolo a consumir, y devuelve 
		un entero que representa el siguiente estado
	*/
	public int getTransition(int currentState, char symbol){
		// ver en qué posición está el symbol y luego hacer un transitions(symbolPos) para saber en 
		int symPos = 0;

		for(int i = 0; i < this.alphabet.length; i++){
			if(this.alphabet[i] == symbol){
				symPos = i;
			}
		}
		return this.transitions[symPos][currentState];
	}

	/*
		Implemente el metodo evaluate, que recibe como argumento
		un String que representa la cuerda a evaluar, y devuelve
		un boolean dependiendo de si la cuerda es aceptada o no 
		por el afd
	*/
	public boolean evaluate(String string){
		// convertir el string a un arreglo de chars
		String[] stringStr = string.split("");
		char[] str = new char[stringStr.length];
		for(int i = 0; i < stringStr.length; i++){
			str[i] = stringStr[i].charAt(0);
		}

		// evaluacion
		int state = 1;
		for(int i = 0; i < str.length; i++){
			state = getTransition(state, str[i]);
		}

		return isFinal(state);

	}

	/*
		Implemente el metodo evaluate_many, que recibe como argumento
		un arreglo de Strings que representa las cuerda a evaluar, y devuelve
		un arreglo booleans dependiendo de si cada cuerda es aceptada o no 
		por el afd
	*/
	public boolean[] evaluateMany(String[] strings){
		boolean[] ret = new boolean[strings.length];
		for(int i = 0; i < strings.length; i++){
			ret[i] = evaluate(strings[i]);
		}
		
		return ret;
	}

	/*
		Implemente el metodo isFinal, que devuelve true si el estado enviado
		es un estado final, y false si no lo es
	*/
	public boolean isFinal(int currentState){
		for(int i : this.finalState){
			if(currentState == i){
				return true;
			}
		}
		return false;
	}
}