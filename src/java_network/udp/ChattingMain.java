package java_network.udp;

public class ChattingMain {

	public static void main(String[] args) {
		ChattingFram messengerA = new ChattingFram("MessengerA", 5000, 6000, "127.0.0.1");
		ChattingFram messengerB = new ChattingFram("MessengerB", 6000, 5000, "127.0.0.1");
	}

}
