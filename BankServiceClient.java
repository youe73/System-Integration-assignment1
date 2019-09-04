import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class BankServiceClient {

    public static double numberToDisplay;

    public static void main(String[] args)
    {
        try {
            System.out.println("Client started....");
            Socket socket = new Socket("localhost",6666);

            System.out.println("Welcome to Bank service, you are now connected to make transactions");
            System.out.println("Press + for deposit(add) OR - for withdrawal(subtract)...");

            String request, response;
            Scanner inputFromServer = new Scanner(socket.getInputStream());
            Scanner inputFromkeyboard = new Scanner(System.in);
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);

            while ((request = inputFromkeyboard.nextLine())!=null)
            {
                output.println(request);
                response = inputFromServer.nextLine();
                System.out.println(response);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
