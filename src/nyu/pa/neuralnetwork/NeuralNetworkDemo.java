package nyu.pa.neuralnetwork;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NeuralNetworkDemo extends JPanel {
	Perceptron ptron;
	Trainer[] trainers = new Trainer[2000];
	int count = 0;
	
	Random rd = new Random();
	
	int width = 640;
	int hight = 360;
	
	NeuralNetworkDemo() {
		this.setBackground(Color.white);
		// setup training points
		this.setup();
	}
	
	// the line for classificaiton
	double f(double x) {
		return 2*x+1;
	}
	
	// setup canvas
	void setup() {
		ptron = new Perceptron(3);
		
		for (int i = 0; i < trainers.length; i++) {
			double x = rd.nextDouble() * this.width - this.width/2;
			double y = rd.nextDouble() * this.hight - this.hight/2;
			
			int answer = 1;
			if (y < this.f(x)) answer = -1;
			
			trainers[i] = new Trainer(x, y, answer);
		}
	}
	
	void draw() {
		this.ptron.train(trainers[count].inputs, trainers[count].answer);
		this.count = (this.count + 1) % this.trainers.length;
		
		for (int i = 0; i < count; i++) {
			int guess = this.ptron.feedForward(trainers[i].inputs);
			if (guess > 0) 
				;// set color for dot
			else
				;// set color for dot
			
			
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
        double leftX = translateXToDraw(- this.width/2);
        double topY = translateYToDraw(f(- this.width/2));
        double rightX = translateXToDraw(this.width/2);
        double bottomY = translateYToDraw(f(this.width/2));
		// Draw the line
		Line2D line = new Line2D.Double(leftX, topY, rightX, bottomY);//创建线条对象（4个参数表示两个端点坐标）
		g2.draw(line);
		// System.out.println(- this.width/2 + ", " + f(- this.width/2) + ", " + this.width/2 + ", " + f(this.width/2));
		// System.out.println(leftX + ", " + topY + ", " + rightX + ", " + bottomY);
		
	}
	
	int translateXToDraw(double x) {
		return  (int)x + this.width/2;
	}
	
	int translateYToDraw(double y) {		
		return -((int)y - this.hight/2);
	}
	public static void main(String[] args) {
		JFrame jf = new JFrame("Nerural Network Demo by Junjie Wei");
		NeuralNetworkDemo nn = new NeuralNetworkDemo();
		jf.setSize(nn.width, nn.hight);
		jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.add(nn);
		
		jf.setVisible(true);
 	}
}
