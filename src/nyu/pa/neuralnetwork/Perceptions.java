package nyu.pa.neuralnetwork;

import java.util.Random;

public class Perceptions {
	double[] weights;
	Perceptions(int n) {
		this.weights = new double[n];
		Random rd = new Random();
		for (int i = 0; i < this.weights.length; i++ ) {
			this.weights[i] = 2 * rd.nextDouble() - 1; // range [-1,1)
		}
	}
	
	int feedForward(double[] inputs) {
		double sum = 0;
		for (int i = 0; i < this.weights.length; i++ ) {
			sum += inputs[i] * this.weights[i];
		}
		
		return activate(sum);
	}
	
	int activate(double sum) {
		if (sum > 0) return 1;
		else return -1;
	}
	
	public static void main() {
		Perceptron p = new Perceptron(3);
	}
	
}
