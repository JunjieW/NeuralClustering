package nyu.pa.neuralnetwork;

public class Trainer {
	double[] inputs;
	int answer;
	
	Trainer(double x, double y, int a) {
		inputs = new double[3];
		inputs[0] = x;
		inputs[1] = y;
		inputs[2] = 1;
		answer = 0;
	}
}
