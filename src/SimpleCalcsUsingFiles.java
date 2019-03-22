import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleCalcsUsingFiles
{
    public static void main(String[] args)
    {
        ArrayList<Float> numbers = getFloats();
        writeToFile(numbers, "numbers.txt");
        ArrayList<Float> values = readFromFile("numbers.txt");
        calculate(values);



        /*Scanner input = new Scanner(System.in);
        int howMany;
        float sum;
        float average;
        float product;
        System.out.print("How many numbers will you be inputting?");
        howMany = input.nextInt();
        PrintWriter writer = new PrintWriter("numbers.txt");
        writer.println(howMany);

        while (howMany >= 0)
        {
            System.out.println("Enter a decimal number: ");
            float numberIn = input.nextFloat();
            writer.println(numberIn);

            howMany--;
        }
        howMany = input.nextInt("numbers.txt")).useDelimiter("\\Z").next();
        while (howMany >= 0)
        {
            float content = new Scanner(new File("numbers.txt")).useDelimiter("\\Z").next();
            sum = content+content;
            average = sum/content;
            product = content*content;
            System.out.printf("The sum is %d.%n", sum);
            System.out.printf("The average is %d.%n", average);
            System.out.printf("The product is %d.%n", product);

        }*/

    }

    private static void calculate(ArrayList<Float> numbers){
        float sum = 0;
        float average = 0;
        float product = 1;
        for (int i = 0; i<numbers.size(); i++){
            sum += numbers.get(i);
            product *= numbers.get(i);
        }
        average = sum/numbers.size();
        System.out.println("The sum is " + sum + ".");
        System.out.println("The average is " + average + ".");
        System.out.println("The product is " + product + ".");
        //System.out.printf("The sum is %d.%n", sum);
        //System.out.printf("The average is %d.%n", average);
        //System.out.printf("The product is %d. %n", product);
    }

    private static void writeToFile(ArrayList<Float> numbers, String fileName){
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(numbers.size() + "\n");
            for (int i = 0; i < numbers.size(); i++) {
                writer.write(numbers.get(i).toString() + "\n");
            }
            writer.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }

    }

    private static ArrayList<Float> readFromFile(String fileName){
        ArrayList<Float> output = new ArrayList<Float>();
        int floatCount = 0;
        File file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            floatCount = Integer.parseInt(br.readLine());
            for (int i = 0; i<floatCount; i++){
                output.add(Float.parseFloat(br.readLine()));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return output;
    }


    private static ArrayList<Float> getFloats() {
        ArrayList<Float> output = new ArrayList<Float>();
        int floatCount = 0;
        System.out.print("How many decimal numbers would you like to enter? ");
        Scanner input = new Scanner(System.in);
        floatCount = input.nextInt();
        for (int i = 0; i<floatCount; i++){
            System.out.print("Enter a number: ");
            Float f = input.nextFloat();
            output.add(f);
        }
        input.close();
        return output;
    }



}
