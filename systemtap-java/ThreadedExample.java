import java.lang.*;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class ThreadedExample
{

    public static void printMessage(int message)
    {
    System.out.println("message: " + message);
    }

    public static void printMessage(long message)
    {
    System.out.println("message: " + message);
    }

    public static void main(String[] args)
    {
    try
        {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String next = in.readLine();
        while(next != null && next.length() > 0 && !next.contains("end"))
            {
            final String arg = next;
            final int i = 42;
            final long j = 987234864;
            Thread thread = new Thread(arg)
                {
                public void run()
                {
                    if(arg.equals("int"))
                        printMessage(i);
                    else if(arg.equals("long"))
                         printMessage(j);
                    else
                    System.out.println("Neither of the types");
                }
                };
            thread.start();
            try
                {
                thread.join();
                } catch (Exception e){}
            next = in.readLine();
            }
        } catch (Exception e){}
    }
}
