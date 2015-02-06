import java.io.*;
import java.util.Scanner;

public class PowerBallDriver {
	
	public PowerBallDriver() {
	
	}
	
	public static void main(String[] args) {
		try {
			File newFile = new File("draw-data.txt");
			
			if (newFile.exists()) {
				newFile.delete();
				newFile.createNewFile();
			}
			else {
				newFile.createNewFile();
			}
		
			File file = new File("winnums-text.txt");
			Scanner scanner = new Scanner(file);
			PowerBall power = new PowerBall();
			int num1 = 0;
			int num2 = 0;
			int num3 = 0;
			int num4 = 0;
			int num5 = 0;
			int powerBall = 0;
			String in = "";
			
			in = scanner.nextLine();
			
			while (scanner.hasNext()) {
				in = scanner.next();
				
				num1 = scanner.nextInt();
				power.setWB1(num1, power.getWB1(num1) + 1);
				
				num2 = scanner.nextInt();
				power.setWB2(num2, power.getWB2(num2) + 1);
				
				num3 = scanner.nextInt();
				power.setWB3(num3, power.getWB3(num3) + 1);
				
				num4 = scanner.nextInt();
				power.setWB4(num4, power.getWB4(num4) + 1);
				
				num5 = scanner.nextInt();
				power.setWB5(num5, power.getWB5(num5) + 1);
				
				powerBall = scanner.nextInt();
				power.setPB(powerBall, power.getPB(powerBall) + 1);
				
				power.analyzeDraw(in, num1, num2, num3, num4, num5, powerBall);
				
				if (scanner.hasNextInt()) {
					num1 = scanner.nextInt();
				}
				
			}
			
			power.printFrequencies();
			
			
			
			
			scanner.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}