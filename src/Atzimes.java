import java.text.DecimalFormat;
import java.util.Scanner;

public class Atzimes {

	public static void main(String[] args) {
		int studsk, kritsk;
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.#");
		
		do{
			System.out.println("Sveiki");
			System.out.println("Cik studentiem apr��in�t v�rt�jumu?");
			studsk = scan.nextInt();
			
		}while(studsk<1);
		
		String[] studenti = new String[studsk];
		
		do{
			System.out.println("Cik b�s v�rt��anas krit�riji?");
			kritsk = scan.nextInt();
		}while(kritsk<1);
		String[] kriteriji = new String[kritsk];
		int[] kriterijaSvars = new int[kritsk];
		int[][] kriterijuVertejumi = new int[studsk][kritsk];
		double[] semestraVertejumi = new double [studsk];
		for(int i=0; i<studsk; i++){
			System.out.println("Ievadi "+(i+1)+". studentu: ");
			studenti[i] = scan.next();
		}
		
		int maxSvars = 100;
		for(int i=0; i<kriteriji.length; i++){
			System.out.println("Defin� "+(i+1)+". krit�riju: ");
			kriteriji[i] = scan.next();
			
			do{
				System.out.println("Ievadi "+kriteriji[i]+" svaru (1-100%):");
				kriterijaSvars[i] = scan.nextInt();
			}while(kriterijaSvars[0]>maxSvars ||
					kriterijaSvars[i]<1 || 
					(kriterijaSvars[0]==100  && kritsk>1));
			maxSvars -= kriterijaSvars[i];
		}
		
		for(int i=0; i<kriterijuVertejumi.length; i++){
			for(int j=0; j<kriterijuVertejumi[i].length; j++){
				do{
					System.out.println("Ievadi "+studenti[i]+
					" v�rt�jumu par krit�riju "+kriteriji[j]);
					kriterijuVertejumi[i][j] = scan.nextInt();
				}while(kriterijuVertejumi[i][j]<0 ||
						kriterijuVertejumi[i][j]>10);
			}
		}
		
		//Gala rezult�tu apr��ins
		double rezultats; 
		for(int i=0; i<studenti.length; i++){
			rezultats = 0;
			for(int j=0; j<kriteriji.length; j++){
				rezultats += ((double) kriterijaSvars[j]/100 * kriterijuVertejumi[i][j]);
			}
			semestraVertejumi[i] = rezultats;
		}
		//Gala v�rt�jumu izvade
		for(int i=0; i<studenti.length; i++){
			for(int j=0; j<kriteriji.length; j++){
				System.out.println("Studenta "+studenti[i]+
						" v�rt�jums par krit�riju "+kriteriji[j]+
						" ir "+kriterijuVertejumi[i][j]+", kura svars ir "+
						kriterijaSvars[j]);
			}
			System.out.println("Semestra v�rt�jums ir "
					+df.format(semestraVertejumi[i])+"\n");
		}
		scan.close();
	}
}