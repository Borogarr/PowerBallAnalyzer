import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

public class PowerBall {

	int[] wb1;
	int[] wb2;
	int[] wb3;
	int[] wb4;
	int[] wb5;
	int[] pb;
	
	public PowerBall() {
		wb1 = new int[60];
		wb2 = new int[60];
		wb3 = new int[60];
		wb4 = new int[60];
		wb5 = new int[60];
		pb = new int[36];
	}
	
	public int getWB1(int index) {
		return wb1[index];
	}
	
	public void setWB1(int index, int value) {
		wb1[index] = value;
	}
	
	public int getWB2(int index) {
		return wb2[index];
	}
	
	public void setWB2(int index, int value) {
		wb2[index] = value;
	}
	
	public int getWB3(int index) {
		return wb3[index];
	}
	
	public void setWB3(int index, int value) {
		wb3[index] = value;
	}
	
	public int getWB4(int index) {
		return wb4[index];
	}
	
	public void setWB4(int index, int value) {
		wb4[index] = value;
	}
	
	public int getWB5(int index) {
		return wb5[index];
	}
	
	public void setWB5(int index, int value) {
		wb5[index] = value;
	}
	
	public int getPB(int index) {
		return pb[index];
	}
	
	public void setPB(int index, int value) {
		pb[index] = value;
	}
	
	public void printFrequencies() {
	
		try {
			PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
			writer.println("Frequency of numbers:");
			
			for (int i = 1; i < 60; i++) {
				if ( i < 36) {
					writer.println(i + ":" + " Ball 1 - " + wb1[i] + " Ball 2 - " + wb2[i] + " Ball 3 - " + wb3[i] + " Ball 4 - " + wb4[i] + " Ball 5 - " + wb5[i] + " Total White - " + (wb1[i] + wb2[i] + wb3[i] + wb4[i] + wb5[i]) + " as PB - " + pb[i]);
				}
				else {
					writer.println(i + ":" + " Ball 1 - " + wb1[i] + " Ball 2 - " + wb2[i] + " Ball 3 - " + wb3[i] + " Ball 4 - " + wb4[i] + " Ball 5 - " + wb5[i] + " Total White - " + (wb1[i] + wb2[i] + wb3[i] + wb4[i] + wb5[i]));
				}
			}
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void analyzeDraw(String drawDate, int num1, int num2, int num3, int num4, int num5, int powerBall) {
		int sum = num1 + num2 + num3 + num4 + num5;
		int mean = sum / 5;
		int sumSquared = (num1 * num1) + (num2*num2) + (num3*num3) + (num4*num4) + (num5*num5);
		int variance = ((sumSquared / 5) - (mean*mean));
		double standardDeviation = Math.sqrt(variance);
		
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("draw-data.txt",true)));
			out.write(drawDate);
			out.println("Numbers: " + num1+ " " + num2 + " " + num3 + " " + num4 + " " + num5 + " PowerBall " + powerBall);
			out.write(" Sum of White Balls: " + (sum) + " Sum Squared: " + sumSquared + " Mean: " + mean);
			out.println(" Variance: " + variance + " Standard Deviation: " + standardDeviation);
			
			out.close();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}