package dragonball.view;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
	static Timer timer = new Timer();
	static int seconds = 0;

	public static void main(String[] agrs) {

		MyTimer();

	}

	public static void MyTimer() {

		TimerTask task;

		task = new TimerTask() {
			@Override
			public void run() {
				if (seconds < 31) {
					switch (seconds) {
					case 1:
						System.out.print("b");
						break;
					case 2:
						System.out.print("7");
						break;
					case 3:
						System.out.print("b");
						break;
					case 4:
						System.out.print("k");
						break;
					case 5:
						System.out.print(" ");
						break;
					case 6:
						System.out.print("y");
						break;
					case 7:
						System.out.print("a");
						break;
					case 8:
						System.out.print("s");
						break;
					case 9:
						System.out.print("t");
						break;
					case 10:
						System.out.print("a");
						break;
					case 11:
						System.out.print(" ");
						break;
					case 12:
						System.out.print("w");
						break;
					case 13:
						System.out.print("e");
						break;
					case 14:
						System.out.print(" m");
						break;
					case 15:
						System.out.print("n");
						break;
					case 16:
						System.out.print("8");
						break;
					case 17:
						System.out.print("e");
						break;
					case 18:
						System.out.print("r");
						break;
					case 19:
						System.out.print(" ");
						break;
					case 20:
						System.out.print("c");
						break;
					case 21:
						System.out.print("h");
						break;
					case 22:
						System.out.print("e");
						break;
					case 23:
						System.out.print("a");
						break;
					case 24:
						System.out.print("t");
						break;
					case 25:
						System.out.print("i");
						break;
					case 26:
						System.out.print("n");
						break;
					case 27:
						System.out.print("g");
						break;
					case 28:
						System.out.print(" ");
						break;
					case 29:
						System.out.print(":");
						break;
					case 30:
						System.out.print("p");
						break;
					}

					// System.out.print("7");
					// System.out.print("b");
					// System.out.print("k");
					seconds++;
				} else {
					// stop the timer
					cancel();
				}
			}
		}
		;
		timer.schedule(task, 0, 300);

	}

}
