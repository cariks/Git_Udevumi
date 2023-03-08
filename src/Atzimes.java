import java.text.DecimalFormat;
import java.util.Scanner;

public class Atzimes {

	public static void main(String[] args) {
		int studsk, kritsk;
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.#");
		
		do{
			System.out.println("Cik studentiem aprçíinât vçrtçjumu?");
			studsk = scan.nextInt();
			
		}while(studsk<1);
		
		String[] studenti = new String[studsk];
		
		do{
			System.out.println("Cik bûs vçrtçðanas kritçriji?");
			kritsk = scan.nextInt();
		}while(kritsk<1);
		String[] kriteriji = new String[kritsk];
		int[] kriterijaSvars = new int[kritsk];
		int[][] kriterijuVertejumi = new int[studsk][kritsk];
		double[] semestraVertejumi = new double [studsk];
		for(int i=0; i<studsk; i++){
			System.out.println("Ievadi "+(i+1)+". studentu");
			studenti[i] = scan.next();
		}
		
	}
}