package nyu.pa.neuralnetwork;

import java.util.Random;

public class Perceptron {
	double[] weights;
	double c = 0.01;
	
	Perceptron(int n) {
		this.weights = new double[n];
		Random rd = new Random();
		for (int i = 0; i < this.weights.length; i++ ) {
			this.weights[i] = rd.nextDouble() * 2 - 1;
			
//			double weight = rd.nextDouble() * 2.1 - 1; 
//			while (weight > 1 || weight < -1) {
//				 weight = rd.nextDouble() * 2.1 - 1; 
//			}		
//			this.weights[i] = weight; // range [-1,1]
		}
	}
	
	int feedForward(double[] inputs) {
		double sum = 0;
		System.out.println("Start feed forward...");
		for (int i = 0; i < this.weights.length; i++ ) {
			sum += inputs[i] * this.weights[i];
		}
		
		return activate(sum);
	}
	
	int activate(double sum) {
		System.out.println("Activate...");
		if (sum > 0) return 1;
		else return -1;
	}
	
	void train(double[] inputs, int desired) {
		int guess = feedForward(inputs);
		double error = desired - guess;
		for (int i = 0; i < this.weights.length; i++ ) {
			this.weights[i] += this.c * error * inputs[i];
		}
	}
	
	public static void main(String[] args) {
		Perceptron p = new Perceptron(3);
		double[] point = {50, -12, 1};
		int result = p.feedForward(point);
 	}
	
}
