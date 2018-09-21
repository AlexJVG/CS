import java.lang.*; 
import java.io.*; 
import java.util.*; 
public class BinaryConvert{
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		System.out.println("What operation do you want to do? \n1.Binary to Decimal\n2.Decimal to Binary");
		int input = kb.nextInt();
		if(input==1){
			System.out.print("\033[H\033[2J");
			System.out.println("Enter the binary that you want to convert to decimals");
			int binary =kb.nextInt();
			int decimal=0;
			String binarys = Integer.toString(binary);
			int[] binarya = new int[binarys.length()];
			for(int i = 0; i<binarys.length();i++){
				binarya[i] = binarys.charAt(i)-'0';
			}
			for(int i=1; i < binarys.length()+1;i++){
				decimal+=binarya[binarya.length-i]*(Math.pow(2,i-1));
			}
			System.out.println("Binary >>>> Decimal: " + decimal);
		}
		else if(input==2){
			System.out.print("\033[H\033[2J");
			System.out.println("Enter the decimal that you want to convert to binary");
			int decimal =kb.nextInt();
			String binary="";
			int bitlocation = 0;
			while(decimal != 0){
				if(bitlocation ==0){
					if(decimal%2==1){
					decimal = decimal/2;
					binary += "1";
					}
					else if(decimal%2==0){
						decimal = decimal/2;
						binary += "0";
					}
				}
				else{
					if(decimal%2==1){
						decimal = decimal/2;
						binary += "1";
					}
					else if(decimal%2==0){
						decimal = decimal/2;
						binary += "0";
					}
				}
			}
			StringBuilder binary1 = new StringBuilder();
			binary1.append(binary);
			binary1 = binary1.reverse();
			System.out.println("Decimal >>>> Binary: " + binary1);		
		}
	}
}