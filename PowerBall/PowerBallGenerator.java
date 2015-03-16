import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
public class PowerBallGenerator {

	private double avgStdDev;
	private int count = 0;
	
	
	public PowerBallGenerator() {
		String token = "";
		try {
			File file = new File("draw-data.txt");
			Scanner scanner = new Scanner(file);
		
			while (scanner.hasNext()) {
				token = scanner.next();
				if (token.equals("Deviation:")) {
					token = scanner.next();
					count++;
					avgStdDev = avgStdDev + Double.parseDouble(token);
				}
				
			}
			avgStdDev = avgStdDev / count;
			scanner.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public double getAvgStdDev() {
		return avgStdDev;
	}
	
	public ArrayList<Integer> draw() {
		Random random = new Random();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		boolean x = false;
		while (x == false) {
			while (nums.size() < 5) {
				int num = random.nextInt((59 - 1) + 1) + 1;
				if (nums.contains(num)) {
					
				}
				else {
					nums.add(num);
				}
			}
			int sum = nums.get(0) + nums.get(1) + nums.get(2) + nums.get(3) + nums.get(4);
			int sumSquared = nums.get(0)*nums.get(0) + nums.get(1)*nums.get(1) + nums.get(2)*nums.get(2) + nums.get(3)*nums.get(3) + nums.get(4)*nums.get(4);
			int mean = sum / 5;
			int variance = ((sumSquared/5) - (mean*mean));
			double stdDev = Math.sqrt(variance);
			
			int pb = random.nextInt(35 - 1 + 1) + 1;
			nums.add(pb);
			
			if ((stdDev > avgStdDev + 1) || (stdDev < avgStdDev - 1)) {
				nums.clear();
			}
			else {
				x = true;
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		PowerBallGenerator pbg = new PowerBallGenerator();
		double x = pbg.getAvgStdDev();
		System.out.println(x);
	}
	
	


}